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
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        UUID id4 = UUID.randomUUID();
        UUID id5 = UUID.randomUUID();
        UUID id6 = UUID.randomUUID();
        UUID id7 = UUID.randomUUID();
        product.put(id1, new SimpleProduct(id1, "апельсин", 100));
        product.put(id2, new SimpleProduct(id2, "огурцы", 199));
        product.put(id3, new DiscountedProduct(id3, "помидоры", 200, 20));
        product.put(id4, new DiscountedProduct(id4, "бананы", 249, 30));
        product.put(id5, new FixPriceProduct(id5, "молоко"));
        product.put(id6, new DiscountedProduct(id6, "шоколад", 39.99, 20));
        product.put(id7, new DiscountedProduct(id7, "картофель", 59.99, 5));

        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Польза апельсинов", "Текст номер 1 про апельсины"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Садоводы и огородники", "Текст содержит в себе огурцы и помидоры"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко1", "Лактоза1 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко2", "Лактоза2 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко3", "Лактоза3, Молоко - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко4", "Лактоза4 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко5", "Лактоза5 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Молоко6", "Лактоза6 - враг здоровью человека"));
        article.put(UUID.randomUUID(), new Article(UUID.randomUUID(), "Еще одна статья об апельсинах", "Текст два"));
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
        return fullList;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(product.get(id));
    }
}