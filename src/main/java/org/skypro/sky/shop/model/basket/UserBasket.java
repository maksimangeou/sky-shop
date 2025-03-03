package org.skypro.sky.shop.model.basket;

import java.util.List;

public final class UserBasket {
    private List<BasketItem> userBasket;
    private double total;

    public UserBasket(List<BasketItem> userBasket) {
        this.userBasket = userBasket;
    }

    public List<BasketItem> getUserBasket() {
        return userBasket;
    }

    public void setUserBasket(List<BasketItem> userBasket) {
        this.userBasket = userBasket;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return userBasket.stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuality())
                .sum();
    }
}
