package com.alten.shop.products.controllers;

import com.alten.shop.products.exceptions.ProductNonFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductAdvice {

    @ExceptionHandler(ProductNonFoundException.class)
    public ResponseEntity<String> handleFunctionalMessageException(ProductNonFoundException ex) {
        return  ResponseEntity.badRequest().body(ex.getMessage());
    }


    // Default handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return  ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
