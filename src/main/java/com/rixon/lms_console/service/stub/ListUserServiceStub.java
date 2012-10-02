/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.ListUserResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.dao.Member;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  Stub servcice for unit testing
 *  User: rixon|Date: 9/19/12|Time: 9:04 PM
 */
public class ListUserServiceStub implements Service {
    @Override
    public Result execute(Parameter<String> parameter) {
        List<Member> members = new ArrayList<Member>();
        members.add(createMockMember("Rixon","Mathew","rixonmathew@gmail.com"));
        members.add(createMockMember("John","Barrow","johnbarrow@gmail.com"));
        members.add(createMockMember("Steve","Jobs","jobs@apple.com"));
        members.add(createMockMember("Little","Johnny","littlejohn@arthur.com"));
        return new ListUserResult(members);
    }

    private Member createMockMember(String firstName,String lastName,String emailID) {
        Member.MemberBuilder builder = new Member.MemberBuilder();
        builder.setId(101);
        builder.setFirstName(firstName);
        builder.setLastName(lastName);
        builder.setEmailID(emailID);
        builder.setPassword("mockPass");
        return builder.createMember();
    }
}
