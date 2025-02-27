package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageService {
    private final Map<UUID, Product> product;
    private final Map<UUID, Article> article;

    public StorageService() {
        product = new HashMap<>();
        article = new HashMap<>();
    }

    public Map<UUID, Product> getProduct() {
        return product;
    }

    public Map<UUID, Article> getArticle() {
        return article;
    }
}
