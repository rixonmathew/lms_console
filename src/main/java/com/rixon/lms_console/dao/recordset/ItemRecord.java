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
 * This class represents the record in Item table
 * User: rixon|Date: 8/22/12|Time: 7:29 PM
 */
@Entity()
@Table(name = "ITEM")
@NamedQueries({
        @NamedQuery(name = ItemRecord.ALL_ITEMS_QUERY, query = "select item from ItemRecord item"),
        @NamedQuery(name = ItemRecord.ITEM_ID_QUERY, query = "select item from ItemRecord item where item.id=:id"),
        @NamedQuery(name = ItemRecord.ITEM_NAME_QUERY, query = "select item from ItemRecord item where item.name like :name")
})
public class ItemRecord {
    public static final String ALL_ITEMS_QUERY = "all_items_query";
    public static final String ITEM_ID_QUERY = "item_id_query";
    public static final String ITEM_NAME_QUERY = "item_name_query";
    private int id;
    private ItemTypeRecord itemTypeRecord;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_gen")
    @SequenceGenerator(name = "item_id_gen", sequenceName = "item_id_seq", allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ITEM_TYPE_ID")
    public ItemTypeRecord getItemTypeRecord() {
        return itemTypeRecord;
    }

    public void setItemTypeRecord(ItemTypeRecord itemTypeRecord) {
        this.itemTypeRecord = itemTypeRecord;
    }

    @Column(name = "NAME")
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

    @NotNull
    @Override
    public String toString() {
        return "ItemRecord{" +
                "id=" + id +
                ", itemTypeRecord=" + itemTypeRecord +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
