package com.kavishrizvi.springbootmongodb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("Product not found");
    }
    public ProductNotFound(String id) {
        super("Product not found with id : " + id);
    }
}
