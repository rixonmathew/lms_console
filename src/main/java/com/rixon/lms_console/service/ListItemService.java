/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service;

import com.rixon.lms_console.business.SimpleStore;
import com.rixon.lms_console.business.Store;
import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.ListItemResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the service corresponding to the operation list-item
 * User: rixon|Date: 10/2/12|Time: 12:23 PM
 */
public class ListItemService implements Service {
    @Override
    public Result invoke(Parameter<String> parameter) {
        List<String> parameterValues = (List<String>) parameter.getParameters();
        String itemIdString = parameterValues.get(0);
        long itemId = Long.parseLong(itemIdString);
        Store store = SimpleStore.getInstance();
        Item item = store.searchItemById(itemId);
        List<Item> items = new ArrayList<Item>();
        items.add(item);
        return new ListItemResult(items);
    }
}
