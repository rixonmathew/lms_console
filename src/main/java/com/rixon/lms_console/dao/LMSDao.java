/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.dao.recordset.*;

import java.util.List;

/**
 * This interface represents the DAO interface for the library management system
 * User: rixon|Date: 8/19/12|Time: 12:08 PM
 */
public interface LMSDao {

    /**
     * This method is used to get all the members of the library
     *
     * @return list of member records
     */
    public List<MemberRecord> getAllMembers();

    /**
     * This dao method will provide the member record based on the email id and password
     *
     * @param emailId  emailId
     * @param password password
     * @return MemberRecord
     */
    public MemberRecord findMember(String emailId, String password);


    /**
     * This method will get the item types that are possible in the system
     *
     * @return list of all item type record
     */
    public List<ItemTypeRecord> getAllItemTypes();

    /**
     * This method is for adding a new member record to the data base
     *
     * @param memberRecord the member record
     */
    public void addMember(MemberRecord memberRecord);

    /**
     * This method will remove the member record. As of now this will not remove any transactions associated with
     * the member
     * TODO: add functionality to soft delete the member and all related tables of the member
     *
     * @param memberRecord the member record
     */
    public void removeMember(MemberRecord memberRecord);

    /**
     * This method will provide all the roles defined in the system
     *
     * @return list of all roles
     */
    public List<RoleRecord> getAllRoles();

    /**
     * this method will return all the categories under which properties are placed
     *
     * @return list of all categories
     */
    public List<CategoryRecord> getAllCategories();

    /**
     * This method will return all the features available in the system
     *
     * @return list of all features
     */
    public List<FeatureRecord> getAllFeatures();

    /**
     * This method will return all the items available in the system
     *
     * @return list of all items
     */
    public List<ItemRecord> getAllItems();

    /**
     * This method will return all the ItemRecords where results match
     * the searchQuery
     *
     * @param searchQuery the search query object
     * @return list of ItemRecords
     */
    List<ItemRecord> getItemsForQuery(SearchQuery searchQuery);


    /**
     * This method will return all the properties available in the system
     *
     * @return list of all property records
     */
    public List<PropertyRecord> getAllProperties();


    /**
     * This method will return all the feature records for the a given role
     *
     * @param role the role for which features are required
     * @return list of feature records
     */
    public List<FeatureRecord> featuresForRole(String role);

    /**
     * This method will return all the item properties for a particular itemRecord
     *
     * @param itemRecord the item for which properties are required
     * @return list of ItemPropertyRecords
     */
    public List<ItemPropertyRecord> propertiesForItem(ItemRecord itemRecord);

    /**
     * This method will return the ItemRecord with a given id
     *
     * @param expectedItemID the id of item
     * @return ItemRecord object
     */
    public ItemRecord itemWithId(long expectedItemID);

    /**
     * This method will return all roles with the features
     *
     * @return list of RoleFeatureRecords
     */
    public List<RoleFeatureRecord> getAllRoleFeatures();

    /**
     * This method is used to add multiple items into the database
     *
     * @param itemRecords list of item records to be added
     */
    public void addMultipleItemRecords(List<ItemRecordWithProperties> itemRecords);

    /**
     * This method is used add multiple item instances into the database
     *
     * @param itemInstanceRecordWithProperties
     *         list of itemInstancesWithRecordProperties
     */
    void addMultipleItemInstanceRecords(List<ItemInstanceRecordWithProperties> itemInstanceRecordWithProperties);

    /**
     * This method will return the member record based on the system id
     *
     * @param id of the user
     * @return the member record
     */
    MemberRecord findMember(long id);

    /**
     * This method will return the ItemInstance based on the id
     *
     * @param itemInstanceId
     * @return ItemInstance
     */
    ItemInstanceRecord findItemInstanceId(long itemInstanceId);

    /**
     * This method will create an instance of the transaction
     *
     * @param itemInstanceTransactionRecord
     */
    void addItemInstanceTransaction(ItemInstanceTransactionRecord itemInstanceTransactionRecord);

    /**
     * This method will provide all the transaction types in the system
     *
     * @return list of all transaction type records
     */
    List<TransactionTypeRecord> getAllTransactionTypes();

    /**
     * This method will return all the properties for a particual item instance
     *
     * @param itemInstanceRecord
     * @return list of ItemInstancePropertyRecord
     */
    List<ItemInstancePropertyRecord> propertiesForItemInstance(ItemInstanceRecord itemInstanceRecord);
}