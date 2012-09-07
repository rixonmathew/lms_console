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
import com.rixon.lms_console.dao.recordset.*;

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
     *
     * @param searchQuery the search query instance
     * @return an instace of the result object
     */
    public Result searchItemByTitle(SearchQuery searchQuery);

    /**
     * This method is used to get all Property Record from the database
     *
     * @return list of all property records
     */
    List<PropertyRecord> allProperties();

    /**
     * This method is used to get all the item type records in the data base
     *
     * @return list of all item type records
     */
    List<ItemTypeRecord> allItemTypes();

    /**
     * This method is used get all the Category records in the database
     *
     * @return list of all category records
     */
    List<CategoryRecord> allCategories();

    /**
     * This method is used to add a list of Items to the database
     *
     * @param items the list of items that should be added
     */
    public void addItemsToLibrary(List<Item> items);

    /**
     * This method will return all the role records
     *
     * @return list of all role records
     */
    public List<RoleRecord> allRoles();

    /**
     * This method will provide all features
     *
     * @return list of all features
     */
    public List<FeatureRecord> allFeatures();

    /**
     * This method will return all the features that are accessible for a given role
     *
     * @param role the role for which the feature are required
     * @return list of features;
     */
    public List<FeatureRecord> featuresForRole(String role);
}