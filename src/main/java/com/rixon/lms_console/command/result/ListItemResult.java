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
 * This class represents the results of the list-item command
 * User: rixon|Date: 10/2/12|Time: 1:45 PM
 */
public class ListItemResult extends AbstractResult {

    ListItemResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new ListItemResultTableModel(searchItems);
    }

    class ListItemResultTableModel extends AbstractResultTableModel{

        protected ListItemResultTableModel(List results) {
            super(results);
        }

        @Override
        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0,"Property");
            headerNames.put(1,"Value");
        }

        @Override
        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            String propertyValue = null;
            return propertyValue;
        }
    }
}
