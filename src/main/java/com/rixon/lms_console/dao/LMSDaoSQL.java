/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.dao.recordset.*;

import javax.persistence.*;
import java.util.List;

/**
 * This class represents the implementation of the LMSDao based on a SQL database
 * User: rixon|Date: 8/19/12|Time: 12:10 PM
 */

public class LMSDaoSQL implements LMSDao {

    private final EntityManager entityManager;


    public LMSDaoSQL() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lms-eclipselink");
        entityManager = entityManagerFactory.createEntityManager();

    }


    @Override
    public List<MemberRecord> getAllMembers() {
        Query allMembersQuery = entityManager.createNamedQuery(MemberRecord.ALL_MEMBERS_QUERY);
        List results = allMembersQuery.getResultList();
        return (List<MemberRecord>) results;
    }

    @Override
    public MemberRecord findMember(String emailId, String password) {
        Query memberSearchQuery = entityManager.createNamedQuery(MemberRecord.FIND_MEMBER_QUERY);
        memberSearchQuery.setParameter("emailId", emailId);
        memberSearchQuery.setParameter("password", password);
        List results = memberSearchQuery.getResultList();
        MemberRecord memberRecord = null;
        if (results != null && results.size() > 0) {
            memberRecord = ((List<MemberRecord>) results).get(0);
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
        return (List<ItemTypeRecord>) results;
    }

    @Override
    public List<RoleRecord> getAllRoles() {
        Query allRolesQuery = entityManager.createNamedQuery(RoleRecord.ALL_ROLES_QUERY);
        List results = allRolesQuery.getResultList();
        return (List<RoleRecord>) results;
    }

    @Override
    public List<CategoryRecord> getAllCategories() {
        Query allCategoriesQuery = entityManager.createNamedQuery(CategoryRecord.ALL_CATEGORIES_QUERY);
        List results = allCategoriesQuery.getResultList();
        return (List<CategoryRecord>) results;
    }

    @Override
    public List<FeatureRecord> getAllFeatures() {
        Query allFeaturesQuery = entityManager.createNamedQuery(FeatureRecord.ALL_FEATURES_QUERY);
        List results = allFeaturesQuery.getResultList();
        return (List<FeatureRecord>) results;
    }

    @Override
    public List<ItemRecord> getAllItems() {
        Query allItemsQuery = entityManager.createNamedQuery(ItemRecord.ALL_ITEMS_QUERY);
        List results = allItemsQuery.getResultList();
        return (List<ItemRecord>) results;
    }

    @Override
    public List<PropertyRecord> getAllProperties() {
        Query allPropertiesQuery = entityManager.createNamedQuery(PropertyRecord.ALL_PROPERTIES_QUERY);
        List results = allPropertiesQuery.getResultList();
        return (List<PropertyRecord>) results;
    }

    @Override
    public void addMultipleItemRecords(List<ItemRecord> itemRecords) {
        int recordCounter = 0;
        final int flushCount = 20;
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        for (ItemRecord itemRecord : itemRecords) {
            entityManager.persist(itemRecord);
            recordCounter++;
            if (recordCounter % flushCount == 0) {
                entityManager.flush();
            }
        }
        transaction.commit();
    }

    @Override
    public List<FeatureRecord> featuresForRole(String role) {
        Query featuresForRoleQuery = entityManager.createNamedQuery(FeatureRecord.FEATURES_FOR_ROLE_QUERY);
        featuresForRoleQuery.setParameter("role", role);
        return (List<FeatureRecord>) featuresForRoleQuery.getResultList();
    }

    @Override
    public List<ItemPropertyRecord> propertiesForItem(ItemRecord itemRecord) {
        Query itemPropertiesQuery = entityManager.createNamedQuery(ItemPropertyRecord.ITEM_PROPERTY_QUERY);
        itemPropertiesQuery.setParameter("itemRecord", itemRecord);
        return (List<ItemPropertyRecord>) itemPropertiesQuery.getResultList();
    }
}