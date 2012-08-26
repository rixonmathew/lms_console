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
import com.rixon.lms_console.dao.recordset.PropertyRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a mapper class to create an Item instance from ItemRecord
 * User: rixon|Date: 8/25/12|Time: 8:22 PM
 */
public class ItemMapper {

    public static Item mapToItem(ItemRecord itemRecord) {
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        itemBuilder.setName(itemRecord.getName());
        itemBuilder.setDescription(itemRecord.getDescription());
        itemBuilder.setItemProperties(mapItemProperties(itemRecord.getProperties()));
        itemBuilder.setItemType(ItemTypeMapper.mapToItemType(itemRecord.getItemTypeRecord()));
        //TODO add mapping for other items
        return itemBuilder.createItem();
    }

    private static Map<Property,ItemPropertyValue> mapItemProperties(Map<PropertyRecord,ItemPropertyRecord> itemPropertyRecordMap) {
        Map<Property,ItemPropertyValue> itemPropertyValueMap = new HashMap<Property, ItemPropertyValue>();
        for (PropertyRecord propertyRecord:itemPropertyRecordMap.keySet()) {
            Property property = PropertyMapper.mapToProperty(propertyRecord);
            ItemPropertyValue propertyValue = ItemPropertyMapper.mapToItemPropertyValue(itemPropertyRecordMap.get(propertyRecord));
            itemPropertyValueMap.put(property,propertyValue);
        }
        return itemPropertyValueMap;
    }

}
