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
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.SearchQuery;

/**
 * This class implements the service for search operation
 * User: rixon|Date: 8/17/12|Time: 7:20 PM
 */
public class SearchService implements Service {
    @Override
    public Result invoke(Parameter<String> parameter) {
        Store store = SimpleStore.getInstance();
        SearchQuery searchQuery = new SearchQuery(parameter, false);
        return store.searchItemByTitle(searchQuery);
    }
}
