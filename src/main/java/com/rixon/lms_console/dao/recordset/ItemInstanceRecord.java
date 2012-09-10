/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This class is used to model the entity ITEM_INSTANCE
 * User: rixon|Date: 9/10/12|Time: 1:45 PM
 */
@Entity()
@Table(name = "ITEM_INSTANCE")
@NamedQueries({
        @NamedQuery(name = ItemInstanceRecord.ALL_ITEM_INSTANCES_QUERY,
                query = "select itemInstance from ItemInstanceRecord itemInstance"),
        @NamedQuery(name = ItemInstanceRecord.ITEM_RECORD_QUERY,
                query = "select itemInstance from ItemInstanceRecord itemInstance " +
                        "where itemInstance.itemRecord = :itemRecord")
})
public class ItemInstanceRecord {

    private long id;
    private ItemRecord itemRecord;
    public static final String ALL_ITEM_INSTANCES_QUERY = "all_item_instances_query";
    public static final String ITEM_RECORD_QUERY = "item_record_query";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_instance_id_gen")
    @SequenceGenerator(name = "item_instance_id_gen", sequenceName = "item_instance_id_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ITEM_ID")
    public ItemRecord getItemRecord() {
        return itemRecord;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItemRecord(ItemRecord itemRecord) {
        this.itemRecord = itemRecord;
    }

    @Override
    public String toString() {
        return "ItemInstanceRecord{" +
                "id=" + id +
                ", itemRecord=" + itemRecord +
                '}';
    }
}