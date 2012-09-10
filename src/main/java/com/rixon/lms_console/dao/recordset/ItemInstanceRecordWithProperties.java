/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import java.util.List;

/**
 * User: rixon|Date: 9/10/12|Time: 1:56 PM
 */
public class ItemInstanceRecordWithProperties {

    private ItemInstanceRecord itemInstanceRecord;
    private List<ItemInstancePropertyRecord> itemInstancePropertyRecords;

    public ItemInstanceRecord getItemInstanceRecord() {
        return itemInstanceRecord;
    }

    public List<ItemInstancePropertyRecord> getItemInstancePropertyRecords() {
        return itemInstancePropertyRecords;
    }

    private ItemInstanceRecordWithProperties(ItemInstanceRecord itemInstanceRecord, List<ItemInstancePropertyRecord> itemInstancePropertyRecords) {
        this.itemInstanceRecord = itemInstanceRecord;
        this.itemInstancePropertyRecords = itemInstancePropertyRecords;
    }

    public static class ItemInstanceRecordWithPropertiesBuilder {
        private ItemInstanceRecord itemInstanceRecord;
        private List<ItemInstancePropertyRecord> itemInstancePropertyRecords;

        public ItemInstanceRecordWithPropertiesBuilder setItemInstanceRecord(ItemInstanceRecord itemInstanceRecord) {
            this.itemInstanceRecord = itemInstanceRecord;
            return this;
        }

        public ItemInstanceRecordWithPropertiesBuilder setItemInstancePropertyRecords(List<ItemInstancePropertyRecord> itemInstancePropertyRecords) {
            this.itemInstancePropertyRecords = itemInstancePropertyRecords;
            return this;
        }

        public ItemInstanceRecordWithProperties createItemInstanceRecordWithProperties() {
            return new ItemInstanceRecordWithProperties(itemInstanceRecord, itemInstancePropertyRecords);
        }
    }
}
