/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.dao.recordset.CategoryRecord;
import com.rixon.lms_console.dao.recordset.ItemTypeRecord;
import com.rixon.lms_console.dao.recordset.MemberRecord;
import com.rixon.lms_console.dao.recordset.RoleRecord;
import com.rixon.lms_console.domain.Book;

import javax.persistence.*;
import java.util.List;

/**
 * User: rixon|Date: 8/19/12|Time: 12:10 PM
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
        Query allMembersQuery = entityManager.createNamedQuery(MemberRecord.ALL_MEMBERS_QUERY);
        List results = allMembersQuery.getResultList();
        return (List<MemberRecord>)results;
    }

    @Override
    public MemberRecord findMember(String emailId, String password) {
        Query membberSearchQuery = entityManager.createNamedQuery(MemberRecord.FIND_MEMBER_QUERY);
        membberSearchQuery.setParameter("emailId", emailId);
        membberSearchQuery.setParameter("password", password);
        List results = membberSearchQuery.getResultList();
        MemberRecord memberRecord = null;
        if (results!=null && results.size()>0){
            memberRecord = ((List<MemberRecord>)results).get(0);
        }
        return memberRecord;
    }

    @Override
    public void addMember(MemberRecord memberRecord) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(memberRecord);
        transaction.commit();
    }

    @Override
    public void removeMember(MemberRecord memberRecord) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(memberRecord);
        transaction.commit();
    }

    @Override
    public List<ItemTypeRecord> getAllItemTypes() {
        Query allMembersQuery = entityManager.createNamedQuery(ItemTypeRecord.ALL_ITEM_TYPES_QUERY);
        List results = allMembersQuery.getResultList();
        return (List<ItemTypeRecord>)results;
    }

    @Override
    public List<RoleRecord> getAllRoles() {
        Query allRolesQuery = entityManager.createNamedQuery(RoleRecord.ALL_ROLES_QUERY);
        List results = allRolesQuery.getResultList();
        return (List<RoleRecord>)results;
    }

    @Override
    public List<CategoryRecord> getAllCategories() {
        Query allCategoriesQuery = entityManager.createNamedQuery(CategoryRecord.ALL_CATEGORIES_QUERY);
        List results = allCategoriesQuery.getResultList();
        return (List<CategoryRecord>)results;
    }
}