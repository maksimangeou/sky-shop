package org.skypro.sky.shop.controller;

import org.skypro.sky.shop.model.search.SearchResult;
import org.skypro.sky.shop.model.search.Searchable;
import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/products")
    public Collection<Searchable> getAllProducts(){
        return  storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Searchable> getAllArticles() {
        return storageService.getAllArticles();
    }

    @GetMapping("/all")
    public Collection<Searchable> getAllCollection() {
        return storageService.getAllCollection();
    }

    @GetMapping("/search")
    public Collection<SearchResult> getAllSearched(@RequestParam("pattern") String pattern) {
        return searchService.search(pattern);
    }
}
