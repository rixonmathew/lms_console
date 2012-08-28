/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.SearchQuery;
import com.rixon.lms_console.dao.recordset.CategoryRecord;
import com.rixon.lms_console.dao.recordset.ItemTypeRecord;
import com.rixon.lms_console.dao.recordset.PropertyRecord;

import java.util.List;

/**
 * This interface represents the data store for performing various operations
 * associated with lms
 * User: rixon|Date: 8/25/12|Time: 9:07 PM
 */
public interface Store {

    /**
     * This method will return all items where title matches the text provided in the
     * query
     * @param searchQuery
     * @return
     */
    public Result searchItemByTitle(SearchQuery searchQuery);

    List<PropertyRecord> allProperties();

    List<ItemTypeRecord> allItemTypes();

    List<CategoryRecord> allCategories();

    void addItemsToLibrary(List<Item> items);
}
