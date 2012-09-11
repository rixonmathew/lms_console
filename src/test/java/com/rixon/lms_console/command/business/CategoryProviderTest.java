/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.business.CategoryProvider;
import com.rixon.lms_console.dao.Category;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

/**
 * User: rixon|Date: 9/1/12|Time: 1:06 PM
 */
public class CategoryProviderTest {

    @Test
    public void testCategory() {
        final String expectedCategoryName = "ITEM_PROPERTY";
        Category category = CategoryProvider.getCategory(expectedCategoryName);
        assertThat("Category name is not as expected", expectedCategoryName, equalTo(category.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCategory() {
        final String expectedCategoryName = "ABCD_PROPERTY";
        CategoryProvider.getCategory(expectedCategoryName);
        fail("An exception should have been raised for invalid category");
    }

}
