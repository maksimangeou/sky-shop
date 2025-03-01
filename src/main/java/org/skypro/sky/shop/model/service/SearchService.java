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

    public List<SearchResult> search(String term) {
        List<SearchResult> result = new ArrayList<>();
        return storageService.getAllCollection().stream()
                .filter(i -> !i.searchTerm(term).equals(Searchable.CODE_NULL))
                .collect(Collectors.toCollection() - > new ArrayList<>());

    }


}
