/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.dao.Role;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * This class is used for testing the Role
 * User: rixon|Date: 9/1/12|Time: 9:21 PM
 */
public class RoleProviderTest {

    @Test
    public void testValidRole() {
        final String expectedRoleName = "MEMBER";
        final String expectedDescription = "Member of the Library";
        Role role = RoleProvider.roleForName(expectedRoleName);
        assertNotNull(role);
        assertThat("Role name is not as expected", expectedRoleName, equalTo(role.getRole()));
        assertThat("Role description is not as expected", expectedDescription, equalTo(role.getDescription()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRole() {
        final String expectedRoleName = "SUPERUSER";
        RoleProvider.roleForName(expectedRoleName);
        fail("An exception should have been raised");
    }
}