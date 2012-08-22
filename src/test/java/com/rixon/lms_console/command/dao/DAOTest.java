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
import com.rixon.lms_console.domain.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
/**
 * User: rixon|Date: 8/19/12|Time: 12:05 PM
 */
public class DAOTest {

    LMSDao lmsDao;

    @Before
    public void setUp(){
        lmsDao = new LMSDaoSQL();
    }

    @After
    public void tearDown() {
        lmsDao = null;
    }
    @Test
    public void testGetAllBooks() {
        List<Book> books = lmsDao.getAllBooks();
        assertNotNull(books);
        final int expectedBookCount = 11;
        assertEquals("Size of list is not as expected", expectedBookCount,books.size());
    }

    @Test
    public void testGetAllMembers() {
        List<MemberRecord> memberRecords = lmsDao.getAllMembers();
        assertNotNull(memberRecords);
        final int expectedMemberCount = 4;
        assertEquals("size of member list is not as expected",expectedMemberCount,memberRecords.size());
    }

    @Test
    public void testValidMember() {
        final String emailId="rixonmathew@gmail.com";
        final String password="lms123#";
        MemberRecord memberRecord = lmsDao.findMember(emailId,password);
        assertNotNull(memberRecord);
        assertEquals("Email id does not match", emailId, memberRecord.getEmailId());
        assertEquals("Password does not match",password,memberRecord.getPassword());
    }

    @Test
    public void testInvalidMember() {
        final String emailId="notpresent@gmail.com";
        final String password="password";
        MemberRecord memberRecord = lmsDao.findMember(emailId,password);
        assertNull(memberRecord);
    }


    @Test
    public void testAddNewMember() {
        final String email = "stevejobs@apple.com";
        final String password = "apple123";
        MemberRecord memberRecord = DAOMockDataProvider.getMemberRecord("Steve","Jobs",email,"1158876659","Cupertino in United States of America", password);
        lmsDao.addMember(memberRecord);
        memberRecord = lmsDao.findMember(email,password);
        assertNotNull(memberRecord);
        assertEquals("Email id does not match", email, memberRecord.getEmailId());
        assertEquals("Password does not match", password, memberRecord.getPassword());
        lmsDao.removeMember(memberRecord);
    }

//    @Test
//    //TODO Is this functionality required?
//    public void testRemoveMember() {
//        final String emailId = "stevejobs@apple.com";
//        final String password = "apple123";
//        MemberRecord memberRecord = lmsDao.findMember(emailId,password);
//        assertNotNull(memberRecord);
//        lmsDao.removeMember(memberRecord);
//        memberRecord = lmsDao.findMember(emailId,password);
//        assertNull(memberRecord);
//    }

    @Test
    public void testGetAllItemTypes()  {
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
        assertEquals("size of role records is not as expected",expectedCount,roleRecords.size());
    }

    @Test
    public void testGetAllCategories() {
        List<CategoryRecord> categoryRecords = lmsDao.getAllCategories();
        assertNotNull(categoryRecords);
        final int expectedCount = 4;
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
        final int expectedCount = 6;
        assertEquals("size of role records is not as expected", expectedCount, itemRecords.size());
        for (ItemRecord itemRecord:itemRecords) {
            assertNotNull(itemRecord.getId());
            assertNotNull(itemRecord.getName());
            assertNotNull(itemRecord.getDescription());
            assertNotNull(itemRecord.getItemTypeRecord());
            assertNotNull(itemRecord.getProperties());
            for (PropertyRecord propertyRecord:itemRecord.getProperties().keySet()){
                ItemPropertyRecord itemPropertyRecord = itemRecord.getProperties().get(propertyRecord);
                assertNotNull(itemPropertyRecord);
            }
        }
    }

    @Test
    public void testGetAllProperties() {
        List<PropertyRecord> propertyRecords = lmsDao.getAllProperties();
        assertNotNull(propertyRecords);
        final int expectedCount = 13;
        assertEquals("size of role records is not as expected", expectedCount, propertyRecords.size());

    }

}

