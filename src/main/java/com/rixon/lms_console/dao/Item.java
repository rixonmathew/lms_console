/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import java.util.Map;

/**
 * This interface represents the item entity of the library
 * User: rixon|Date: 8/25/12|Time: 6:42 PM
 */
public class Item {

    private final String name;
    private final String description;
    private final ItemType itemType;
    private final Map<Property,ItemPropertyValue> itemProperties;
    private final UniqueIdentifier identifier;

    private Item(String name, String description,  ItemType itemType,
                        Map<Property,ItemPropertyValue> itemProperties, UniqueIdentifier identifier) {
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.itemProperties = itemProperties;
        this.identifier = identifier;
    }

    /**
     * This method will return the name of the item
     * @return name
     */
    public String getName() {
       return name;
    }

    /**
     * This method will return the description associated with item
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method will return the item type
     * @return item type
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * This method will return the property value associated with given property
     * @param property
     * @return property value
     */
    public ItemPropertyValue getItemPropertyValue(Property property) {
        return itemProperties.get(property);
    }

    /**
     * This method will return the id of the item
     * @return unique identifier
     */
    public UniqueIdentifier getUniqueId() {
        return identifier;
    }

    /**
     * This class is the builder for building Item instances
     */
    public static class ItemBuilder {
        private String name;
        private String description;
        private ItemType itemType;
        private Map<Property, ItemPropertyValue> itemProperties;
        private UniqueIdentifier identifier;

        public ItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder setItemType(ItemType itemType) {
            this.itemType = itemType;
            return this;
        }

        public ItemBuilder setItemProperties(Map<Property, ItemPropertyValue> itemProperties) {
            this.itemProperties = itemProperties;
            return this;
        }

        public ItemBuilder setIdentifier(UniqueIdentifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Item createItem() {
            return new Item(name, description, itemType, itemProperties, identifier);
        }
    }
}
