/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.business.ItemTypeProvider;
import com.rixon.lms_console.dao.ItemType;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * This class is used for testing the ItemTypeProvider class
 * User: rixon|Date: 9/1/12|Time: 8:11 PM
 */
public class ItemTypeProviderTest {

    @Test
    public void testValidItemTypeProviderTest() {
        final String expectedItemTypeName = "BOOK";
        ItemType itemType = ItemTypeProvider.getItemType(expectedItemTypeName);
        assertNotNull(itemType);
        assertThat("ItemType is not as expected", itemType.getType(), equalTo(expectedItemTypeName));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidItemTypeProviderTest() {
        final String expectedItemTypeName = "MVSD";
        ItemType itemType = ItemTypeProvider.getItemType(expectedItemTypeName);
        fail("An exception should have been raised");
        assertNull(itemType);
    }


}
