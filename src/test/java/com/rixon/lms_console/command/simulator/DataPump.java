/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.business.ItemTypeProvider;
import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemPropertyValue;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.util.DateUtil;

import java.util.*;

import static com.rixon.lms_console.util.Constants.*;

/**
 * User: rixon|Date: 8/26/12|Time: 3:24 PM
 */
public class DataPump {

    private final DataSimulator dataSimulator;
    List<String> mockNames;
    List<String> mockDescriptions;
    List<String> mockPropertyValues;
    List<Date> mockDates;
    Random random = new Random();

    public DataPump(DataSimulator dataSimulator) {
        this.dataSimulator = dataSimulator;
    }

    public List<Item> generateMockItems(int expectedMockItems) {
        ArrayList<Item> items = new ArrayList<Item>();
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        populateDataLists(expectedMockItems);
        for (int i=0;i<expectedMockItems;i++) {
            itemBuilder.setName(mockNames.get(i));
            itemBuilder.setDescription(mockDescriptions.get(i));
            itemBuilder.setItemType(ItemTypeProvider.getItemType("BOOK"));
            List<Property> properties = PropertyProvider.getPropertiesForCategory(CATEGORY_ITEM_PROPERTY);
            itemBuilder.setItemProperties(generateMockProperties(properties));
            items.add(itemBuilder.createItem());
        }
        return items;
    }

    private void populateDataLists(int expectedMockItems) {
        mockNames = dataSimulator.mockTitles(expectedMockItems);
        mockDescriptions = dataSimulator.mockTitles(expectedMockItems);
        mockDates = dataSimulator.mockDates(expectedMockItems);
        mockPropertyValues = dataSimulator.mockPropertyValues(expectedMockItems);
    }

    private Map<Property, ItemPropertyValue> generateMockProperties(List<Property> properties) {
        Map<Property,ItemPropertyValue> itemPropertyValueMap = new HashMap<Property,ItemPropertyValue>();
        for(Property property:properties) {
            ItemPropertyValue.ItemPropertyValueBuilder itemPropertyValueBuilder = new ItemPropertyValue.
                    ItemPropertyValueBuilder();
            itemPropertyValueBuilder.setProperty(property);
            if (property.getName().equalsIgnoreCase(PUBLISHED_DATE)) {
                String dateValue = DateUtil.getDateAsString(getRandomDate());
                itemPropertyValueBuilder.setPropertyValue(dateValue);
            } else {
                itemPropertyValueBuilder.setPropertyValue(getRandomPropertyValue());
            }
            itemPropertyValueMap.put(property,itemPropertyValueBuilder.createItemPropertyValue());
        }
        return itemPropertyValueMap;
    }

    private Date getRandomDate() {
        return mockDates.get(random.nextInt(mockDates.size()));
    }

    public String getRandomPropertyValue() {
        return mockPropertyValues.get(random.nextInt(mockPropertyValues.size()));
    }
}
