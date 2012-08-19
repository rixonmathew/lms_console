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
 * This class is used to represent the results associated with Help command
 * User: 229921|Date: 8/17/12|Time: 9:28 PM
 */
public class HelpResult extends AbstractResult {
    public HelpResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new HelpResultsTableModel(searchItems);
    }

    class HelpResultsTableModel extends AbstractResultTableModel {

        protected HelpResultsTableModel(List results) {
            super(results);
        }

        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "");
        }

        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            String operation = null;
            operation = ((List<String>)results).get(rowIndex);
            return operation;
        }
    }
}
