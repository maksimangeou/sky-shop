package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.product.*;
import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> product;
    private final Map<UUID, Article> article;

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
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(),"Молоко5", "Лактоза5 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко6", "Лактоза6 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(),"Еще одна статья об апельсинах", "Текст два"));
    }

    public Map<UUID, Product> getProduct() {
        return product;
    }

    public Map<UUID, Article> getArticle() {
        return article;
    }

    public List<Searchable> getAllProducts() {
        return new ArrayList<>(product.values());
    }

    public List<Searchable> getAllArticles() {
        return new ArrayList<>(article.values());
    }

    public List<Searchable> getAllCollection() {
        List<Searchable> fullList = new ArrayList<>(getAllProducts());
        fullList.addAll(getAllArticles());
        System.out.println(fullList);
        return fullList;
    }
}
