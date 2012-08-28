/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This entity represents a record in the Role table
 * User: rixon|Date: 8/22/12|Time: 1:24 PM
 */
@Entity
@Table(name = "CATEGORY")
@NamedQuery(name = CategoryRecord.ALL_CATEGORIES_QUERY,query = "select category from CategoryRecord category")
public class CategoryRecord {

    public static final String ALL_CATEGORIES_QUERY = "all_categories_query";

    private int id;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_id_gen")
    @SequenceGenerator(name="category_id_gen",sequenceName = "category_id_seq",allocationSize = 1)
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
        return "CategoryRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
