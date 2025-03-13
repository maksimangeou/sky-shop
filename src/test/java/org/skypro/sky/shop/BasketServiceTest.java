package org.skypro.sky.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.basket.ProductBasket;
import org.skypro.sky.shop.model.basket.UserBasket;
import org.skypro.sky.shop.model.exception.NoSuchProductException;
import org.skypro.sky.shop.model.product.Product;
import org.skypro.sky.shop.model.product.SimpleProduct;
import org.skypro.sky.shop.model.service.BasketService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    private ProductBasket productBasket;
    private StorageService storageService;
    private BasketService basketService;

    @BeforeEach
    void setUp() {
        productBasket = Mockito.mock(ProductBasket.class);
        storageService = Mockito.mock(StorageService.class);
        basketService = new BasketService(productBasket, storageService);
    }

    @Test
    void givenNotExistProduct_whenPutProductInBasket_thenFailure() {
        UUID productId = UUID.randomUUID();
        when(storageService.getProductById(productId)).thenReturn(Optional.empty());

        NoSuchProductException exception = assertThrows(NoSuchProductException.class, () -> {
            basketService.addProductIntoBasket(productId);
        });

        assertEquals("Product with " + productId + " is not available", exception.getMessage());
    }

    @Test
    void addProductIntoBasket_shouldCallAddProduct_whenProductExists() {
        UUID productId = UUID.randomUUID();
        Product product = new SimpleProduct(productId, "Test Product", 100);
        when(storageService.getProductById(productId)).thenReturn(Optional.of(product));

        basketService.addProductIntoBasket(productId);

        verify(productBasket, times(1)).addProductInBasket(productId);
    }

    @Test
    void getUserBasket_shouldReturnEmptyBasket_whenProductBasketIsEmpty() {
        when(productBasket.getProductInBasket()).thenReturn(Collections.emptyMap());

        UserBasket userBasket = basketService.getUserBasket();

        assertTrue(userBasket.getUserBasket().isEmpty());
    }

    @Test
    void getUserBasket_shouldReturnUserBasketWithItems_whenProductBasketHasItems() {
        UUID productId = UUID.randomUUID();
        Product product = new SimpleProduct(productId, "Test Product", 100);
        when(productBasket.getProductInBasket()).thenReturn(Collections.singletonMap(productId, 1));
        when(storageService.getAllProducts()).thenReturn(Collections.singletonList(product));

        UserBasket userBasket = basketService.getUserBasket();

        assertEquals(1, userBasket.getUserBasket().size());
        assertEquals(productId, userBasket.getUserBasket().get(0).getProduct().getId());
    }
}
