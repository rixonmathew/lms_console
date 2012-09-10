/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.business.ItemTypeProvider;
import com.rixon.lms_console.dao.ItemType;
import com.rixon.lms_console.dao.recordset.ItemTypeRecord;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class is used for mapping the itemTypeRecord to ItemType
 * User: rixon|Date: 8/25/12|Time: 8:55 PM
 */
public class ItemTypeMapper {

    @NotNull
    public static ItemType mapToItemType(@NotNull ItemTypeRecord itemTypeRecord) {
        ItemType.ItemTypeBuilder itemTypeBuilder = new ItemType.ItemTypeBuilder();
        itemTypeBuilder.setDescription(itemTypeRecord.getDescription());
        itemTypeBuilder.setType(itemTypeRecord.getType());
        return itemTypeBuilder.createItemType();
    }

    @Nullable
    public static ItemTypeRecord mapToItemTypeRecord(@Nullable ItemType itemType) {
        if (itemType == null) {
            return null;
        }
        return ItemTypeProvider.getItemTypeRecord(itemType.getType());
    }
}
