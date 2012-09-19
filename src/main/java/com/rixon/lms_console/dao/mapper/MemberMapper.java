/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Member;
import com.rixon.lms_console.dao.recordset.MemberRecord;

/**
 * This class will perform the mapping between the member record and member entity
 * User: rixon|Date: 9/19/12|Time: 9:52 PM
 */
public class MemberMapper {
    public static Member mapToMember(MemberRecord memberRecord) {
        Member.MemberBuilder builder = new Member.MemberBuilder();
        if (memberRecord!=null) {
            builder.setId(memberRecord.getId());
            builder.setFirstName(memberRecord.getFirstName());
            builder.setLastName(memberRecord.getLastName());
            builder.setEmailID(memberRecord.getEmailId());
            builder.setPassword(memberRecord.getPassword());
        }
        return builder.createMember();
    }
}
