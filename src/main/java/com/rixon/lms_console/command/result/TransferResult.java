/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 229921|Date: 8/17/12|Time: 11:40 PM
 */
public class TransferResult extends AbstractResult {

    public TransferResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new TransferResultTableModel(searchItems);
    }

    class TransferResultTableModel extends AbstractTableModel {

        List<String> transferResult;
        private Map<Integer, String> headerNames;

        TransferResultTableModel(List<String> transferResult) {
            this.transferResult = transferResult;
            initHeader();
        }

        private void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "result");
        }

        @Override
        public int getRowCount() {
            return transferResult.size();
        }

        @Override
        public int getColumnCount() {
            return headerNames.values().size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String result = null;
            if (rowIndex < 0 || rowIndex > transferResult.size() ||
                    columnIndex < 0 || columnIndex > headerNames.values().size())
                return result;
            result = transferResult.get(rowIndex);
            return result;
        }
    }
}
