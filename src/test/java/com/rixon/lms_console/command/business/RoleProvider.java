/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.business.SimpleStore;
import com.rixon.lms_console.business.Store;
import com.rixon.lms_console.dao.Role;
import com.rixon.lms_console.dao.mapper.RoleMapper;
import com.rixon.lms_console.dao.recordset.RoleRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to access
 * User: rixon|Date: 9/1/12|Time: 9:28 PM
 */
public class RoleProvider {

    private static Map<String, Role> roleMap;

    static {
        loadRoleMap();
    }

    private static void loadRoleMap() {
        Store store = SimpleStore.getInstance();
        roleMap = new HashMap<String, Role>();
        List<RoleRecord> roleRecordList = store.allRoles();
        for (RoleRecord roleRecord : roleRecordList) {
            Role role = RoleMapper.mapToRole(roleRecord);
            roleMap.put(role.getRole(), role);
        }
    }

    public static Role roleForName(String roleName) {
        Role role = roleMap.get(roleName);
        if (role == null) {
            throw new IllegalArgumentException("Invalid role name" + roleName);
        }
        return role;
    }
}
