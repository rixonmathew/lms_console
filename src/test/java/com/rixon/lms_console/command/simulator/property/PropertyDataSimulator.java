/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import com.rixon.lms_console.command.simulator.MockDataSeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rixon.lms_console.util.Constants.*;

/**
 * This class is used for returning simulated values for various property types
 * User: rixon|Date: 9/11/12|Time: 3:25 PM
 */
public class PropertyDataSimulator {

    private List<String> properties;
    private Map<String, String> propertyTemplates;
    private Map<String, MockPropertyValueProvider> mockValueProviders;
    private MockDataSeed mockDataSeed;
    private final String DEFAULT_PROVIDER = "DEFAULT_PROVIDER";


    public PropertyDataSimulator(MockDataSeed mockDataSeed) {
        this.mockDataSeed = mockDataSeed;
        loadDataStructures();
    }

    public Map<String, List<String>> mockPropertyValues(int expectedMockItems) {

        Map<String, List<String>> mockPropertyValues = new HashMap<String, List<String>>();
        for (String property : properties) {
            MockPropertyValueProvider propertyValueProvider = mockValueProvider(property);
            List<String> values = new ArrayList<String>();
            String propertyTemplate = propertyTemplates.get(property);
            for (int i = 0; i < expectedMockItems; i++) {
                final String randomValue = propertyValueProvider.randomMockValue(mockDataSeed, propertyTemplate);
                values.add(randomValue);
            }
            mockPropertyValues.put(property, values);
        }
        return mockPropertyValues;
    }

    private MockPropertyValueProvider mockValueProvider(String property) {
        MockPropertyValueProvider mockPropertyValueProvider = mockValueProviders.get(property);
        if (mockPropertyValueProvider == null) {
            mockPropertyValueProvider = mockValueProviders.get(DEFAULT_PROVIDER);
        }
        return mockPropertyValueProvider;
    }

    private void loadDataStructures() {
        loadProperties();
        loadPropertyTemplates();
        loadValueProviders();
    }

    private void loadProperties() {
        properties = new ArrayList<String>();
        properties.add(ISBN);
        properties.add(AUTHOR);
        properties.add(PUBLISHER);
        properties.add(PUBLISHED_DATE);
        properties.add(ADDED_DATE);
        properties.add(TITLE);
        properties.add(PAGES);
        properties.add(GENRE);
        properties.add(PRICE);
        properties.add(WEBSITE);
        properties.add(RATING);
    }

    private void loadPropertyTemplates() {
        propertyTemplates = new HashMap<String, String>();
        propertyTemplates.put(ISBN, "%d%d%d-%d-%d%d%d-%d%d%d%d%d-%d");
        propertyTemplates.put(AUTHOR, "%1$s,%2$s");
        propertyTemplates.put(PUBLISHER, "%1$s Publishers");
        propertyTemplates.put(PUBLISHED_DATE, "%date");
        propertyTemplates.put(ADDED_DATE, "%date");
        propertyTemplates.put(TITLE, "%1$s %2$s %3$s");
        propertyTemplates.put(PAGES, "%d%d%d%d");
        propertyTemplates.put(GENRE, "%1$s");
        propertyTemplates.put(PRICE, "Rs %d%d%d%d%d");
        propertyTemplates.put(WEBSITE, "http://wwww.%1$s.com");
        propertyTemplates.put(RATING, "%1$s");
    }

    private void loadValueProviders() {
        mockValueProviders = new HashMap<String, MockPropertyValueProvider>();
        mockValueProviders.put(ISBN, new ISBNMockValueProvider());
        mockValueProviders.put(DEFAULT_PROVIDER, new DefaultMockPropertyValueProvider());
        //TODO add values for other properties
    }

}
