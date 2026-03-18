package com.kavishrizvi.springbootmongodb.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * POJOs(Plain Old Java Objects)
 */
@Getter
@Setter
@Document(collection = "product")
public class Product {
    @Id
    private ObjectId id;
    @NonNull
    private String name;
    private String description;
    private Category category;
    private LocalDateTime date;

    public void setDate() {
        this.date = LocalDateTime.now();
    }
}
