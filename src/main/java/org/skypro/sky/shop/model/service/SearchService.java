package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.search.SearchResult;
import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String term) {
        Collection<SearchResult> result = new ArrayList<>();
        for (Searchable i : storageService.getAllCollection()) {
            if (!i.searchTerm(term).equals(Searchable.CODE_NULL)) {
                result.add((SearchResult) i);
            }
        }
        return result;
    }


}
