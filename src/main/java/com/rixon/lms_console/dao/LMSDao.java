/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.dao.recordset.ItemTypeRecord;
import com.rixon.lms_console.dao.recordset.MemberRecord;
import com.rixon.lms_console.dao.recordset.RoleRecord;
import com.rixon.lms_console.domain.Book;

import java.util.List;

/**
 * This interface represents the DAO interface for the library managment system
 * User: rixon|Date: 8/19/12|Time: 12:08 PM
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

    /**
     * This dao metod will provide the member record based on the email id and password
     * @param emailId
     * @param password
     * @return MemberRecord
     */
    MemberRecord findMember(String emailId, String password);


    /**
     * This method will get the item types that are possible in the system
     * @return list of all item type record
     */
    List<ItemTypeRecord> getAllItemTypes();

    /**
     * This method is for adding a new member record to the data base
     * @param memberRecord
     */
    void addMember(MemberRecord memberRecord);

    /**
     * This method will remove the member record. As of now this will not remove any transactions associated with
     * the member
     * TODO: add functionality to soft delete the member and all related tables of the member
     * @param memberRecord
     */
    void removeMember(MemberRecord memberRecord);

    /**
     * This method will provide all the roles defined in the system
     * @return
     */
    List<RoleRecord> getAllRoles();
}

