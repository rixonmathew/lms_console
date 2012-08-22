/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;

/**
 * This class provides the validation messages in the result format
 * User: rixon|Date: 8/17/12|Time: 11:53 PM
 */
public class ValidationMessageResult extends AbstractResult {

    public ValidationMessageResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new ValidationResultTableModel(searchItems);
    }

    class ValidationResultTableModel extends AbstractResultTableModel {

        protected ValidationResultTableModel(List results) {
            super(results);
        }

        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "message");
        }

        @Override
        public Object getCellValueAt(int rowIndex, int columnIndex) {
            String message = ((List<String>)results).get(rowIndex);
            return message;
        }
    }
}