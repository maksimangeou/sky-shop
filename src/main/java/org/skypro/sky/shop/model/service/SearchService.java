package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<Searchable> getAllCollection() {
        List<Searchable> fullList = new ArrayList<>(storageService.getAllProducts());
        fullList.addAll(storageService.getAllArticles());
        return fullList;
    }
}
