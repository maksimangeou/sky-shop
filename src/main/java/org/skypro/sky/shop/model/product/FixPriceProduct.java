package org.skypro.sky.shop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final double FIX_PRICE = 99.99;
    private final UUID id;

    public FixPriceProduct(UUID id, String name) {
        super(name);
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
