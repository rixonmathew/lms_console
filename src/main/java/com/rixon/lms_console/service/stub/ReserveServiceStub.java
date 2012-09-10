/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.ReservationResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.service.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * User: rixon|Date: 8/23/12|Time: 8:49 PM
 */
public class ReserveServiceStub implements Service {
    @NotNull
    @Override
    public Result execute(Parameter<String> parameter) {
        String returnResult = "Reserved book successfully";
        List<String> messages = new ArrayList<String>();
        messages.add(returnResult);
        return new ReservationResult(messages);
    }
}
