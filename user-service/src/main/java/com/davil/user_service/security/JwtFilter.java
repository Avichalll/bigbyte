package com.davil.user_service.security;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.davil.user_service.handler.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final ObjectMapper objectMapper;

    private static final List<String> PUBLIC_PATHS = Arrays.asList(
            "/api/auth");    


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        log.info("Processing request: {} {}", request.getMethod(), request.getRequestURI());
        // logCookies(request);

      

        if (request.getMethod().equals("OPTIONS")) {
            log.info("Skipping authentication for OPTIONS request");
            filterChain.doFilter(request, response);
            return;
        }
        String path = request.getServletPath();
        if (isPublicPath(path)) {
            log.info("Skipping authentication for public path: {}", path);
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        String jwt = null;
        String userEmail = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            log.info("JWT found in Authorization header");
        }

        if (jwt == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("jwt".equals(cookie.getName())) {
                        jwt = cookie.getValue();
                        log.info("JWT found in cookies");
                        break;
                    }
                }
            }
        }

        if (jwt == null) {
            log.info("No JWT token found in request");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            userEmail = jwtService.extractUsername(jwt);
            log.info("Extracted email from JWT: {}", userEmail);
            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    log.info("JWT token is valid for user: {}", userEmail);

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    log.warn("Invalid JWT token for user: {}", userEmail);
                }
            }
        } catch (ExpiredJwtException e) {
            log.warn("JWT token expired for request: {}", request.getRequestURI());
            clearJwtCookie(response);
            sendUnauthorizedResponse(response, "Token expired. Please log in again.");
            return;
        } catch (MalformedJwtException e) {
            log.warn("Malformed JWT token: {}", e.getMessage());
            clearJwtCookie(response);
            sendUnauthorizedResponse(response, "Invalid authentication token");
            return;
        } catch (JwtException e) {
            log.error("JWT verification error: {}", e.getMessage());
            clearJwtCookie(response);
            sendUnauthorizedResponse(response, "Authentication failed");
            return;
        } catch (Exception e) {
            log.error("JWT processing error: {}", e.getMessage(), e);
            clearJwtCookie(response);
            sendUnauthorizedResponse(response, "Authentication error occurred");
            return;
        }
        filterChain.doFilter(request, response);
    }

    private boolean isPublicPath(String path) {
        return PUBLIC_PATHS.stream().anyMatch(path::contains);
    }

    private void clearJwtCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "");
        cookie.setHttpOnly(true);
        // cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // Expire immediately
        cookie.setAttribute("SameSite", "Lax");

        response.addCookie(cookie);
        log.info("Cleared JWT cookie");
    }

    private void sendUnauthorizedResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        ExceptionResponse errorResponse = ExceptionResponse.builder()
                .businessErrorCode(401)
                .businessErrorDescription("Unauthorized")
                .error(message)
                .build();

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
