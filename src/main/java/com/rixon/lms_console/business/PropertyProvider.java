/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.dao.Category;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.mapper.CategoryMapper;
import com.rixon.lms_console.dao.mapper.PropertyMapper;
import com.rixon.lms_console.dao.recordset.CategoryRecord;
import com.rixon.lms_console.dao.recordset.PropertyRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The purpose of this class is to provide the valid propery instances
 * as per the master data
 * User: rixon|Date: 8/25/12|Time: 9:47 PM
 */
public class PropertyProvider {

    private static Map<String,Property> propertyMap;
    private static Map<Category,List<Property>> propertyByCategoryMap;

    static  {
        loadPropertiesMap();
    }

    private static void loadPropertiesMap() {
        propertyMap = new HashMap<String, Property>();
        propertyByCategoryMap = new HashMap<Category,List<Property>>();
        List<PropertyRecord> properties= SimpleStore.getInstance().allProperties();
        for(PropertyRecord propertyRecord :properties) {
            final Property property = PropertyMapper.mapToProperty(propertyRecord);
            propertyMap.put(propertyRecord.getName(), property);
            CategoryRecord categoryRecord = propertyRecord.getCategoryRecord();
            Category category = CategoryMapper.mapToCategory(categoryRecord);
            List<Property> propertyForCategory = propertyByCategoryMap.get(category);
            if (propertyForCategory==null || propertyForCategory.isEmpty()) {
                propertyForCategory = new ArrayList<Property>();
                propertyForCategory.add(property);
                propertyByCategoryMap.put(category, propertyForCategory);
            } else {
                propertyForCategory.add(property);
                propertyByCategoryMap.put(category, propertyForCategory);
            }
        }
    }

    public static Property getProperty(String property) {

        if (propertyMap.containsKey(property)) {
            return propertyMap.get(property);
        }
        throw new IllegalArgumentException("No property exists by name "+property);
    }

    public static List<Property> getPropertiesForCategory(String categoryName) {
        Category category = CategoryProvider.getCategory(categoryName);
        if (propertyByCategoryMap.containsKey(category)) {
            return propertyByCategoryMap.get(category);
        }
        throw new IllegalArgumentException("No properties exist for given category "+categoryName);
    }
}
