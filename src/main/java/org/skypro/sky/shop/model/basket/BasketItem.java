package org.skypro.sky.shop.model.basket;

import org.skypro.sky.shop.model.product.Product;

public final class BasketItem {
    private Product product;
    private int quality;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
