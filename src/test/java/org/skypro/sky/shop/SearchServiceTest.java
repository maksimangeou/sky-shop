package org.skypro.sky.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.article.Article;
import org.skypro.sky.shop.model.product.DiscountedProduct;
import org.skypro.sky.shop.model.product.SimpleProduct;
import org.skypro.sky.shop.model.search.SearchResult;
import org.skypro.sky.shop.model.search.Searchable;
import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageServiceMock;
    @InjectMocks
    private SearchService searchService;

    @Test
    public void givenEmptyStorage_whenSearchItem_thenEmpty() {
        String pattern = "апельсин";
        storageServiceMock = Mockito.mock(StorageService.class);
        when(storageServiceMock.getAllCollection()).thenReturn(Collections.emptyList());

        Collection<SearchResult> results = searchService.search(pattern);
        System.out.println(results);

        Assertions.assertTrue(results.isEmpty());
    }

    @Test
    public void givenSearchResult_whenSearchProductNotInStorage_thenEmptyResult() {
        searchService = new SearchService(storageServiceMock);
        String pattern = "морковка";

        Collection<SearchResult> result = searchService.search(pattern);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchWhenMatchingObjectExists() {
        storageServiceMock = Mockito.mock(StorageService.class);
        searchService = new SearchService(storageServiceMock);

        List<Searchable> items = Arrays.asList(new SimpleProduct(UUID.randomUUID(),"orange", 200),
                new Article(UUID.randomUUID(),"Fruits","This text is including the word orange"),
                new DiscountedProduct(UUID.randomUUID(),"orangate",500,20));
        Mockito.when(storageServiceMock.getAllCollection()).thenReturn(items);

        // Act
        Collection<SearchResult> results = searchService.search("orange");
        System.out.println(results);

        // Assert
        assertEquals(2, results.size());
    }

    @Test
    public void givenStorage_whenSearchItemInStorage_thenResult() {
        String pattern = "апельсин";
        storageServiceMock = Mockito.mock(StorageService.class);
        List<Searchable> items = Arrays.asList(new SimpleProduct(UUID.randomUUID(),"апельсин", 200),
                new Article(UUID.randomUUID(),"Fruits","This text is including the word апельсин"),
                new DiscountedProduct(UUID.randomUUID(),"orangate",500,20));
        Mockito.when(storageServiceMock.getAllCollection()).thenReturn(items);

        Collection<SearchResult> results = searchService.search(pattern);
        System.out.println(results);

        assertEquals(2, results.size());
    }
}
