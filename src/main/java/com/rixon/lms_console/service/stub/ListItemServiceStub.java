/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.ListItemResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the stub service implementation for list-item service
 * User: rixon|Date: 10/2/12|Time: 12:24 PM
 */
public class ListItemServiceStub implements Service {
    @Override
    public Result execute(Parameter<String> parameter) {
        List<Item> items = new ArrayList<Item>();
        Item item = MockItemsProvider.createMockItem("Book1", "A sample Book");
        items.add(item);
        return new ListItemResult(items);
    }
}
