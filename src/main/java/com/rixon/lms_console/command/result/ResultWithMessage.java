/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import org.jetbrains.annotations.NotNull;

import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the result of command where only a message is to
 * be displayed instead of a table
 * User: rixon|Date: 8/18/12|Time: 8:43 PM
 */
public class ResultWithMessage extends AbstractResult {

    public ResultWithMessage(List results) {
        super(results);
    }

    @NotNull
    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new SimpleResultTableModel(searchItems);
    }

    class SimpleResultTableModel extends AbstractResultTableModel {

        protected SimpleResultTableModel(List results) {
            super(results);
        }

        @Override
        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "");
        }

        @Override
        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            return results.get(0);
        }
    }
}
