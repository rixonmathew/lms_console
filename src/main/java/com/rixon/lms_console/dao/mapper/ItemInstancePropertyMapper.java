/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.PropertyValue;
import com.rixon.lms_console.dao.recordset.ItemInstancePropertyRecord;
import com.rixon.lms_console.dao.recordset.ItemInstanceRecord;

/**
 * This class is used for mapping the ItemInstancePropertyRecord object to PropertyValue and vice versa
 * User: rixon|Date: 9/10/12|Time: 4:50 PM
 */
public class ItemInstancePropertyMapper {

    public static PropertyValue mapToPropertyValue(ItemInstancePropertyRecord itemInstancePropertyRecord) {
        PropertyValue.PropertyValueBuilder builder = new PropertyValue.PropertyValueBuilder();
        builder.setProperty(PropertyMapper.mapToProperty(itemInstancePropertyRecord.getPropertyRecord()));
        builder.setPropertyValue(itemInstancePropertyRecord.getValue());
        return builder.createPropertyValue();
    }

    public static ItemInstancePropertyRecord mapToItemInstancePropertyRecord(PropertyValue propertyValue,
                                                                             ItemInstanceRecord itemInstanceRecord) {
        ItemInstancePropertyRecord itemInstancePropertyRecord = new ItemInstancePropertyRecord();
        itemInstancePropertyRecord.setItemInstanceRecord(itemInstanceRecord);
        itemInstancePropertyRecord.setPropertyRecord(PropertyMapper.mapToPropertyRecord(propertyValue.getProperty()));
        itemInstancePropertyRecord.setValue(propertyValue.getPropertyValue());
        return itemInstancePropertyRecord;
    }
}
