/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * This interface represents the item entity of the library
 * User: rixon|Date: 8/25/12|Time: 6:42 PM
 */
public class Item {

    private final long id;
    private final String name;
    private final String description;
    private final ItemType itemType;
    private final Map<Property, PropertyValue> itemProperties;
    private final UniqueIdentifier identifier;

    private Item(long id, String name, String description, ItemType itemType,
                 Map<Property, PropertyValue> itemProperties, UniqueIdentifier identifier) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.itemProperties = itemProperties;
        this.identifier = identifier;
    }

    public long getId() {
        return id;
    }

    /**
     * This method will return the name of the item
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method will return the description associated with item
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method will return the item type
     *
     * @return item type
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * This method will return the property value associated with given property
     *
     * @param property the property object
     * @return property value
     */
    public PropertyValue getItemPropertyValue(Property property) {
        return itemProperties.get(property);
    }

    /**
     * This method will return the id of the item
     *
     * @return unique identifier
     */
    public UniqueIdentifier getUniqueId() {
        return identifier;
    }

    public Map<Property, PropertyValue> allPropertiesMap() {
        return itemProperties;
    }

    @NotNull
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", itemType=" + itemType +
                ", itemProperties=" + itemProperties +
                ", identifier=" + identifier +
                '}';
    }

    public Map<Property, PropertyValue> getItemProperties() {
        return itemProperties;
    }

    public boolean isValidItem() {
        return id != 0;
    }

    /**
     * This class is the builder for building Item instances
     */
    public static class ItemBuilder {
        private long id;
        private String name;
        private String description;
        private ItemType itemType;
        private Map<Property, PropertyValue> itemProperties;
        private UniqueIdentifier identifier;

        public ItemBuilder setId(long id) {
            this.id = id;
            return this;
        }

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

        public ItemBuilder setItemProperties(Map<Property, PropertyValue> itemProperties) {
            this.itemProperties = itemProperties;
            return this;
        }

        public ItemBuilder setIdentifier(UniqueIdentifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Item createItem() {
            return new Item(id, name, description, itemType, itemProperties, identifier);
        }
    }
}
