package org.skypro.sky.shop.controller;

import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.product.Product;
import org.skypro.sky.shop.model.search.Searchable;
import org.skypro.sky.shop.model.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
public class ShopController {
    private final StorageService storageService;

    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Collection<Searchable> getAllProducts(){
        return  storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Collection<Searchable> getAllArticles() {
        return storageService.getAllArticles();
    }
}
