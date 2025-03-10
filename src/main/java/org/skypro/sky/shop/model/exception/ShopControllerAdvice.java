package org.skypro.sky.shop.model.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<String> findNoProduct (NoSuchProductException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
