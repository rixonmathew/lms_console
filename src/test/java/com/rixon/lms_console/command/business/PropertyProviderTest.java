/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.business.CategoryProvider;
import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.dao.Category;
import com.rixon.lms_console.dao.Property;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * This class is used to test PropertyProvider
 * User: rixon|Date: 9/1/12|Time: 8:23 PM
 */
public class PropertyProviderTest {

    @Test
    public void testValidPropertyType() {
        final String expectedPropertyName = "ISBN";
        final String expectedPropertyDescription = "Isbn";
        final Category expectedCategory = CategoryProvider.getCategory("ITEM_PROPERTY");

        Property property = PropertyProvider.getProperty(expectedPropertyName);
        assertThat("Property name is not as expected", property.getName(), equalTo(expectedPropertyName));
        assertThat("Property description is not as expected", expectedPropertyDescription, equalTo(property.getDescription()));
        assertThat("Category on property is not as expected", expectedCategory, equalTo(property.getCategory()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPropertyType() {
        final String expectedPropertyName = "ABCD";
        PropertyProvider.getProperty(expectedPropertyName);
        fail("An exception should have been raised");
    }

    @Test
    public void testPropertiesForCategory() {
        final String categoryName = "ITEM_PROPERTY";
        List<Property> properties = PropertyProvider.getPropertiesForCategory(categoryName);
        assertNotNull(properties);
        final int expectedCount = 12;
        assertEquals("count of properties is not as expected", expectedCount, properties.size());
    }

}
