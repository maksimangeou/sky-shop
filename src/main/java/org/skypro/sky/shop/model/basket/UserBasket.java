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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPrice() {
        return total = userBasket.stream()
                .mapToDouble(i -> i.getProduct().getPrice()*i.getQuality())
                .sum();
    }
}
