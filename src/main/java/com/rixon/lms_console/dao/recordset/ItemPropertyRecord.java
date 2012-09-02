/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This class represents a record in ITEM_PROPERTY_TABLE
 * User: rixon|Date: 8/22/12|Time: 7:59 PM
 */
@Entity()
@Table(name = "ITEM_PROPERTY")
@NamedQuery(name = ItemPropertyRecord.ITEM_PROPERTY_QUERY, query = "select itemProperty from " +
        "ItemPropertyRecord itemProperty where itemProperty.itemRecord = :itemRecord"
)
public class ItemPropertyRecord {
    public static final String ITEM_PROPERTY_QUERY = "all_item_property_query";
    private int id;
    private ItemRecord itemRecord;
    private PropertyRecord propertyRecord;
    private String value;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_property_id_gen")
    @SequenceGenerator(name = "item_property_id_gen", sequenceName = "item_property_id_seq", allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    public ItemRecord getItemRecord() {
        return itemRecord;
    }

    public void setItemRecord(ItemRecord itemRecord) {
        this.itemRecord = itemRecord;
    }

    @ManyToOne
    @JoinColumn(name = "PROPERTY_ID")
    public PropertyRecord getPropertyRecord() {
        return propertyRecord;
    }

    public void setPropertyRecord(PropertyRecord propertyRecord) {
        this.propertyRecord = propertyRecord;
    }

    @Column(name = "PROPERTY_VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ItemPropertyRecord{" +
                "id=" + id +
                ", itemRecord=" + itemRecord +
                ", propertyRecord=" + propertyRecord +
                ", value='" + value + '\'' +
                '}';
    }
}
