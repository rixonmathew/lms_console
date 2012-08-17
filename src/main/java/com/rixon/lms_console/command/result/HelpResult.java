/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import com.rixon.lms_console.domain.Book;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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

    class HelpResultsTableModel extends AbstractTableModel {

        List<String> commands;
        private Map<Integer, String> headerNames;

        HelpResultsTableModel(List<String> commands) {
            this.commands = commands;
            initHeader();
        }

        private void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "command");
        }

        @Override
        public int getRowCount() {
            return commands.size();
        }

        @Override
        public int getColumnCount() {
            return headerNames.values().size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String operation = null;
            if (rowIndex < 0 || rowIndex > commands.size() ||
                    columnIndex < 0 || columnIndex > headerNames.values().size())
                return operation;
            operation = commands.get(rowIndex);
            return operation;

        }
    }
}
