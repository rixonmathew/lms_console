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
 * User: rixon|Date: 8/22/12|Time: 1:42 PM
 */
@Entity
@Table(name = "Feature")
@NamedQueries({
        @NamedQuery(name = FeatureRecord.ALL_FEATURES_QUERY, query = "select feature from FeatureRecord feature"),
        @NamedQuery(name = FeatureRecord.FEATURES_FOR_ROLE_QUERY,
                query = "select feature from FeatureRecord feature,RoleFeatureRecord roleFeature,RoleRecord roleRecord" +
                        " where roleRecord.role=:role and roleFeature.role_id=roleRecord.id and " +
                        "feature.id = roleFeature.feature_id and roleFeature.allowed = 'Y'"
        )
})

public class FeatureRecord {

    public static final String ALL_FEATURES_QUERY = "all_features_query";
    public static final String FEATURES_FOR_ROLE_QUERY = "features_for_role_query";

    private int id;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_id_gen")
    @SequenceGenerator(name = "feature_id_gen", sequenceName = "feature_id_seq", allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "FEATURE")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
