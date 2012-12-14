/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import org.jetbrains.annotations.Nullable;

/**
 * This class implements the service for issue operation
 * User: rixon|Date: 8/17/12|Time: 11:31 PM
 */
public class IssueService implements Service {
    @Nullable
    @Override
    public Result invoke(Parameter<String> parameter) {
        return null;  //TODO inject DAO and get the data from there.
    }
}
