/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.ItemInstance;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.PropertyValue;
import com.rixon.lms_console.dao.recordset.ItemInstancePropertyRecord;
import com.rixon.lms_console.dao.recordset.ItemInstanceRecord;
import com.rixon.lms_console.dao.recordset.ItemRecord;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class acts as the mapper for the ItemInstance
 * User: rixon|Date: 9/10/12|Time: 4:06 PM
 */
public class ItemInstanceMapper {

    @NotNull
    public static ItemInstanceRecord mapToItemInstanceRecord(@NotNull ItemInstance itemInstance) {
        ItemInstanceRecord itemInstanceRecord = new ItemInstanceRecord();
        itemInstanceRecord.setId(itemInstance.getInstanceId());
        ItemRecord itemRecord = ItemMapper.mapToItemRecord(itemInstance.getItem());
        itemInstanceRecord.setItemRecord(itemRecord);
        return itemInstanceRecord;
    }

    /*
      //Uncomment when the use is there for this method
        public static ItemInstance mapToItemInstance(ItemInstanceRecord itemInstanceRecord,
                                                     List<ItemInstancePropertyRecord> itemInstanceProperties) {
            ItemInstance.ItemInstanceBuilder builder = new ItemInstance.ItemInstanceBuilder();
            builder.setInstanceId(itemInstanceRecord.getId());
            ItemRecord itemRecord = itemInstanceRecord.getItemRecord();
            List<ItemPropertyRecord> itemPropertyRecords = DAOFactory.lmsDao().propertiesForItem(itemRecord);
            Item item = ItemMapper.mapToItem(itemInstanceRecord.getItemRecord(), itemPropertyRecords);
            builder.setItem(item);
            builder.setItemInstanceProperties(mapItemProperties(itemInstanceProperties));
            return builder.createItemInstance();
        }


        private static Map<Property, PropertyValue>
        mapItemProperties(List<ItemInstancePropertyRecord> itemInstanceProperties) {
            Map<Property, PropertyValue> itemInstancePropertyValueMap = new HashMap<Property, PropertyValue>();
            for (ItemInstancePropertyRecord itemInstancePropertyRecord : itemInstanceProperties) {
                Property property = PropertyMapper.mapToProperty(itemInstancePropertyRecord.getPropertyRecord());
                PropertyValue propertyValue = ItemInstancePropertyMapper.mapToPropertyValue(itemInstancePropertyRecord);
                itemInstancePropertyValueMap.put(property, propertyValue);
            }
            return itemInstancePropertyValueMap;
        }
    */
    @NotNull
    public static List<ItemInstancePropertyRecord> mapItemInstancePropertyRecords(
            @NotNull Map<Property, PropertyValue> propertiesMap, ItemInstanceRecord itemInstanceRecord) {
        List<ItemInstancePropertyRecord> itemInstancePropertyRecords = new ArrayList<ItemInstancePropertyRecord>();
        for (PropertyValue propertyValue : propertiesMap.values()) {
            ItemInstancePropertyRecord itemInstancePropertyRecord = new ItemInstancePropertyRecord();
            itemInstancePropertyRecord.setItemInstanceRecord(itemInstanceRecord);
            itemInstancePropertyRecord.setPropertyRecord(PropertyMapper.mapToPropertyRecord(propertyValue.getProperty()));
            itemInstancePropertyRecord.setValue(propertyValue.getPropertyValue());
            itemInstancePropertyRecords.add(itemInstancePropertyRecord);
        }
        return itemInstancePropertyRecords;
    }
}
