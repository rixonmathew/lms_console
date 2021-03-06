/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.TransferResult;
import com.rixon.lms_console.service.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the stub service for transfer operation
 * User: rixon|Date: 8/17/12|Time: 11:39 PM
 */
public class TransferServiceStub implements Service {
    @NotNull
    @Override
    public Result invoke(Parameter<String> parameter) {
        String result = "Book transferred successfully to user";
        List<String> issueResult = new ArrayList<String>();
        issueResult.add(result);
        return new TransferResult(issueResult);
    }
}
