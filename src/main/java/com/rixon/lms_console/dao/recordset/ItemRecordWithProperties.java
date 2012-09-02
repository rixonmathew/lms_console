/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import java.util.List;

/**
 * This class is used to encapsulate an ItemRecord with its associated properties.
 * User: rixon|Date: 9/2/12|Time: 9:02 PM
 */
public class ItemRecordWithProperties {
    private ItemRecord itemRecord;
    private List<ItemPropertyRecord> itemProperties;

    private ItemRecordWithProperties(ItemRecord itemRecord, List<ItemPropertyRecord> itemProperties) {
        this.itemRecord = itemRecord;
        this.itemProperties = itemProperties;
    }

    public ItemRecord getItemRecord() {
        return itemRecord;
    }

    public List<ItemPropertyRecord> getItemProperties() {
        return itemProperties;
    }

    public static class ItemRecordWithPropertiesBuilder {

        private ItemRecord itemRecord;
        private List<ItemPropertyRecord> itemProperties;

        public ItemRecordWithPropertiesBuilder setItemRecord(ItemRecord itemRecord) {
            this.itemRecord = itemRecord;
            return this;
        }

        public ItemRecordWithPropertiesBuilder setItemProperties(List<ItemPropertyRecord> itemProperties) {
            this.itemProperties = itemProperties;
            return this;
        }

        public ItemRecordWithProperties createItem() {
            return new ItemRecordWithProperties(itemRecord, itemProperties);
        }
    }
}
