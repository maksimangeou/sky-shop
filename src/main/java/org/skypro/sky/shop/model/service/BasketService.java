package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.basket.BasketItem;
import org.skypro.sky.shop.model.basket.ProductBasket;
import org.skypro.sky.shop.model.basket.UserBasket;
import org.skypro.sky.shop.model.product.Product;
import org.skypro.sky.shop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public ProductBasket getProductBasket() {
        return productBasket;
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public void addProductIntoBasket(UUID id) {
        try {
            Optional<Product> optionalProduct = storageService.getProductById(id);
            if (optionalProduct.isEmpty()) {
                throw new IllegalArgumentException();
            }
            productBasket.addProductInBasket(id);
        } catch (IllegalArgumentException e) {
            System.out.println("Product is not available");
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getMapBasket().entrySet()
                .stream()
                .flatMap(valueQuality -> storageService.getAllProducts().stream()
                        .filter(i -> i.getId().equals(valueQuality.getKey()))
                        .map(valueProduct -> new BasketItem((Product) valueProduct, valueQuality.getValue())))
                .collect(Collectors.toList());
        System.out.println(basketItems.toString());
        return new UserBasket(basketItems);
    }
}
