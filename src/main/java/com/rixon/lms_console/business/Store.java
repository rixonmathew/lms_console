/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemInstance;
import com.rixon.lms_console.dao.Member;
import com.rixon.lms_console.dao.SearchQuery;
import com.rixon.lms_console.dao.recordset.*;

import java.util.List;

/**
 * This interface represents the data store for performing various operations related
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

    /**
     * This method will return all the items in the datastore
     *
     * @return list of all items
     */
    List<Item> allItems();

    /**
     * This method is used for adding the instances of Item to the database
     *
     * @param itemInstances list of item instances
     */
    void addItemInstancesToLibrary(List<ItemInstance> itemInstances);

    /**
     * This method will return all members of the library system
     *
     * @return list of Library Members
     */
    List<Member> allMembers();

    /**
     * This method will return a single member based on the id.
     *
     * @param id the id of the member
     * @return member instance
     */
    Member memberById(long id);

    /**
     * This method will return an Item based on the itemId;
     *
     * @param itemId the item id
     * @return the Item Record
     */
    Item searchItemById(long itemId);

    /**
     * This method is used for reserving an item Instance to a user. It is assumed that the item and user is valid before this method is executed.
     * This method will reserve the available instance of the item to the user and provide the result in the form of a list.
     *
     * @param itemInstanceId
     * @param userId
     * @return
     */
    List reserveItemForUser(long itemInstanceId, long userId);

    /**
     * This method will provide all the transaction type records defined in the system
     *
     * @return
     */
    List<TransactionTypeRecord> allTransactionTypes();
}