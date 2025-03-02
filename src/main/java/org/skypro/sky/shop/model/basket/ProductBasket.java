package org.skypro.sky.shop.model.basket;

import org.skypro.sky.shop.model.service.StorageService;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> mapBasket;

    public ProductBasket(Map<UUID, Integer> mapBasket) {
        this.mapBasket = mapBasket;
    }

    public Map<UUID, Integer> getMapBasket() {
        return mapBasket;
    }

    public void addProductInBasket(UUID id) {
        if (mapBasket.containsKey(id)) {
            mapBasket.put(id, mapBasket.get(id) + 1);
        } else {
            mapBasket.put(id, 1);
        }
    }

    public Map<UUID, Integer> getProductInBasket() {
        return Collections.unmodifiableMap(mapBasket);
    }
}
