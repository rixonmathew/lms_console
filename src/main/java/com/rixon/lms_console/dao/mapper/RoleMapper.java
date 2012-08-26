/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Role;
import com.rixon.lms_console.dao.recordset.RoleRecord;

/**
 * This class is used to map the RoleRecord to Role
 * User: rixon|Date: 8/25/12|Time: 8:58 PM
 */
public class RoleMapper {
    public static Role mapToRole(RoleRecord roleRecord) {
        Role.RoleBuilder roleBuilder = new Role.RoleBuilder();
        roleBuilder.setId(roleRecord.getId());
        roleBuilder.setDescription(roleRecord.getDescription());
        roleBuilder.setRole(roleRecord.getRole());
        return roleBuilder.createRole();
    }
}
