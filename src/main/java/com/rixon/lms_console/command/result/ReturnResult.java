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
 * User: 229921|Date: 8/18/12|Time: 7:49 AM
 */
public class ReturnResult extends AbstractResult {

    public ReturnResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new ReturnResultTableModel(searchItems);
    }

    class ReturnResultTableModel extends AbstractResultTableModel {

        protected ReturnResultTableModel(List results) {
            super(results);
        }

        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "message");
        }

        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            String message = ((List<String>)results).get(rowIndex);
            return message;
        }
    }
}
