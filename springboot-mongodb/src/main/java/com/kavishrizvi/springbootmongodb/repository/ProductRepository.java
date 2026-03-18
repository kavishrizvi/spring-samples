package com.kavishrizvi.springbootmongodb.repository;

import com.kavishrizvi.springbootmongodb.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {}
