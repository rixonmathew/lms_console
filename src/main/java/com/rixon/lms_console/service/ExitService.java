/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.ResultWithMessage;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the service for exit operation
 * User: rixon|Date: 8/18/12|Time: 9:24 PM
 */
public class ExitService implements Service {
    //TODO how to keep duplication to minimum between real and stub services
    private static final String EXIT_MESSAGE = "Have a good day :-)";

    @NotNull
    @Override
    public Result invoke(Parameter<String> parameter) {
        String exitMessage = EXIT_MESSAGE;
        List<String> messages = new ArrayList<String>();
        messages.add(exitMessage);
        return new ResultWithMessage(messages);
    }
}
