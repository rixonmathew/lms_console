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

    private  Property(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class PropertyBuilder {
        private String name;
        private String description;

        public PropertyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PropertyBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Property createProperty() {
            return new Property(name, description);
        }
    }

}
