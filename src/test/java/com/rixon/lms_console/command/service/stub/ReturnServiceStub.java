/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.ReturnResult;
import com.rixon.lms_console.service.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the stub service for return operation
 * User: rixon|Date: 8/18/12|Time: 7:37 AM
 */
public class ReturnServiceStub implements Service {
    @NotNull
    @Override
    public Result invoke(Parameter<String> parameter) {
        String returnResult = "Returned book successfully";
        List<String> messages = new ArrayList<String>();
        messages.add(returnResult);
        return new ReturnResult(messages);
    }
}
