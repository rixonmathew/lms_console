/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

/**
 * User: rixon|Date: 9/10/12|Time: 1:57 PM
 */
@Entity()
@Table(name = "ITEM_INSTANCE_PROPERTY")
@NamedQueries({
        @NamedQuery(name = ItemInstancePropertyRecord.ITEM_INSTANCE_PROPERTY_QUERY,
                query = "select itemInstanceProperty from ItemInstancePropertyRecord itemInstanceProperty " +
                        "where itemInstanceProperty.itemInstanceRecord = :itemInstanceRecord")
})
public class ItemInstancePropertyRecord {

    private int id;
    private ItemInstanceRecord itemInstanceRecord;
    private PropertyRecord propertyRecord;
    private String value;
    public static final String ITEM_INSTANCE_PROPERTY_QUERY = "item_instance_property_query";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_instance_property_id_gen")
    @SequenceGenerator(name = "item_instance_property_id_gen", sequenceName = "item_instance_property_id_seq",
            allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_INSTANCE_ID")
    public ItemInstanceRecord getItemInstanceRecord() {
        return itemInstanceRecord;
    }

    public void setItemInstanceRecord(ItemInstanceRecord itemInstanceRecord) {
        this.itemInstanceRecord = itemInstanceRecord;
    }

    @ManyToOne(cascade = CascadeType.ALL)
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

    @NotNull
    @Override
    public String toString() {
        return "ItemInstancePropertyRecord{" +
                "id=" + id +
                ", itemInstanceRecord=" + itemInstanceRecord +
                ", propertyRecord=" + propertyRecord +
                ", value='" + value + '\'' +
                '}';
    }
}
