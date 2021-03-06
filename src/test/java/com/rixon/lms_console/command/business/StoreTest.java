/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.business.SimpleStore;
import com.rixon.lms_console.business.Store;
import com.rixon.lms_console.command.CommandTestUtil;
import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.SearchQuery;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.table.TableModel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * This class is used for testing the Store functionality
 * User: rixon|Date: 9/1/12|Time: 8:29 PM
 */
public class StoreTest {

    @Nullable
    Store store;

    @Before
    public void setUp() {
        store = SimpleStore.getInstance();
    }

    @After
    public void tearDown() {
        store = null;

    }

    @Test
    public void testSearchByTitle() {
        final String expectedTitle = "%Charlie%";
        SearchQuery searchQuery = getSearchQueryWithParameters(false, expectedTitle);
        Result searchResults = store.searchItemByTitle(searchQuery);
        assertNotNull(searchResults);
        TableModel tableModel = searchResults.getResultsTable();
        final int expectedRowCount = 1;
        assertTrue("some results should have been returned", tableModel.getRowCount() > expectedRowCount);

    }

    @NotNull
    private SearchQuery getSearchQueryWithParameters(boolean anyFieldMatch, String... searchTexts) {
        Parameter<String> simpleParameter = CommandTestUtil.parameterWithString(searchTexts);
        return new SearchQuery(simpleParameter, anyFieldMatch);
    }


}
