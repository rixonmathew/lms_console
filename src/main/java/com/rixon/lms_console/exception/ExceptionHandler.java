/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.exception;

import com.rixon.lms_console.exception.strategy.ExceptionHandlingStrategy;
import com.rixon.lms_console.exception.strategy.ExceptionStrategyContext;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has the responsibility of managing the exceptions in the applications. For each exception type the message to be propogated is
 * wrapped in a List. Stack trace is not provided as the intent is to display the messages to the user directly
 * User: rixonmathew
 * Date: 08/12/12
 * Time: 10:54 PM
 */
public class ExceptionHandler {

    public static List handleException(Exception e) {
        ExceptionHandlingStrategy strategy = ExceptionStrategyContext.strategyForException(e);
        strategy.handleException(e);
        List messages = new ArrayList();
        messages.add(e.getMessage());
        return messages;
    }
}