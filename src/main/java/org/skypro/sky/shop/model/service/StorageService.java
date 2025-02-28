package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.product.*;
import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Searchable> product;
    private final Map<UUID, Searchable> article;

    public StorageService() {
        product = new HashMap<>();
        article = new HashMap<>();
        putValue();
    }

    private void putValue() {
        product.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "апельсин", 100));
        product.put(UUID.randomUUID(), new SimpleProduct(UUID.randomUUID(), "огурцы", 199));
        product.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "помидоры", 200, 20));
        product.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "бананы", 249, 30));
        product.put(UUID.randomUUID(), new FixPriceProduct(UUID.randomUUID(), "молоко"));
        product.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "шоколад", 39.99, 20));
        product.put(UUID.randomUUID(), new DiscountedProduct(UUID.randomUUID(), "картофель", 59.99, 5));

        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Польза апельсинов", "Текст номер 1 про апельсины"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Садоводы и огородники", "Текст содержит в себе огурцы и помидоры"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(),"Молоко1", "Лактоза1 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(),"Молоко2", "Лактоза2 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(),"Молоко3", "Лактоза3, Молоко - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко4", "Лактоза4 - враг здоровью человека"));
        Article article7 = new Article("Молоко5", "Лактоза5 - враг здоровью человека");
        Article article8 = new Article("Молоко6", "Лактоза6 - враг здоровью человека");
        Article article9 = new Article("Еще одна статья об апельсинах", "Текст два");
    }

    private void putValueArticle(Searchable searchable) {
        product.put(UUID.randomUUID(), searchable);
    }

    public Map<UUID, Searchable> getProduct() {
        return product;
    }

    public Map<UUID, Searchable> getArticle() {
        return article;
    }

    public Map<UUID, Product> showAllCollection() {
        Map<UUID, Product> mapLocal = null;
        for (Product valueProduct : product.values()) {
            valueProduct.toString();
        }
    }
}
