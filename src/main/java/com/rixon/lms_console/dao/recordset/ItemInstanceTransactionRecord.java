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
 * Time: 12:25 AM
 */
@Entity
@Table(name = "ITEM_INSTANCE_TRANSACTION")
public class ItemInstanceTransactionRecord {

    private long id;
    private ItemInstanceRecord itemInstanceRecord;
    private TransactionTypeRecord transactionTypeRecord;
    private MemberRecord memberRecord;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_instance_transaction_id_gen")
    @SequenceGenerator(name = "item_instance_transaction_id_gen", sequenceName = "item_instance_transaction_id_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ITEM_INSTANCE_ID")
    public ItemInstanceRecord getItemInstanceRecord() {
        return itemInstanceRecord;
    }

    public void setItemInstanceRecord(ItemInstanceRecord itemInstanceRecord) {
        this.itemInstanceRecord = itemInstanceRecord;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "TRANSACTION_TYPE_ID")
    public TransactionTypeRecord getTransactionTypeRecord() {
        return transactionTypeRecord;
    }

    public void setTransactionTypeRecord(TransactionTypeRecord transactionTypeRecord) {
        this.transactionTypeRecord = transactionTypeRecord;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "MEMBER_ID")
    public MemberRecord getMemberRecord() {
        return memberRecord;
    }

    public void setMemberRecord(MemberRecord memberRecord) {
        this.memberRecord = memberRecord;
    }
}
