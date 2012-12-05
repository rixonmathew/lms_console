/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.SearchResult;
import com.rixon.lms_console.dao.*;
import com.rixon.lms_console.dao.factory.DAOFactory;
import com.rixon.lms_console.dao.mapper.ItemInstanceMapper;
import com.rixon.lms_console.dao.mapper.ItemMapper;
import com.rixon.lms_console.dao.mapper.MemberMapper;
import com.rixon.lms_console.dao.recordset.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * User: rixon|Date: 8/25/12|Time: 9:16 PM
 */
public class SimpleStore implements Store {

    @Nullable
    private final LMSDao lmsDao;

    private static Store storeInstance;

    public static Store getInstance() {
        if (storeInstance == null) {
            storeInstance = new SimpleStore();
        }
        return storeInstance;
    }


    private SimpleStore() {
        lmsDao = DAOFactory.lmsDao();
    }


    @NotNull
    @Override
    public Result searchItemByTitle(SearchQuery searchQuery) {
        List<ItemRecord> itemRecords = lmsDao.getItemsForQuery(searchQuery);
        //TODO replace get all Items with an equivalent dao method to search by title only
        List<Item> items = new ArrayList<Item>();
        for (ItemRecord itemRecord : itemRecords) {
            List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
            Item item = ItemMapper.mapToItem(itemRecord, itemPropertyRecords);
            items.add(item);
        }
        return new SearchResult(items);
    }

    @Override
    public List<PropertyRecord> allProperties() {
        return lmsDao.getAllProperties();
    }

    @Override
    public List<ItemTypeRecord> allItemTypes() {
        return lmsDao.getAllItemTypes();
    }

    @Override
    public List<CategoryRecord> allCategories() {
        return lmsDao.getAllCategories();
    }

    @Override
    public List<RoleRecord> allRoles() {
        return lmsDao.getAllRoles();
    }

    @Override
    public List<FeatureRecord> allFeatures() {
        return lmsDao.getAllFeatures();
    }

    @Override
    public List<FeatureRecord> featuresForRole(String role) {
        return lmsDao.featuresForRole(role);
    }

    @NotNull
    @Override
    public List<Item> allItems() {
        List<Item> items = new ArrayList<Item>();
        List<ItemRecord> itemRecords = lmsDao.getAllItems();
        for (ItemRecord itemRecord : itemRecords) {
            List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
            Item item = ItemMapper.mapToItem(itemRecord, itemPropertyRecords);
            items.add(item);
        }
        return items;
    }

    @Override
    public void addItemsToLibrary(@NotNull List<Item> items) {
        List<ItemRecordWithProperties> itemRecords = new ArrayList<ItemRecordWithProperties>();
        for (Item item : items) {
            ItemRecord itemRecord = ItemMapper.mapToItemRecord(item);
            List<ItemPropertyRecord> itemPropertyRecords = ItemMapper.
                    mapItemPropertyRecords(item.allPropertiesMap(), itemRecord);
            ItemRecordWithProperties.ItemRecordWithPropertiesBuilder builder =
                    new ItemRecordWithProperties.ItemRecordWithPropertiesBuilder();
            builder.setItemRecord(itemRecord);
            builder.setItemProperties(itemPropertyRecords);
            itemRecords.add(builder.createItem());
        }
        if (itemRecords.size() > 0) {
            lmsDao.addMultipleItemRecords(itemRecords);
        }
    }

    @Override
    public void addItemInstancesToLibrary(@NotNull List<ItemInstance> itemInstances) {
        List<ItemInstanceRecordWithProperties> itemInstanceRecordWithProperties =
                new ArrayList<ItemInstanceRecordWithProperties>();
        for (ItemInstance itemInstance : itemInstances) {
            ItemInstanceRecord itemInstanceRecord = ItemInstanceMapper.mapToItemInstanceRecord(itemInstance);
            List<ItemInstancePropertyRecord> itemInstancePropertyRecords = ItemInstanceMapper.
                    mapItemInstancePropertyRecords(itemInstance.allPropertiesMap(), itemInstanceRecord);
            ItemInstanceRecordWithProperties.ItemInstanceRecordWithPropertiesBuilder builder =
                    new ItemInstanceRecordWithProperties.ItemInstanceRecordWithPropertiesBuilder();
            builder.setItemInstanceRecord(itemInstanceRecord);
            builder.setItemInstancePropertyRecords(itemInstancePropertyRecords);
            itemInstanceRecordWithProperties.add(builder.createItemInstanceRecordWithProperties());
        }
        if (itemInstanceRecordWithProperties.size() > 0) {
            lmsDao.addMultipleItemInstanceRecords(itemInstanceRecordWithProperties);
        }
    }

    @Override
    public List<Member> allMembers() {
        List<Member> members = new ArrayList<Member>();
        List<MemberRecord> memberRecords = lmsDao.getAllMembers();
        for (MemberRecord memberRecord : memberRecords) {
            Member member = MemberMapper.mapToMember(memberRecord);
            members.add(member);
        }
        return members;
    }

    @Override
    public Member memberById(long id) {
        MemberRecord memberRecord = lmsDao.findMember(id);
        return MemberMapper.mapToMember(memberRecord);
    }

    @Override
    public Item searchItemById(long itemId) {
        ItemRecord itemRecord = lmsDao.itemWithId(itemId);
        List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
        return ItemMapper.mapToItem(itemRecord, itemPropertyRecords);
    }

    @Override
    public List reserveItemForUser(String itemId, String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
