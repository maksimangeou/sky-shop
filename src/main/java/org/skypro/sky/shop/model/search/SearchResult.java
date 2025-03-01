package org.skypro.sky.shop.model.search;

import java.util.UUID;

public class SearchResult {
    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(Searchable searchable) {
        this.id = searchable.getId();
        this.name = searchable.getName();
        this.contentType = searchable.getSearchedContent();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

//    public static SearchResult fromSearchable(Searchable searchable) {
//        return new SearchResult(searchable.getId(),searchable.getName(), searchable.getSearchedContent());
//    }
}
