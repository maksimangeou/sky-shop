package org.skypro.sky.shop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private double priceBase;
    private int discountPercent;
    private final UUID id;

    public DiscountedProduct(UUID id, String name, double priceBase, int discountPercent) {
        super(name);
        this.id = id;
        try {
            if (priceBase <= 0) {
                throw new IllegalArgumentException();
            }
            this.priceBase = priceBase;
        } catch (IllegalArgumentException e) {
            System.out.println("Цена должна быть больше 0");
        }
        try {
            if (discountPercent < 0 || discountPercent > 100) {
                throw new IllegalArgumentException();
            }
            this.discountPercent = discountPercent;
        } catch (IllegalArgumentException e) {
            System.out.println("Значение скидки должно быть в диапазоне от 0 до 100 включительно");
        }
    }

    @Override
    public UUID getId() {
        return id;
    }

    public double getPriceBase() {
        return priceBase;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setPriceBase(double priceBase) {
        this.priceBase = priceBase;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        double priceDiscount = priceBase * (1 - discountPercent / 100d);
        return Math.ceil(priceDiscount * 100) / 100;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
