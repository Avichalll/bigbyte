package com.davil.user_service.common;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)



public class PageResponse<T> {
    
    private List<T> content;
    private PageMetadata metadata;
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PageMetadata {
        private int page;           // Current page number (0-indexed)
        private int size;           // Items per page
        private long totalElements; // Total items across all pages
        private int totalPages;     // Total number of pages
        private boolean first;      // Is first page
        private boolean last;       // Is last page
        private boolean hasNext;    // Has next page
        private boolean hasPrevious; // Has previous page
    }
    
    // Factory method to create from Spring's Page object
    public static <T> PageResponse<T> of(Page<T> page) {
        PageMetadata metadata = PageMetadata.builder()
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .first(page.isFirst())
                .last(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .build();
        
        return PageResponse.<T>builder()
                .content(page.getContent())
                .metadata(metadata)
                .build();
    }
}