package org.skypro.sky.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.search.SearchResult;

import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.*;

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

        assertTrue(results.isEmpty(), "Expected an empty result when storage is empty.");
    }

    @Test
    public void givenSearchResult_whenSearchProductNotInStorage_thenEmptyResult() {
        StorageService storageServiceMock = mock(StorageService.class);
        SearchService searchService = new SearchService(storageServiceMock);
        Mockito.when(storageServiceMock.getAllCollection()).thenReturn(Collections.emptyList());
        searchService = new SearchService(storageServiceMock);
        String pattern = "морковка";

        Collection<SearchResult> result = searchService.search(pattern);
        System.out.println(result);

        assertTrue(result.isEmpty());
    }

    @Test
    public void givenSearch_whenMatchingProductExists_thenGetResult() {
        StorageService storageServiceMock = mock(StorageService.class);
        SearchService searchService = new SearchService(storageServiceMock);
        Mockito.when(storageServiceMock.getAllCollection()).thenReturn(Collections.emptyList());
        searchService = new SearchService(storageServiceMock);
        String pattern = "апельсин";

        Collection<SearchResult> result = searchService.search(pattern);
        System.out.println(result);

        Assertions.assertFalse(result.isEmpty());
    }

}
