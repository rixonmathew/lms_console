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

import java.util.ArrayList;
import java.util.List;

/**
 * User: 229921|Date: 8/18/12|Time: 9:24 PM
 */
public class ExitService implements Service {
    //TODO how to keep duplication to minimum between real and mock services
    private static final String EXIT_MESSAGE = "Have a good day :-)";
    @Override
    public Result executeService(Parameter<String> parameter) {
        String exitMessage = EXIT_MESSAGE;
        List<String> messages = new ArrayList<String>();
        messages.add(exitMessage);
        return new ResultWithMessage(messages);
    }
}
