/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.dao.ItemType;
import com.rixon.lms_console.dao.mapper.ItemTypeMapper;
import com.rixon.lms_console.dao.recordset.ItemTypeRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class acts as the Item Type provider based on the item types
 * defined in the database
 * User: rixon|Date: 8/26/12|Time: 2:03 PM
 */
public class ItemTypeProvider {

    private final static Map<String, ItemType> itemTypeMap = new HashMap<String, ItemType>();
    private final static Map<String, ItemTypeRecord> itemTypeRecordMap = new HashMap<String, ItemTypeRecord>();

    public static ItemType getItemType(String code) {
        loadItemTypeCacheIfRequired();
        ItemType itemType = itemTypeMap.get(code);
        if (itemType == null) {
            throw new IllegalArgumentException("Invalid code type " + code);
        }
        return itemType;
    }

    public static ItemTypeRecord getItemTypeRecord(String code) {
        loadItemTypeCacheIfRequired();
        ItemTypeRecord itemTypeRecord = itemTypeRecordMap.get(code);
        if (itemTypeRecord == null) {
            throw new IllegalArgumentException("Invalid code type " + code);
        }
        return itemTypeRecord;
    }

    private static void loadItemTypeCacheIfRequired() {
        if (itemTypeMap.isEmpty()) {
            List<ItemTypeRecord> itemTypeRecords = SimpleStore.getInstance().allItemTypes();
            for (ItemTypeRecord itemTypeRecord : itemTypeRecords) {
                itemTypeMap.put(itemTypeRecord.getType(), ItemTypeMapper.mapToItemType(itemTypeRecord));
                itemTypeRecordMap.put(itemTypeRecord.getType(), itemTypeRecord);
            }
        }
    }

}
