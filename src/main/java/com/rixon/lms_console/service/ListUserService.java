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
import com.rixon.lms_console.command.result.ListUserResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the service for List command
 * User: rixon|Date: 9/19/12|Time: 9:39 PM
 */
public class ListUserService implements Service {
    @Override
    public Result execute(Parameter<String> parameter) {
        List<String> parameterValues = (List<String>) parameter.getParameters();
        List<Member> members = new ArrayList<Member>();
        Store store = SimpleStore.getInstance();
        if ((parameterValues == null) || (parameterValues.size() == 0)) {
            members = store.allMembers();
        } else {
            long id = Long.valueOf(parameterValues.get(0));
            Member member = store.memberById(id);
            members.add(member);
        }
        return new ListUserResult(members);
    }
}
