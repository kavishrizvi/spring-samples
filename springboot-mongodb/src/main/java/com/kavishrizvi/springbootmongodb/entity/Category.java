package com.kavishrizvi.springbootmongodb.entity;

public enum Category {
    HOME_TOOLS("Home Tools"),
    AIR_CONDITIONER("Air Conditioner"),
    SHAMPOOS("Shampoos");


    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
