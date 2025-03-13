package org.skypro.sky.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.product.SimpleProduct;
import org.skypro.sky.shop.model.search.SearchResult;

import org.skypro.sky.shop.model.search.Searchable;
import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        SearchService searchService = new SearchService();
        String pattern = "морковка";

        Collection<SearchResult> results = searchService.search(pattern);

        assertTrue(results.isEmpty());
    }

    @Test
    public void givenSearch_whenMatchingProductExists_thenGetResult() {
        SearchService searchService = new SearchService();
        String pattern = "апельсин";

        Collection<SearchResult> results = searchService.search(pattern);

        assertFalse(results.isEmpty());
    }

}
