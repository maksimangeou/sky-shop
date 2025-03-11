package org.skypro.sky.shop.model.exception;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException(UUID id) {
        super("Product with " + id + " is not available");
    }
}
