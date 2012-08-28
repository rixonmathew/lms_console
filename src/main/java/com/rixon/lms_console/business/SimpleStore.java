/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.SearchResult;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.LMSDao;
import com.rixon.lms_console.dao.SearchQuery;
import com.rixon.lms_console.dao.factory.DAOFactory;
import com.rixon.lms_console.dao.mapper.ItemMapper;
import com.rixon.lms_console.dao.recordset.CategoryRecord;
import com.rixon.lms_console.dao.recordset.ItemRecord;
import com.rixon.lms_console.dao.recordset.ItemTypeRecord;
import com.rixon.lms_console.dao.recordset.PropertyRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * User: rixon|Date: 8/25/12|Time: 9:16 PM
 */
public class SimpleStore implements Store {

    private LMSDao lmsDao;

    private static Store storeInstance;

    public static Store getInstance() {
        if (storeInstance==null) {
            storeInstance = new SimpleStore();
        }
        return storeInstance;
    }


    private SimpleStore() {
        lmsDao = DAOFactory.lmsDao();
    }


    @Override
    public Result searchItemByTitle(SearchQuery searchQuery) {
        List<ItemRecord> itemRecords= lmsDao.getAllItems();
        //TODO replace get all Items with an equivalent dao method to search by title only
        List<Item> items = new ArrayList<Item>();
        for (ItemRecord itemRecord:itemRecords) {
            Item item = ItemMapper.mapToItem(itemRecord);
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
    public void addItemsToLibrary(List<Item> items) {
        List<ItemRecord> itemRecords = new ArrayList<ItemRecord>();
        for (Item item:items) {
            ItemRecord itemRecord = ItemMapper.mapToItemRecord(item);
            itemRecords.add(itemRecord);
        }
        if (itemRecords.size()>0) {
            lmsDao.addMultipleItemRecords(itemRecords);
        }
    }
}
