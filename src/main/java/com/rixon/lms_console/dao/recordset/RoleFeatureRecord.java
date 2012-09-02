/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * User: rixon|Date: 9/2/12|Time: 11:40 AM
 */
@Entity
@Table(name = "ROLE_FEATURE")
public class RoleFeatureRecord {

    private int id;
    private int role_id;
    private int feature_id;
    private String allowed;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_feature_id_gen")
    @SequenceGenerator(name = "role_feature_id_gen", sequenceName = "role_feature_id_seq", allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ROLE_ID")
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Column(name = "FEATURE_ID")
    public int getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(int feature_id) {
        this.feature_id = feature_id;
    }

    @Column(name = "ALLOWED")
    public String isAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }
}
