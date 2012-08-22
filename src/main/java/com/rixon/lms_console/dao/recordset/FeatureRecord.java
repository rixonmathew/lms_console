/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This entity represents a record in the CATEGORY table
 *  User: rixon|Date: 8/22/12|Time: 1:42 PM
 */
@Entity
@Table(name = "Feature")
@NamedQuery(name = FeatureRecord.ALL_FEATURES_QUERY,query = "select feature from FeatureRecord feature")
public class FeatureRecord {

    public static final String ALL_FEATURES_QUERY = "all_features_query";
    private int id;
    private String feature;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "feature_id_gen")
    @SequenceGenerator(name="feature_id_gen",sequenceName = "feature_id_seq",allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="FEATURE")
    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
