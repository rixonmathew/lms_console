/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.dao.recordset.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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


    @NotNull
    @Override
    public List<MemberRecord> getAllMembers() {
        Query allMembersQuery = entityManager.createNamedQuery(MemberRecord.ALL_MEMBERS_QUERY);
        List results = allMembersQuery.getResultList();
        return (List<MemberRecord>) results;
    }

    @Nullable
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

    @NotNull
    @Override
    public List<ItemTypeRecord> getAllItemTypes() {
        Query allMembersQuery = entityManager.createNamedQuery(ItemTypeRecord.ALL_ITEM_TYPES_QUERY);
        List results = allMembersQuery.getResultList();
        return (List<ItemTypeRecord>) results;
    }

    @NotNull
    @Override
    public List<RoleRecord> getAllRoles() {
        Query allRolesQuery = entityManager.createNamedQuery(RoleRecord.ALL_ROLES_QUERY);
        List results = allRolesQuery.getResultList();
        return (List<RoleRecord>) results;
    }

    @NotNull
    @Override
    public List<CategoryRecord> getAllCategories() {
        Query allCategoriesQuery = entityManager.createNamedQuery(CategoryRecord.ALL_CATEGORIES_QUERY);
        List results = allCategoriesQuery.getResultList();
        return (List<CategoryRecord>) results;
    }

    @NotNull
    @Override
    public List<FeatureRecord> getAllFeatures() {
        Query allFeaturesQuery = entityManager.createNamedQuery(FeatureRecord.ALL_FEATURES_QUERY);
        List results = allFeaturesQuery.getResultList();
        return (List<FeatureRecord>) results;
    }

    @NotNull
    @Override
    public List<ItemRecord> getAllItems() {
        Query allItemsQuery = entityManager.createNamedQuery(ItemRecord.ALL_ITEMS_QUERY);
        List results = allItemsQuery.getResultList();
        return (List<ItemRecord>) results;
    }

    @NotNull
    @Override
    public List<ItemRecord> getItemsForQuery(@Nullable SearchQuery searchQuery) {
        List<ItemRecord> results = new ArrayList<ItemRecord>();
        if (searchQuery == null) {
            return results;
        }
        Parameter<String> parameter = searchQuery.getSearchParameters();
        Collection<String> parameterValues = parameter.getParameters();
        for (String searchTerm : parameterValues) {
            Query itemSearchQuery = entityManager.createNamedQuery(ItemRecord.ITEM_NAME_QUERY);
            itemSearchQuery.setParameter("name", "%" + searchTerm + "%");
            List<ItemRecord> searchResults = (List<ItemRecord>) itemSearchQuery.getResultList();
            results.addAll(searchResults);
        }
        return results;
    }

    @NotNull
    @Override
    public List<PropertyRecord> getAllProperties() {
        Query allPropertiesQuery = entityManager.createNamedQuery(PropertyRecord.ALL_PROPERTIES_QUERY);
        List results = allPropertiesQuery.getResultList();
        return (List<PropertyRecord>) results;
    }


    @NotNull
    @Override
    public List<FeatureRecord> featuresForRole(String role) {
        Query featuresForRoleQuery = entityManager.createNamedQuery(FeatureRecord.FEATURES_FOR_ROLE_QUERY);
        featuresForRoleQuery.setParameter("role", role);
        return (List<FeatureRecord>) featuresForRoleQuery.getResultList();
    }

    @NotNull
    @Override
    public List<ItemPropertyRecord> propertiesForItem(ItemRecord itemRecord) {
        Query itemPropertiesQuery = entityManager.createNamedQuery(ItemPropertyRecord.ITEM_PROPERTY_QUERY);
        itemPropertiesQuery.setParameter("itemRecord", itemRecord);
        return (List<ItemPropertyRecord>) itemPropertiesQuery.getResultList();
    }

    @Nullable
    @Override
    public ItemRecord itemWithId(long expectedItemID) {
        Query itemIDQuery = entityManager.createNamedQuery(ItemRecord.ITEM_ID_QUERY);
        itemIDQuery.setParameter("id", expectedItemID);
        List<ItemRecord> itemRecords = (List<ItemRecord>) itemIDQuery.getResultList();
        ItemRecord itemRecord = null;
        if ((itemRecords != null) && (itemRecords.size() > 0)) {
            itemRecord = itemRecords.get(0);
        }
        return itemRecord;
    }

    @NotNull
    @Override
    public List<RoleFeatureRecord> getAllRoleFeatures() {
        Query allRoleFeaturesQuery = entityManager.createNamedQuery(RoleFeatureRecord.ALL_ROLE_FEATURES);
        return (List<RoleFeatureRecord>) allRoleFeaturesQuery.getResultList();
    }

    @Override
    public void addMultipleItemRecords(@NotNull List<ItemRecordWithProperties> itemRecords) {
        int recordCounter = 0;
        final int flushCount = 20;
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        for (ItemRecordWithProperties itemRecordWithProperties : itemRecords) {
            ItemRecord itemRecord = itemRecordWithProperties.getItemRecord();
            List<ItemPropertyRecord> itemPropertyRecords = itemRecordWithProperties.getItemProperties();
            entityManager.persist(itemRecord);
            recordCounter++;
            for (ItemPropertyRecord itemPropertyRecord : itemPropertyRecords) {
                entityManager.persist(itemPropertyRecord);
                recordCounter++;
            }
            if (recordCounter % flushCount == 0) {
                entityManager.flush();
            }
        }
        transaction.commit();
    }

    @Override
    public void addMultipleItemInstanceRecords(@NotNull List<ItemInstanceRecordWithProperties> itemInstanceRecordWithProperties) {
        int recordCounter = 0;
        final int flushCount = 20;
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        for (ItemInstanceRecordWithProperties itemInstance : itemInstanceRecordWithProperties) {
            ItemInstanceRecord itemInstanceRecord = itemInstance.getItemInstanceRecord();
            List<ItemInstancePropertyRecord> itemInstancePropertyRecords = itemInstance.getItemInstancePropertyRecords();
            entityManager.persist(itemInstanceRecord);
            recordCounter++;
            for (ItemInstancePropertyRecord itemInstancePropertyRecord : itemInstancePropertyRecords) {
                entityManager.persist(itemInstancePropertyRecord);
                recordCounter++;
            }
            if (recordCounter % flushCount == 0) {
                entityManager.flush();
            }
        }
        //transaction.rollback();
        transaction.commit();
    }
}