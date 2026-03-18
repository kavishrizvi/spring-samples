package com.kavishrizvi.springbootmongodb.utilities;

import com.kavishrizvi.springbootmongodb.entity.Category;

import java.time.LocalDateTime;

public class AppUtils {
    public static Category resolveCategory(String category) {
        try {
            return Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid category: " + category);
        }
    }
}
