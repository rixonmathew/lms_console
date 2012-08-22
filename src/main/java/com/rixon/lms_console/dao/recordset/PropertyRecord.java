/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This class represents a record in the table Property
 * User:rixon|Date: 8/22/12|Time: 7:48 PM
 */
@Entity
@Table(name="PROPERTY")
@NamedQuery(name= PropertyRecord.ALL_PROPERTIES_QUERY,query="select property from PropertyRecord property")
public class PropertyRecord {
    public static final String ALL_PROPERTIES_QUERY = "all_property_query";

    private int id;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "property_id_gen")
    @SequenceGenerator(name="property_id_gen",sequenceName = "property_id_seq",allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PropertyRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}