/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.SearchResult;
import com.rixon.lms_console.dao.*;
import com.rixon.lms_console.dao.factory.DAOFactory;
import com.rixon.lms_console.dao.mapper.ItemInstanceMapper;
import com.rixon.lms_console.dao.mapper.ItemMapper;
import com.rixon.lms_console.dao.mapper.MemberMapper;
import com.rixon.lms_console.dao.recordset.*;
import com.rixon.lms_console.exception.ExceptionHandler;
import com.rixon.lms_console.exception.InvalidItemInstanceException;
import com.rixon.lms_console.exception.InvalidMemberException;
import com.rixon.lms_console.exception.ItemCannotBeReservedException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//TODO big class break into small classes

/**
 * User: rixon|Date: 8/25/12|Time: 9:16 PM
 */
public class SimpleStore implements Store {

    @NotNull
    private final LMSDao lmsDao;

    private static Store storeInstance;

    public static Store getInstance() {
        if (storeInstance == null) {
            storeInstance = new SimpleStore();
        }
        return storeInstance;
    }

    private SimpleStore() {
        lmsDao = DAOFactory.lmsDao();
    }


    @NotNull
    @Override
    public Result searchItemByTitle(SearchQuery searchQuery) {
        List<ItemRecord> itemRecords = lmsDao.getItemsForQuery(searchQuery);
        //TODO replace get all Items with an equivalent dao method to search by title only
        List<Item> items = new ArrayList<Item>();
        for (ItemRecord itemRecord : itemRecords) {
            List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
            Item item = ItemMapper.mapToItem(itemRecord, itemPropertyRecords);
            items.add(item);
        }
        return new SearchResult(items);
    }

    @Override
    public List<PropertyRecord> allProperties() {
        return lmsDao.getAllProperties();
    }

    @Override
    public List<ItemTypeRecord> allItemTypes() {
        return lmsDao.getAllItemTypes();
    }

    @Override
    public List<CategoryRecord> allCategories() {
        return lmsDao.getAllCategories();
    }

    @Override
    public List<RoleRecord> allRoles() {
        return lmsDao.getAllRoles();
    }

    @Override
    public List<FeatureRecord> allFeatures() {
        return lmsDao.getAllFeatures();
    }

    @Override
    public List<FeatureRecord> featuresForRole(String role) {
        return lmsDao.featuresForRole(role);
    }

    @NotNull
    @Override
    public List<Item> allItems() {
        List<Item> items = new ArrayList<Item>();
        List<ItemRecord> itemRecords = lmsDao.getAllItems();
        for (ItemRecord itemRecord : itemRecords) {
            List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
            Item item = ItemMapper.mapToItem(itemRecord, itemPropertyRecords);
            items.add(item);
        }
        return items;
    }

    @Override
    public void addItemsToLibrary(@NotNull List<Item> items) {
        List<ItemRecordWithProperties> itemRecords = new ArrayList<ItemRecordWithProperties>();
        for (Item item : items) {
            ItemRecord itemRecord = ItemMapper.mapToItemRecord(item);
            List<ItemPropertyRecord> itemPropertyRecords = ItemMapper.
                    mapItemPropertyRecords(item.allPropertiesMap(), itemRecord);
            ItemRecordWithProperties.ItemRecordWithPropertiesBuilder builder =
                    new ItemRecordWithProperties.ItemRecordWithPropertiesBuilder();
            builder.setItemRecord(itemRecord);
            builder.setItemProperties(itemPropertyRecords);
            itemRecords.add(builder.createItem());
        }
        if (itemRecords.size() > 0) {
            lmsDao.addMultipleItemRecords(itemRecords);
        }
    }

    @Override
    public void addItemInstancesToLibrary(@NotNull List<ItemInstance> itemInstances) {
        List<ItemInstanceRecordWithProperties> itemInstanceRecordWithProperties =
                new ArrayList<ItemInstanceRecordWithProperties>();
        for (ItemInstance itemInstance : itemInstances) {
            ItemInstanceRecord itemInstanceRecord = ItemInstanceMapper.mapToItemInstanceRecord(itemInstance);
            List<ItemInstancePropertyRecord> itemInstancePropertyRecords = ItemInstanceMapper.
                    mapItemInstancePropertyRecords(itemInstance.allPropertiesMap(), itemInstanceRecord);
            ItemInstanceRecordWithProperties.ItemInstanceRecordWithPropertiesBuilder builder =
                    new ItemInstanceRecordWithProperties.ItemInstanceRecordWithPropertiesBuilder();
            builder.setItemInstanceRecord(itemInstanceRecord);
            builder.setItemInstancePropertyRecords(itemInstancePropertyRecords);
            itemInstanceRecordWithProperties.add(builder.createItemInstanceRecordWithProperties());
        }
        if (itemInstanceRecordWithProperties.size() > 0) {
            lmsDao.addMultipleItemInstanceRecords(itemInstanceRecordWithProperties);
        }
    }

