package org.skypro.sky.shop.model.exception;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException() {
        super("Product is not available");
    }
}
