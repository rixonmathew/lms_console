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
     * @return
     */
    public List<MemberRecord> getAllMembers();

    /**
     * This dao method will provide the member record based on the email id and password
     *
     * @param emailId
     * @param password
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
     * @param memberRecord
     */
    public void addMember(MemberRecord memberRecord);

    /**
     * This method will remove the member record. As of now this will not remove any transactions associated with
     * the member
     * TODO: add functionality to soft delete the member and all related tables of the member
     *
     * @param memberRecord
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
     * @return
     */
    public List<ItemRecord> getAllItems();

    /**
     * This method will return all the properties available in the system
     *
     * @return
     */
    public List<PropertyRecord> getAllProperties();

    /**
     * This method is used to add multiple items into the database
     *
     * @param itemRecords
     */
    public void addMultipleItemRecords(List<ItemRecordWithProperties> itemRecords);

    /**
     * This method will return all the feature records for the a given role
     *
     * @param role
     * @return list of feature records
     */
    public List<FeatureRecord> featuresForRole(String role);

    /**
     * This method will return all the item properties for a particular itemRecords
     *
     * @param itemRecord
     * @return
     */
    public List<ItemPropertyRecord> propertiesForItem(ItemRecord itemRecord);

    /**
     * This method will return the ItemRecord with a given id
     *
     * @param expectedItemID
     * @return
     */
    public ItemRecord itemWithId(int expectedItemID);
}

