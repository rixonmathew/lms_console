/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.dao;

import com.rixon.lms_console.dao.recordset.MemberRecord;
import org.jetbrains.annotations.NotNull;

/**
 * This class provides stub data objects for help in testing
 * User: rixon|Date: 8/20/12|Time: 12:52 PM
 */
class DAOMockDataProvider {
    @NotNull
    public static MemberRecord getMemberRecord(String firstName, String lastName, String email, String mobileNumber, String postalAddress, String password) {
        MemberRecord memberRecord = new MemberRecord();
        memberRecord.setFirstName(firstName);
        memberRecord.setLastName(lastName);
        memberRecord.setEmailId(email);
        memberRecord.setPassword(password);
        return memberRecord;
    }
}