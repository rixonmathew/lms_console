/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.ItemPropertyValue;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.recordset.ItemPropertyRecord;

/**
 * This class is used to map the ItemPropertyRecord to ItemProperty entity
 * User: rixon|Date: 8/25/12|Time: 8:47 PM
 */
public class ItemPropertyMapper {

    public static ItemPropertyValue mapToItemPropertyValue(ItemPropertyRecord itemPropertyRecord) {
        ItemPropertyValue.ItemPropertyValueBuilder itemPropertyValueBuilder = new ItemPropertyValue.ItemPropertyValueBuilder();
        Property property = PropertyMapper.mapToProperty(itemPropertyRecord.getPropertyRecord());
        itemPropertyValueBuilder.setProperty(property);
        itemPropertyValueBuilder.setPropertyValue(itemPropertyRecord.getValue());
        return itemPropertyValueBuilder.createItemPropertyValue();
    }

    public static ItemPropertyRecord mapToItemPropertyRecord(ItemPropertyValue itemPropertyValue) {
        ItemPropertyRecord itemPropertyRecord = new ItemPropertyRecord();
        itemPropertyRecord.setPropertyRecord(PropertyMapper.mapToPropertyRecord(itemPropertyValue.getProperty()));
        itemPropertyRecord.setValue(itemPropertyValue.getPropertyValue());
        return itemPropertyRecord;
    }
}