    @Override
    public List<Member> allMembers() {
        List<Member> members = new ArrayList<Member>();
        List<MemberRecord> memberRecords = lmsDao.getAllMembers();
        for (MemberRecord memberRecord : memberRecords) {
            Member member = MemberMapper.mapToMember(memberRecord);
            members.add(member);
        }
        return members;
    }

    @Override
    public Member memberById(long id) {
        MemberRecord memberRecord = lmsDao.findMember(id);
        return MemberMapper.mapToMember(memberRecord);
    }

    @Override
    public Item searchItemById(long itemId) {
        ItemRecord itemRecord = lmsDao.itemWithId(itemId);
        List<ItemPropertyRecord> itemPropertyRecords = lmsDao.propertiesForItem(itemRecord);
        return ItemMapper.mapToItem(itemRecord, itemPropertyRecords);
    }

    @Override
    public List reserveItemForUser(long itemInstanceId, long memberId) {
        //FIXME Is Store the right place for business logic?
        List messages = new ArrayList();
        ItemInstanceRecord itemInstanceRecord = lmsDao.findItemInstanceId(itemInstanceId);
        if (itemInstanceRecord == null) {
            messages = ExceptionHandler.handleException(new InvalidItemInstanceException(String.valueOf(itemInstanceId)));
            return messages;
        }
        MemberRecord memberRecord = lmsDao.findMember(memberId);
        if (memberRecord == null) {
            messages = ExceptionHandler.handleException(new InvalidMemberException(String.valueOf(memberId)));
            return messages;
        }

        ReservationCheck reservationCheck = isItemAvailableForReservation(itemInstanceRecord, memberRecord);
        if (!reservationCheck.isItemAvailableForReservation()) {
            messages = ExceptionHandler.handleException(new ItemCannotBeReservedException(reservationCheck.getMessage()));
        } else {
            persistReservation(itemInstanceRecord, memberRecord);
            messages.add(reservationCheck.getMessage());
        }
        return messages;
    }

    @Override
    public List<TransactionTypeRecord> allTransactionTypes() {
        return lmsDao.getAllTransactionTypes();
    }

    private void persistReservation(ItemInstanceRecord itemInstanceRecord, MemberRecord memberRecord) {
        ItemInstanceTransactionRecord itemInstanceTransactionRecord = new ItemInstanceTransactionRecord();
        itemInstanceTransactionRecord.setItemInstanceRecord(itemInstanceRecord);
        itemInstanceTransactionRecord.setMemberRecord(memberRecord);
        TransactionTypeRecord transactionTypeRecord = TransactionTypeProvdier.getTransactionTypeRecord("RESERVE"); //TODO create a constance class
        itemInstanceTransactionRecord.setTransactionTypeRecord(transactionTypeRecord);
        lmsDao.addItemInstanceTransaction(itemInstanceTransactionRecord);
    }

    private ReservationCheck isItemAvailableForReservation(ItemInstanceRecord itemInstanceRecord, MemberRecord memberRecord) {
        //TODO Add business logic here for reservation checks
        //Item instance should not be damaged
        //Member has not exceeded the limit of reserving the items
        //
        boolean isItemAvailableForReservation = false;
        String reservationMessage = "Item Reserved Successfully";
        boolean isItemInstanceDamaged = isItemInstanceDamaged(itemInstanceRecord);
        if (isItemInstanceDamaged) {
            reservationMessage = "Item cannot be reserved as it is damaged";
        }
        return new ReservationCheck(isItemAvailableForReservation, reservationMessage);
    }

    private boolean isItemInstanceDamaged(ItemInstanceRecord itemInstanceRecord) {
        List<ItemInstancePropertyRecord> itemInstancePropertyRecords = lmsDao.propertiesForItemInstance(itemInstanceRecord);
        boolean isDamaged = false;
        PropertyRecord damagedProperty = PropertyProvider.getPropertyRecord("DAMAGED");
        for (ItemInstancePropertyRecord propertyRecord : itemInstancePropertyRecords) {
            if (damagedProperty.equals(propertyRecord.getPropertyRecord())) {
                isDamaged = true;
                break;
            }
        }
        return isDamaged;
    }

    private class ReservationCheck {

        final boolean isItemAvailableForReservation;
        final String message;

        ReservationCheck(boolean itemAvailableForReservation, String message) {
            isItemAvailableForReservation = itemAvailableForReservation;
            this.message = message;
        }

        public boolean isItemAvailableForReservation() {
            return isItemAvailableForReservation;
        }

        public String getMessage() {
            return message;
        }
    }
}
