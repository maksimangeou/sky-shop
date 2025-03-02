package org.skypro.sky.shop.model.service;

import org.skypro.sky.shop.model.basket.ProductBasket;
import org.skypro.sky.shop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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
}
