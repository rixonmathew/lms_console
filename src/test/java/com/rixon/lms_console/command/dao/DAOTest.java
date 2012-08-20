/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.dao;

import com.rixon.lms_console.dao.LMSDao;
import com.rixon.lms_console.dao.LMSDaoSQL;
import com.rixon.lms_console.dao.recordset.MemberRecord;
import com.rixon.lms_console.domain.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: 229921|Date: 8/19/12|Time: 12:05 PM
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
        final int expectecBookCount = 11;
        assertEquals("Size of list is not as expected", expectecBookCount,books.size());
    }

    @Test
    public void testGetAllMembers() {
        List<MemberRecord> memberRecords = lmsDao.getAllMembers();
        assertNotNull(memberRecords);
        final int expectedMemberCount = 4;
        assertEquals("size of member list is not as expected",expectedMemberCount,memberRecords.size());
    }

}
