/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemPropertyValue;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.recordset.ItemPropertyRecord;
import com.rixon.lms_console.dao.recordset.ItemRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a mapper class to create an Item instance from ItemRecord
 * User: rixon|Date: 8/25/12|Time: 8:22 PM
 */
public class ItemMapper {

    public static Item mapToItem(ItemRecord itemRecord, List<ItemPropertyRecord> itemProperties) {
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        itemBuilder.setName(itemRecord.getName());
        itemBuilder.setDescription(itemRecord.getDescription());
        itemBuilder.setItemProperties(mapItemProperties(itemProperties));
        itemBuilder.setItemType(ItemTypeMapper.mapToItemType(itemRecord.getItemTypeRecord()));
        return itemBuilder.createItem();
    }

    private static Map<Property, ItemPropertyValue> mapItemProperties(List<ItemPropertyRecord> itemPropertyRecords) {
        Map<Property, ItemPropertyValue> itemPropertyValueMap = new HashMap<Property, ItemPropertyValue>();
        for (ItemPropertyRecord itemPropertyRecord : itemPropertyRecords) {
            Property property = PropertyMapper.mapToProperty(itemPropertyRecord.getPropertyRecord());
            ItemPropertyValue propertyValue = ItemPropertyMapper.mapToItemPropertyValue(itemPropertyRecord);
            itemPropertyValueMap.put(property, propertyValue);
        }
        return itemPropertyValueMap;
    }

    public static ItemRecord mapToItemRecord(Item item) {
        if (item == null) {
            return null;
        }
        ItemRecord itemRecord = new ItemRecord();
        itemRecord.setName(item.getName());
        itemRecord.setDescription(item.getDescription());
        itemRecord.setItemTypeRecord(ItemTypeMapper.mapToItemTypeRecord(item.getItemType()));
        return itemRecord;
    }

    public static List<ItemPropertyRecord> mapItemPropertyRecords(Map<Property, ItemPropertyValue> itemProperties,
                                                                  ItemRecord itemRecord) {

        List<ItemPropertyRecord> itemPropertyRecords = new ArrayList<ItemPropertyRecord>();
        for (ItemPropertyValue itemPropertyValue : itemProperties.values()) {
            ItemPropertyRecord itemPropertyRecord = ItemPropertyMapper.mapToItemPropertyRecord(itemPropertyValue, itemRecord);

            itemPropertyRecords.add(itemPropertyRecord);
        }
        return itemPropertyRecords;
    }
}
