/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.ResultWithMessage;
import com.rixon.lms_console.service.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the stub service for Exit operation
 * User: rixon|Date: 8/18/12|Time: 8:37 PM
 */
public class ExitServiceStub implements Service {

    private static final String EXIT_MESSAGE = "Have a good day :-)";

    @NotNull
    @Override
    public Result execute(Parameter<String> parameter) {
        String exitMessage = EXIT_MESSAGE;
        List<String> messages = new ArrayList<String>();
        messages.add(exitMessage);
        return new ResultWithMessage(messages);
    }
}
