/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * User: rixon|Date: 8/22/12|Time: 1:05 PM
 */
@Entity
@Table(name = "ROLE")
@NamedQuery(name = RoleRecord.ALL_ROLES_QUERY,query = "select role from RoleRecord role")
public class RoleRecord {

    public static final String ALL_ROLES_QUERY = "all_roles_query";

    private int id;
    private String role;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_id_gen")
    @SequenceGenerator(name="role_id_gen",sequenceName = "role_id_seq",allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
