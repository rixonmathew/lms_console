/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.recordset.PropertyRecord;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class represents the mapper to et the
 * User: rixon|Date: 8/25/12|Time: 8:41 PM
 */
public class PropertyMapper {
    @NotNull
    public static Property mapToProperty(@NotNull PropertyRecord propertyRecord) {
        Property.PropertyBuilder propertyBuilder = new Property.PropertyBuilder();
        propertyBuilder.setName(propertyRecord.getName());
        propertyBuilder.setDescription(propertyRecord.getDescription());
        propertyBuilder.setCategory(CategoryMapper.mapToCategory(propertyRecord.getCategoryRecord()));
        return propertyBuilder.createProperty();
    }

    @Nullable
    public static PropertyRecord mapToPropertyRecord(@Nullable Property property) {
        if (property == null) {
            return null;
        }
        return PropertyProvider.getPropertyRecord(property.getName());
    }
}
