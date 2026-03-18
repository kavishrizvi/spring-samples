package com.kavishrizvi.springbootmongodb.service;

import com.kavishrizvi.springbootmongodb.entity.Category;
import com.kavishrizvi.springbootmongodb.entity.Product;
import com.kavishrizvi.springbootmongodb.exceptions.ProductNotFound;
import com.kavishrizvi.springbootmongodb.repository.ProductRepository;
import com.kavishrizvi.springbootmongodb.utilities.AppUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            products = repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("No Products Found");
        }
        return products;

    }

    public Product getProductById(ObjectId id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id.toString()));

    }

    public void createProduct(Product request) throws RuntimeException {
        try {
            request.setDate();
            repository.save(request);
        }catch (Exception e) {
            throw new RuntimeException("Unable to commit, initiating rollback");
        }
    }

    public void removeProductById(ObjectId id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProductDetails(ObjectId id, Product updatedProduct) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id.toString()));

        if (updatedProduct.getName() != null && !updatedProduct.getName().isEmpty()) {
            existingProduct.setName(updatedProduct.getName());
        }

        if (updatedProduct.getDescription() != null && !updatedProduct.getDescription().isEmpty()) {
            existingProduct.setDescription(updatedProduct.getDescription());
        }

        if (updatedProduct.getCategory() != null) {
            existingProduct.setCategory(updatedProduct.getCategory());
        }

        repository.save(existingProduct);

    }
}
