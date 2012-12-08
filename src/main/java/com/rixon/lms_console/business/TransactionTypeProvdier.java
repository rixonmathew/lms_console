/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.dao.recordset.TransactionTypeRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: rixonmathew
 * Date: 09/12/12
 * Time: 12:47 AM
 */
public class TransactionTypeProvdier {

    private static Map<String, TransactionTypeRecord> transactionTypeRecordMap;

    static {
        loadMap();
    }

    private static void loadMap() {
        transactionTypeRecordMap = new HashMap<String, TransactionTypeRecord>();
        List<TransactionTypeRecord> allTransactionTypes = SimpleStore.getInstance().allTransactionTypes();
        for (TransactionTypeRecord transactionTypeRecord : allTransactionTypes) {
            transactionTypeRecordMap.put(transactionTypeRecord.getType(), transactionTypeRecord);
        }
    }

    public static TransactionTypeRecord getTransactionTypeRecord(String transactionType) {
        TransactionTypeRecord transactionTypeRecord = transactionTypeRecordMap.get(transactionType);
        return transactionTypeRecord;
    }
}
