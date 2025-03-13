package org.skypro.sky.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.basket.ProductBasket;
import org.skypro.sky.shop.model.product.DiscountedProduct;
import org.skypro.sky.shop.model.product.SimpleProduct;
import org.skypro.sky.shop.model.search.Searchable;
import org.skypro.sky.shop.model.service.BasketService;
import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    private ProductBasket productBasket;
    private StorageService storageService;
    private BasketService basketService;

    @Test
    public void givenNotExistProduct_whenPutProductInBasket_thenFailure() {
        StorageService storageServiceMock = mock(StorageService.class);
        List<Searchable> items = Arrays.asList(new SimpleProduct(UUID.randomUUID(), "апельсин", 100),
                new DiscountedProduct(UUID.randomUUID(), "шоколад", 39.99, 20),
                new Article(UUID.randomUUID(), "Польза апельсинов", "Текст номер 1 про апельсины"));
        when(storageServiceMock.getAllCollection()).thenReturn(items);
    }
}
