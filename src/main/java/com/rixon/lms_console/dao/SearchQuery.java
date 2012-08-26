/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import com.rixon.lms_console.command.Parameter;

/**
 * This class represents the entity for performing the search
 * User: rixon|Date: 8/25/12|Time: 9:10 PM
 */
public class SearchQuery {

    private Parameter<String> searchParameters;
    private boolean anyFieldMatch;

    public SearchQuery(Parameter<String> searchParameters, boolean anyFieldMatch) {
        this.searchParameters = searchParameters;
        this.anyFieldMatch = anyFieldMatch;
    }

    public Parameter<String> getSearchParameters() {
        return searchParameters;
    }

    public boolean isAnyFieldMatch() {
        return anyFieldMatch;
    }
}
