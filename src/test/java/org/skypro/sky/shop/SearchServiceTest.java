package org.skypro.sky.shop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.product.DiscountedProduct;
import org.skypro.sky.shop.model.product.SimpleProduct;
import org.skypro.sky.shop.model.search.SearchResult;

import org.skypro.sky.shop.model.search.Searchable;
import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {


    @Test
    public void givenEmptyStorage_whenSearchItem_thenEmpty() {
        String pattern = "апельсин";
        StorageService storageServiceMock = mock(StorageService.class);
        SearchService searchService = new SearchService(storageServiceMock);
        when(storageServiceMock.getAllCollection()).thenReturn(Collections.emptyList());

        Collection<SearchResult> results = searchService.search(pattern);
        System.out.println(results);

        assertTrue(results.isEmpty());
    }

    @Test
    public void givenSearchResult_whenSearchProductNotInStorage_thenEmptyResult() {
        String pattern = "морковка";
        StorageService storageServiceMock = mock(StorageService.class);
        SearchService searchService = new SearchService(storageServiceMock);
        List<Searchable> items = Arrays.asList(new SimpleProduct(UUID.randomUUID(), "апельсин", 100),
                new DiscountedProduct(UUID.randomUUID(), "шоколад", 39.99, 20),
                new Article(UUID.randomUUID(), "Польза апельсинов", "Текст номер 1 про апельсины"));
        when(storageServiceMock.getAllCollection()).thenReturn(items);

        Collection<SearchResult> results = searchService.search(pattern);

        assertTrue(results.isEmpty());
    }

    @Test
    public void givenSearch_whenMatchingProductExists_thenGetResult() {
        String pattern = "апельсин";
        StorageService storageServiceMock = mock(StorageService.class);
        SearchService searchService = new SearchService(storageServiceMock);
        List<Searchable> items = Arrays.asList(new SimpleProduct(UUID.randomUUID(), "апельсин", 100),
                new DiscountedProduct(UUID.randomUUID(), "шоколад", 39.99, 20),
                new Article(UUID.randomUUID(), "Польза апельсинов", "Текст номер 1 про апельсины"));
        when(storageServiceMock.getAllCollection()).thenReturn(items);

        Collection<SearchResult> results = searchService.search(pattern);

        assertFalse(results.isEmpty());
        assertEquals(2, results.size());
    }

}
