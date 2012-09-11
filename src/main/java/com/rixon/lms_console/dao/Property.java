/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

/**
 * User: rixon|Date: 8/25/12|Time: 8:04 PM
 */
public class Property {

    private final String name;
    private final String description;
    private final Category category;

    private Property(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;

        Property property = (Property) o;

        if (!category.equals(property.category)) return false;
        if (!description.equals(property.description)) return false;
        if (!name.equals(property.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }

    public static class PropertyBuilder {
        private String name;
        private String description;
        private Category category;

        public PropertyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PropertyBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PropertyBuilder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Property createProperty() {
            return new Property(name, description, category);
        }
    }
}
