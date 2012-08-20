/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.dao.recordset.MemberRecord;
import com.rixon.lms_console.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * User: 229921|Date: 8/19/12|Time: 12:10 PM
 */

public class LMSDaoSQL implements LMSDao {

    private final EntityManager entityManager;


    public LMSDaoSQL() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lms-eclipselink");
        entityManager = entityManagerFactory.createEntityManager();

    }

    @Override
    public List<Book> getAllBooks() {
        Query allBooksQuery  = entityManager.createNamedQuery(Book.ALL_BOOKS_QUERY);
        List results = allBooksQuery.getResultList();
        return (List<Book>)results;
    }

    @Override
    public List<MemberRecord> getAllMembers() {
        Query allMembersQuery = entityManager.createNamedQuery(MemberRecord.ALL_MEMBERS);
        List results = allMembersQuery.getResultList();
        return (List<MemberRecord>)results;
    }
}
