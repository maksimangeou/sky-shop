package org.skypro.sky.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.sky.shop.model.search.SearchResult;
import org.skypro.sky.shop.model.service.SearchService;
import org.skypro.sky.shop.model.service.StorageService;

import java.util.Collection;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;
    @InjectMocks
    private SearchService searchService;

    @Test
    public void givenEmptyStorage_whenSearch_thenEmpty() {
        searchService = new SearchService(null);

        boolean result = searchService.search("апельсин").isEmpty();
        System.out.println(searchService.search("апельсин").toString());
        System.out.println(result);

        Assertions.assertEquals(false,result);

    }

    @Test
    public void givenStorage_whenSearchProductNotInStorage_thenEmpty() {
        storageService.getAllCollection().clear();
        searchService = new SearchService(storageService);

        Collection<SearchResult> result = searchService.search("морковь");

        Assertions.assertNotNull(result.toString());

    }
}
