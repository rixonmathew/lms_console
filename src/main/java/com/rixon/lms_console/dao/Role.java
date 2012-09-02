/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

/**
 * This class represents the entity Role
 * User: rixon|Date: 8/25/12|Time: 9:00 PM
 */
public class Role {
    private String role;
    private String description;

    private Role(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public static class RoleBuilder {
        private String role;
        private String description;

        public RoleBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public RoleBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Role createRole() {
            return new Role(role, description);
        }
    }
}