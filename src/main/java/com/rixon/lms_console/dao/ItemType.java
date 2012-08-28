/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

/**
 * This class represents the entity ItemType
 * User: rixon|Date: 8/25/12|Time: 7:54 PM
 */
public class ItemType {
    private final String type;
    private final String description;

    private ItemType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class ItemTypeBuilder {
        private String type;
        private String description;

        public ItemTypeBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ItemTypeBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemType createItemType() {
            return new ItemType(type, description);
        }
    }
}
