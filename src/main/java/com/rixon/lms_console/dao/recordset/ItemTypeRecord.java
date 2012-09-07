/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This class represents a record of ItemType
 * User: rixon|Date: 8/20/12|Time: 1:06 PM
 */
@Entity
@Table(name = "ITEM_TYPE")
@NamedQuery(name = ItemTypeRecord.ALL_ITEM_TYPES_QUERY, query = "select a from ItemTypeRecord a")
public class ItemTypeRecord {
    public final static String ALL_ITEM_TYPES_QUERY = "allItemTypes";
    private Integer id;
    private String type;
    private String description;

    public ItemTypeRecord() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
