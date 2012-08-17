/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;

/**
 * User: 229921|Date: 8/17/12|Time: 11:31 PM
 */
public class IssueService implements Service {
    @Override
    public Result executeService(Parameter<String> parameter) {
        return null;  //TODO inject DAO and get the data from there.
    }
}
