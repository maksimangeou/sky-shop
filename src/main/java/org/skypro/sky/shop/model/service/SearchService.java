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

    public TreeSet<SearchResult> search(String term) {
        return storageService.getAllCollection().stream()
                .filter(i -> !i.searchTerm(term).equals(Searchable.CODE_NULL))
                .map(SearchResult::new)
                .collect(Collectors.toCollection(TreeSet::new));

    }


}
