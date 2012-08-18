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
 * User: 229921|Date: 8/17/12|Time: 11:24 PM
 */
public class IssueResult extends AbstractResult {

    public IssueResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new IssueResultTableModel(searchItems);
    }

    class IssueResultTableModel extends AbstractResultTableModel {

        protected IssueResultTableModel(List results) {
            super(results);
        }

        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "result");
        }


        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            String operation = ((List<String>)results).get(rowIndex);
            return operation;
        }
    }
}
