package com.kavishrizvi.springbootmongodb.controller;

import com.kavishrizvi.springbootmongodb.entity.Product;
import com.kavishrizvi.springbootmongodb.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product request) {
        service.createProduct(request);
        return new ResponseEntity<>("Data Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable ObjectId id) {
        Product product = service.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean removeProductById(@PathVariable ObjectId id) {
        service.removeProductById(id);
        return true;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable ObjectId id, @RequestBody Product request) {
        service.updateProductDetails(id, request);
        return new ResponseEntity<>("Data Updated Successfully", HttpStatus.OK);
    }
}
