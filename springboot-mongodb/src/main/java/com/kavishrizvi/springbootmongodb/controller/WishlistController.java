package com.kavishrizvi.springbootmongodb.controller;

import com.kavishrizvi.springbootmongodb.entity.Product;
import com.kavishrizvi.springbootmongodb.entity.User;
import com.kavishrizvi.springbootmongodb.service.ProductService;
import com.kavishrizvi.springbootmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
public class WishlistController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllWishLists(@PathVariable String userName) {
        User user = userService.getUserByUserName(userName);
        List<Product> wishlist = user.getWishlist();
        if(wishlist!=null && !wishlist.isEmpty()) {
            return new ResponseEntity<>(wishlist, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addToWishlist(@RequestBody Product request) {
        productService.createProduct(request);
        return new ResponseEntity<>("Data Created Successfully", HttpStatus.CREATED);
    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable ObjectId id) {
//        Product product = productService.getProductById(id);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean removeProductById(@PathVariable ObjectId id) {
//        productService.removeProductById(id);
//        return true;
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateEntry(@PathVariable ObjectId id, @RequestBody Product request) {
//        productService.updateProductDetails(id, request);
//        return new ResponseEntity<>("Data Updated Successfully", HttpStatus.OK);
//    }
}
