/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.SearchResult;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.service.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the stub service for search operation
 * User: rixon|Date: 8/17/12|Time: 9:16 PM
 */
public class SearchServiceStub implements Service {
    @NotNull
    @Override
    public Result invoke(Parameter<String> parameter) {
        List<Item> items = new ArrayList<Item>();
        Item item = MockItemsProvider.createMockItem("Book1", "A sample Book");
        Item item2 = MockItemsProvider.createMockItem("Book2", "Sample book2");
        Item item3 = MockItemsProvider.createMockItem("Book3", "Sample book3");
        items.add(item);
        items.add(item2);
        items.add(item3);
        return new SearchResult(items);
    }

}
