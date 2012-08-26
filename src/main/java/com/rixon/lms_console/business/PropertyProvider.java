/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.mapper.PropertyMapper;
import com.rixon.lms_console.dao.recordset.PropertyRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: rixon|Date: 8/25/12|Time: 9:47 PM
 */
public class PropertyProvider {

    private static Map<String,Property> propertyMap;

    static  {
        loadPropertiesMap();
    }

    private static void loadPropertiesMap() {
        propertyMap = new HashMap<String, Property>();
        List<PropertyRecord> properties= SimpleStore.getInstance().allProperties();
        for(PropertyRecord propertyRecord :properties) {
            propertyMap.put(propertyRecord.getName(), PropertyMapper.mapToProperty(propertyRecord));
        }
    }

    public static Property getProperty(String property) {

        if (propertyMap.containsKey(property)) {
            return propertyMap.get(property);
        }
        throw new IllegalArgumentException("No property exists by name "+property);
    }

}
