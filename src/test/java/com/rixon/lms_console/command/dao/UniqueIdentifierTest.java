/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.dao;

import com.rixon.lms_console.dao.UniqueIdentifier;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * This class is used to test the UniqueIdentifier
 * User: rixon|Date: 9/3/12|Time: 12:24 PM
 */
public class UniqueIdentifierTest {

    @NotNull
    UniqueIdentifier.UniqueIdentifierBuilder builder;

    @Before
    public void setUp() {
        builder = new UniqueIdentifier.UniqueIdentifierBuilder();
    }

    @After
    public void tearDown() {
        builder = null;
    }

    @Test
    public void testBasicUniqueIdentifier() {
        final String expectedType = "ISBN";
        builder.setType(expectedType);
        final String expectedValue = "11231123-1123";
        builder.setValue(expectedValue);
        UniqueIdentifier uniqueIdentifier = builder.createUniqueIdentifier();
        assertNotNull(uniqueIdentifier);
        assertThat("Type is not as expected", expectedType, equalTo(uniqueIdentifier.getType()));
        assertThat("Value is not as expected", expectedValue, equalTo(uniqueIdentifier.getValue()));
    }

    @Test
    public void testUniqueIdentifierWithRandomValue() {
        final String expectedType = "ISBN";
        builder.setType(expectedType);
        builder.generateUniqueValue();
        UniqueIdentifier uniqueIdentifier = builder.createUniqueIdentifier();
        assertNotNull(uniqueIdentifier);
        assertThat("Type is not as expected", expectedType, equalTo(uniqueIdentifier.getType()));
        assertNotNull(uniqueIdentifier.getValue());
    }
}
