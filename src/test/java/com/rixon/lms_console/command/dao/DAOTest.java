/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.dao;

import com.rixon.lms_console.dao.LMSDao;
import com.rixon.lms_console.dao.LMSDaoSQL;
import com.rixon.lms_console.dao.recordset.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * User: rixon|Date: 8/19/12|Time: 12:05 PM
 */
public class DAOTest {

    private LMSDao lmsDao;

    @Before
    public void setUp() {
        lmsDao = new LMSDaoSQL();
        final String DAO_MODE = "com.rixon.lms_console.dao_mode";
        System.setProperty(DAO_MODE, "SQL");
    }

    @After
    public void tearDown() {
        lmsDao = null;
    }

    @Test
    public void testGetAllMembers() {
        List<MemberRecord> memberRecords = lmsDao.getAllMembers();
        assertNotNull(memberRecords);
        final int expectedMemberCount = 4;
        assertEquals("size of member list is not as expected", expectedMemberCount, memberRecords.size());
    }

    @Test
    public void testValidMember() {
        final String emailId = "rixonmathew@gmail.com";
        final String password = "lms123#";
        MemberRecord memberRecord = lmsDao.findMember(emailId, password);
        assertNotNull(memberRecord);
        assertEquals("Email id does not match", emailId, memberRecord.getEmailId());
        assertEquals("Password does not match", password, memberRecord.getPassword());
    }

    @Test
    public void testMemberSearchByID() {
        final long id = 1;
        MemberRecord memberRecord = lmsDao.findMember(id);
        assertNotNull(memberRecord);
        final String expectedFirstName = "Rixon";
        final String expectedLastName = "Mathew";
        assertEquals("First name not as expected", expectedFirstName, memberRecord.getFirstName());
        assertEquals("Last name not as expected", expectedLastName, memberRecord.getLastName());
    }


    @Test
    public void testInvalidMember() {
        final String emailId = "notpresent@gmail.com";
        final String password = "password";
        MemberRecord memberRecord = lmsDao.findMember(emailId, password);
        assertNull(memberRecord);
    }

    @Test
    public void testInvalidMemberSearchByID() {
        final long id = -101;
        MemberRecord memberRecord = lmsDao.findMember(id);
        assertNull(memberRecord);
    }

    @Test
    public void testAddNewMember() {
        final String email = "stevejobs@apple.com";
        final String password = "apple123";
        MemberRecord memberRecord = DAOMockDataProvider.getMemberRecord("Steve", "Jobs", email, "1158876659", "Cupertino in United States of America", password);
        lmsDao.addMember(memberRecord);
        memberRecord = lmsDao.findMember(email, password);
        assertNotNull(memberRecord);
        assertEquals("Email id does not match", email, memberRecord.getEmailId());
        assertEquals("Password does not match", password, memberRecord.getPassword());
        lmsDao.removeMember(memberRecord);
    }

    @Test
    public void testGetAllItemTypes() {
        List<ItemTypeRecord> itemTypeRecords = lmsDao.getAllItemTypes();
        assertNotNull(itemTypeRecords);
        final int expectedCount = 7;
        assertEquals("size of item type list is not as expected", expectedCount, itemTypeRecords.size());
    }

    @Test
    public void testGetAllRoles() {
        List<RoleRecord> roleRecords = lmsDao.getAllRoles();
        assertNotNull(roleRecords);
        final int expectedCount = 4;
        assertEquals("size of role records is not as expected", expectedCount, roleRecords.size());
    }

    @Test
    public void testGetAllCategories() {
        List<CategoryRecord> categoryRecords = lmsDao.getAllCategories();
        assertNotNull(categoryRecords);
        final int expectedCount = 5;
        assertEquals("size of role records is not as expected", expectedCount, categoryRecords.size());
    }


    @Test
    public void testGetAllFeatures() {
        List<FeatureRecord> featureRecords = lmsDao.getAllFeatures();
        assertNotNull(featureRecords);
        final int expectedCount = 5;
        assertEquals("size of role records is not as expected", expectedCount, featureRecords.size());
    }

    @Test
    public void testGetAllItems() {
        List<ItemRecord> itemRecords = lmsDao.getAllItems();
        assertNotNull(itemRecords);
//This cannot be asserted due to DataPump test
//        final int expectedCount = 11;
//        assertEquals("size of items is not as expected", expectedCount, itemRecords.size());
        for (ItemRecord itemRecord : itemRecords) {
            assertNotNull(itemRecord.getId());
            assertNotNull(itemRecord.getName());
            assertNotNull(itemRecord.getDescription());
            assertNotNull(itemRecord.getItemTypeRecord());
        }
    }

    @Test
    public void testGetAllProperties() {
        List<PropertyRecord> propertyRecords = lmsDao.getAllProperties();
        assertNotNull(propertyRecords);
        final int expectedCount = 22;
        assertEquals("size of role records is not as expected", expectedCount, propertyRecords.size());
    }

    @Test
    public void testGetItemWithId() {
        final int expectedItemID = 12976;
        ItemRecord itemRecord = lmsDao.itemWithId(expectedItemID);
        assertNotNull(itemRecord);
        assertEquals("Id is not as expected", expectedItemID, itemRecord.getId());
    }

    @Test
    public void testGetPropertiesForItem() {
        final int expectedItemID = 12976;
        ItemRecord itemRecord = lmsDao.itemWithId(expectedItemID);
        assertNotNull(itemRecord);
        assertEquals("Id is not as expected", expectedItemID, itemRecord.getId());
        List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
        assertNotNull(itemPropertyRecords);
        final int expectedPropertiesCount = 11;
        assertEquals("Count of properties is not as expected", expectedPropertiesCount, itemPropertyRecords.size());
    }

    @Test
    public void testAllRoleFeatureRecord() {
        List<RoleFeatureRecord> allRoleFeatures = lmsDao.getAllRoleFeatures();
        assertNotNull(allRoleFeatures);
        final int expectedCount = 8;
        assertEquals("Count of role features is not as expected", expectedCount, allRoleFeatures.size());
    }
}