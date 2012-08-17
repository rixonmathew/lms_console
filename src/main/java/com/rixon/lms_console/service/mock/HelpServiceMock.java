/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.mock;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.OperationTypes;
import com.rixon.lms_console.command.result.HelpResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 229921|Date: 8/17/12|Time: 9:26 PM
 */
public class HelpServiceMock implements Service {
    @Override
    public Result executeService(Parameter<String> parameter) {
        List<String> commands = new ArrayList<String>();
        commands.add(OperationTypes.SEARCH);
        commands.add(OperationTypes.ISSUE);
        commands.add(OperationTypes.TRANSFER);
        commands.add(OperationTypes.RETURN);
        return new HelpResult(commands);
    }
}
