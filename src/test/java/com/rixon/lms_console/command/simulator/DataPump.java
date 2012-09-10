/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.business.ItemTypeProvider;
import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.business.SimpleStore;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemInstance;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.PropertyValue;
import com.rixon.lms_console.util.DateUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static com.rixon.lms_console.util.Constants.*;

/**
 * User: rixon|Date: 8/26/12|Time: 3:24 PM
 */
class DataPump {

    private final DataSimulator dataSimulator;
    private List<String> mockNames;
    private List<String> mockDescriptions;
    private List<String> mockPropertyValues;
    private List<Date> mockDates;
    private final Random random = new Random();

    public DataPump(DataSimulator dataSimulator) {
        this.dataSimulator = dataSimulator;
    }

    @NotNull
    public List<Item> generateMockItems(int expectedMockItems) {
        ArrayList<Item> items = new ArrayList<Item>();
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        populateDataLists(expectedMockItems);
        for (int i = 0; i < expectedMockItems; i++) {
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
        mockDescriptions = dataSimulator.mockDescriptions(expectedMockItems);
        mockDates = dataSimulator.mockDates(expectedMockItems);
        mockPropertyValues = dataSimulator.mockPropertyValues(expectedMockItems);
    }

    @NotNull
    private Map<Property, PropertyValue> generateMockProperties(@NotNull List<Property> properties) {
        Map<Property, PropertyValue> itemPropertyValueMap = new HashMap<Property, PropertyValue>();
        for (Property property : properties) {
            PropertyValue.PropertyValueBuilder propertyValueBuilder = new PropertyValue.PropertyValueBuilder();
            propertyValueBuilder.setProperty(property);
            if (isDateProperty(property)) {
                String dateValue = DateUtil.getDateAsString(getRandomDate());
                propertyValueBuilder.setPropertyValue(dateValue);
            } else {
                propertyValueBuilder.setPropertyValue(getRandomPropertyValue());
            }
            itemPropertyValueMap.put(property, propertyValueBuilder.createPropertyValue());
        }
        return itemPropertyValueMap;
    }

    private boolean isDateProperty(@NotNull Property property) {
        return property.getName().equalsIgnoreCase(PUBLISHED_DATE) || property.getName().equalsIgnoreCase(ADDED_DATE);
    }

    private Date getRandomDate() {
        return mockDates.get(random.nextInt(mockDates.size()));
    }

    String getRandomPropertyValue() {
        return mockPropertyValues.get(random.nextInt(mockPropertyValues.size()));
    }

    @NotNull
    public List<ItemInstance> generateMockItemInstances(int expectedInstances) {
        List<Item> allItems = getItems(expectedInstances);
        List<ItemInstance> itemInstances = new ArrayList<ItemInstance>();
        populateDataLists(expectedInstances);
        ItemInstance.ItemInstanceBuilder itemInstanceBuilder = new ItemInstance.ItemInstanceBuilder();
        for (Item item : allItems) {
            for (int i = 0; i < expectedInstances; i++) {
                itemInstanceBuilder.setItem(item);
                List<Property> properties = PropertyProvider.getPropertiesForCategory(CATEGORY_INSTANCE_PROPERTY);
                itemInstanceBuilder.setItemInstanceProperties(generateMockProperties(properties));
                ItemInstance itemInstance = itemInstanceBuilder.createItemInstance();
                itemInstances.add(itemInstance);
            }
        }
        return itemInstances;
    }

    @NotNull
    private List<Item> getItems(int expectedInstances) {
        List<Item> allItems = SimpleStore.getInstance().allItems();
        List<Item> items = new ArrayList<Item>();
        if (allItems == null) {
            return items;
        }
        int maxItems = Math.min(expectedInstances, allItems.size());
        for (int i = 0; i < maxItems; i++) {
            items.add(allItems.get(i));
        }
        return items;
    }
}
