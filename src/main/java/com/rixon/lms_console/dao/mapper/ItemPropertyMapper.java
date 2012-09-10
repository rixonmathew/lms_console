/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.PropertyValue;
import com.rixon.lms_console.dao.recordset.ItemPropertyRecord;
import com.rixon.lms_console.dao.recordset.ItemRecord;
import org.jetbrains.annotations.NotNull;

/**
 * This class is used to map the ItemPropertyRecord to ItemProperty entity
 * User: rixon|Date: 8/25/12|Time: 8:47 PM
 */
public class ItemPropertyMapper {

    @NotNull
    public static PropertyValue mapToItemPropertyValue(@NotNull ItemPropertyRecord itemPropertyRecord) {
        PropertyValue.PropertyValueBuilder propertyValueBuilder = new PropertyValue.PropertyValueBuilder();
        Property property = PropertyMapper.mapToProperty(itemPropertyRecord.getPropertyRecord());
        propertyValueBuilder.setProperty(property);
        propertyValueBuilder.setPropertyValue(itemPropertyRecord.getValue());
        return propertyValueBuilder.createPropertyValue();
    }

    @NotNull
    public static ItemPropertyRecord mapToItemPropertyRecord(@NotNull PropertyValue propertyValue, ItemRecord itemRecord) {
        ItemPropertyRecord itemPropertyRecord = new ItemPropertyRecord();
        itemPropertyRecord.setItemRecord(itemRecord);
        itemPropertyRecord.setPropertyRecord(PropertyMapper.mapToPropertyRecord(propertyValue.getProperty()));
        itemPropertyRecord.setValue(propertyValue.getPropertyValue());
        return itemPropertyRecord;
    }
}
