/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;/**
 *
 * User: rixon|Date: 9/11/12|Time: 6:29 PM
 */

import com.rixon.lms_console.command.simulator.property.PropertyDataSimulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class PropertyDataSimulatorTest {

    PropertyDataSimulator propertyDataSimulator;

    @Before
    public void setup() {
        MockDataSeed mockDataSeed = new MockDataSeed();
        propertyDataSimulator = new PropertyDataSimulator(mockDataSeed);
    }

    @After
    public void tearDown() {
        propertyDataSimulator = null;
    }

    @Test
    public void testPropertyDataSimulatorForISBN() {
        Map<String, List<String>> mockPropertyValues = propertyDataSimulator.mockPropertyValues(10);
        assertNotNull(mockPropertyValues);
        for (String property : mockPropertyValues.keySet()) {
            System.out.println("property = " + property);
            System.out.println("mockPropertyValues = " + mockPropertyValues.get(property));
        }

    }
}
