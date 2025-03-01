package org.skypro.sky.shop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    private double price;
    private final UUID id;

    public SimpleProduct(UUID id, String name, int price) {
        super(name);
        this.id = id;
        try {
            if (price <= 0) {
                throw new IllegalArgumentException();
            }
            this.price = price;
        } catch (IllegalArgumentException e) {
            System.out.println("Цена должна быть больше 0");
        }
    }

    @Override
    public UUID getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + ": " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
