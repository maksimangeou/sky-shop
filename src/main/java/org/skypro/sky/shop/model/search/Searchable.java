package org.skypro.sky.shop.model.search;

import java.util.UUID;

public interface Searchable {

    String CODE_NULL = "non";

    String searchTerm(String term);

    String getSearchedContent();

    UUID getId();

    String getName();

    default String getStringRepresentation(String term) {
        return searchTerm(term) + '\n' + getSearchedContent();
    }


}
