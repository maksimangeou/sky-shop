package org.skypro.sky.shop.controller;

import org.skypro.sky.shop.model.exception.NoSuchProductException;
import org.skypro.sky.shop.model.exception.ShopError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> catchNoSuchProductException(NoSuchProductException e) {
        return new ResponseEntity<>(new ShopError(Integer.toString(HttpStatus.NOT_FOUND.value()),
                e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
