package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.search.SearchResult;
import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService() {
        this.storageService = new StorageService();
    }

    public Collection<SearchResult> search(String pattern) {
        return storageService.getAllCollection().stream()
                .filter(i -> !i.searchTerm(pattern).equals(Searchable.CODE_NULL))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}