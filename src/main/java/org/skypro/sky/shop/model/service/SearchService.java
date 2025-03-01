package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.search.SearchResult;
import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String term) {
        List<SearchResult> result = new ArrayList<>();
        for(Searchable i : storageService.getAllCollection()) {
            if (!i.searchTerm(term).equals(Searchable.CODE_NULL)) {
                result.add(new SearchResult(i.getId(),i.getName(),i.getSearchedContent()));
            }
        }
        return result;
    }


}
