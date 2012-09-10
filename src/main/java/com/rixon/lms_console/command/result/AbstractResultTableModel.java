/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import org.jetbrains.annotations.Nullable;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Map;

/**
 * This class is the abstract class for table model associated with results
 * User: rixon|Date: 8/18/12|Time: 8:04 AM
 */
abstract class AbstractResultTableModel extends AbstractTableModel {

    protected final List results;
    protected Map<Integer, String> headerNames;

    protected abstract void initHeader();

    protected AbstractResultTableModel(List results) {
        this.results = results;
        initHeader();
    }

    @Override
    public int getRowCount() {
        return results.size();
    }

    @Override
    public int getColumnCount() {
        return headerNames.size();
    }

    @Nullable
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object cellValue = null;
        if (rowIndex < 0 || rowIndex > results.size() ||
                columnIndex < 0 || columnIndex > headerNames.values().size())
            return cellValue;
        cellValue = getCellValueAt(rowIndex, columnIndex);
        return cellValue;
    }

    /**
     * This method will query the data source to return the cell value at a particular row
     * and column. No validations needs to be done in this method since it will be performed
     * in the calling method
     *
     * @param rowIndex    the index for the row
     * @param columnIndex the index for the column
     * @return cell value
     */
    protected abstract Object getCellValueAt(int rowIndex, int columnIndex);

    @Override
    public String getColumnName(int column) {
        return headerNames.get(column);
    }
}
