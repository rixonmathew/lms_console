/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.dao.recordset.MemberRecord;
import com.rixon.lms_console.domain.Book;

import java.util.List;

/**
 * This interface represents the DAO interface for the library managment system
 * User: 229921|Date: 8/19/12|Time: 12:08 PM
 */
public interface LMSDao {

    /**
     * This interface is used to provide all the books available in the system in a list
     * @return list of books
     */
    public List<Book> getAllBooks();

    /**
     * This method is used to get all the members of the library
     * @return
     */
    public List<MemberRecord> getAllMembers();
}

