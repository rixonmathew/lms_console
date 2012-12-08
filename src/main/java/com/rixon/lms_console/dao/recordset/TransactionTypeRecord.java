/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * User: rixonmathew
 * Date: 09/12/12
 * Time: 12:27 AM
 */
@Entity()
@Table(name = "TRANSACTION_TYPE")
@NamedQuery(name = TransactionTypeRecord.ALL_TRANSACTION_TYPES_QUERY, query = "select transactionTypeRecord from TransactionTypeRecord transactionTypeRecord")
public class TransactionTypeRecord {

    public static final String ALL_TRANSACTION_TYPES_QUERY = "all_transaction_types";
    private long id;
    private String type;
    private String description;

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
