/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service;

import com.rixon.lms_console.business.SimpleStore;
import com.rixon.lms_console.business.Store;
import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.ReservationResult;
import com.rixon.lms_console.command.result.Result;

import java.util.List;

/**
 * User: rixonmathew
 * Date: 05/12/12
 * Time: 1:07 AM
 */
public class ReserveItemService implements Service {
    @Override
    public Result execute(Parameter<String> parameter) {
        List<String> parameterValues = (List<String>) parameter.getParameters();
        Long itemInstanceId = Long.valueOf(parameterValues.get(0));
        Long memberId = Long.valueOf(parameterValues.get(1));
        Store store = SimpleStore.getInstance();
        List results = store.reserveItemForUser(itemInstanceId, memberId);
        return new ReservationResult(results);
    }
}
