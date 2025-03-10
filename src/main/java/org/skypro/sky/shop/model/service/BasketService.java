package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.basket.BasketItem;
import org.skypro.sky.shop.model.basket.ProductBasket;
import org.skypro.sky.shop.model.basket.UserBasket;
import org.skypro.sky.shop.model.exception.NoSuchProductException;
import org.skypro.sky.shop.model.product.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
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
            Optional<Product> optionalProduct = storageService.getProductById(id);
            if (optionalProduct.isEmpty()) {
                throw new NoSuchProductException();
            }
            productBasket.addProductInBasket(id);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getProductInBasket().entrySet()
                .stream()
                .flatMap(valueQuality -> storageService.getAllProducts().stream()
                        .filter(i -> i.getId().equals(valueQuality.getKey()))
                        .map(valueProduct -> new BasketItem((Product) valueProduct, valueQuality.getValue())))
                .collect(Collectors.toList());
        return new UserBasket(basketItems);
    }
}
