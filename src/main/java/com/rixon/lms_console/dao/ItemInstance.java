/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import java.util.Map;

/**
 * This class is used for modelling an instance of the Item
 * User: rixon|Date: 9/9/12|Time: 12:57 PM
 */
public class ItemInstance {

    private final long instanceId;
    private final Item item;
    private final Map<Property, PropertyValue> itemInstanceProperties;

    private ItemInstance(long instanceId,
                         Item item, Map<Property, PropertyValue> itemInstanceProperties) {
        this.instanceId = instanceId;
        this.item = item;
        this.itemInstanceProperties = itemInstanceProperties;
    }

    public long getInstanceId() {
        return instanceId;
    }

    public Item getItem() {
        return item;
    }

    public PropertyValue getPropertyValue(Property property) {
        return itemInstanceProperties.get(property);
    }

    public Map<Property, PropertyValue> allPropertiesMap() {
        return itemInstanceProperties;
    }

    public static class ItemInstanceBuilder {
        private long instanceId;
        private Item item;
        private Map<Property, PropertyValue> itemInstanceProperties;

        public ItemInstanceBuilder setInstanceId(long instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        public ItemInstanceBuilder setItem(Item item) {
            this.item = item;
            return this;
        }

        public ItemInstanceBuilder setItemInstanceProperties(Map<Property, PropertyValue> itemInstanceProperties) {
            this.itemInstanceProperties = itemInstanceProperties;
            return this;
        }

        public ItemInstance createItemInstance() {
            return new ItemInstance(instanceId, item, itemInstanceProperties);
        }
    }
}
