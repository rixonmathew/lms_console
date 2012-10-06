/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.PropertyValue;
import com.rixon.lms_console.dao.factory.DAOFactory;
import com.rixon.lms_console.dao.recordset.ItemPropertyRecord;
import com.rixon.lms_console.dao.recordset.ItemRecord;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a mapper class to create an Item instance from ItemRecord
 * User: rixon|Date: 8/25/12|Time: 8:22 PM
 */
public class ItemMapper {

    @NotNull
    public static Item mapToItem(ItemRecord itemRecord, List<ItemPropertyRecord> itemProperties) {
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        if (itemRecord==null) {
            return itemBuilder.createItem();
        }
        itemBuilder.setId(itemRecord.getId());
        itemBuilder.setName(itemRecord.getName());
        itemBuilder.setDescription(itemRecord.getDescription());
        itemBuilder.setItemProperties(mapItemProperties(itemProperties));
        itemBuilder.setItemType(ItemTypeMapper.mapToItemType(itemRecord.getItemTypeRecord()));
        return itemBuilder.createItem();
    }

    @NotNull
    private static Map<Property, PropertyValue> mapItemProperties(List<ItemPropertyRecord> itemPropertyRecords) {
        Map<Property, PropertyValue> itemPropertyValueMap = new HashMap<Property, PropertyValue>();
        if (itemPropertyRecords==null) {
            return itemPropertyValueMap;
        }

        for (ItemPropertyRecord itemPropertyRecord : itemPropertyRecords) {
            Property property = PropertyMapper.mapToProperty(itemPropertyRecord.getPropertyRecord());
            PropertyValue propertyValue = ItemPropertyMapper.mapToItemPropertyValue(itemPropertyRecord);
            itemPropertyValueMap.put(property, propertyValue);
        }
        return itemPropertyValueMap;
    }

    @Nullable
    public static ItemRecord mapToItemRecord(@Nullable Item item) {
        if (item == null) {
            return null;
        }

        ItemRecord itemRecord = DAOFactory.lmsDao().itemWithId(item.getId());
        if (itemRecord != null) {
            return itemRecord;
        }
        itemRecord = new ItemRecord();
        itemRecord.setName(item.getName());
        itemRecord.setDescription(item.getDescription());
        itemRecord.setItemTypeRecord(ItemTypeMapper.mapToItemTypeRecord(item.getItemType()));
        return itemRecord;
    }

    @NotNull
    public static List<ItemPropertyRecord> mapItemPropertyRecords(@NotNull Map<Property, PropertyValue> itemProperties,
                                                                  ItemRecord itemRecord) {

        List<ItemPropertyRecord> itemPropertyRecords = new ArrayList<ItemPropertyRecord>();
        for (PropertyValue propertyValue : itemProperties.values()) {
            ItemPropertyRecord itemPropertyRecord = ItemPropertyMapper.mapToItemPropertyRecord(propertyValue, itemRecord);
            itemPropertyRecords.add(itemPropertyRecord);
        }
        return itemPropertyRecords;
    }
}
