/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used as the table model where data is to be displayed as property value format instead of showing all the attributes in the row.
 *
 * User: rixonmathew
 * Date: 06/10/12
 * Time: 8:42 PM
 */
public abstract class AbstractMapBasedTableModel extends AbstractTableModel {

    protected Map<Integer,String> results;
    protected Map<Integer,String> rowNames;
    protected Map<Integer,String> headerNames;


    protected AbstractMapBasedTableModel(List resultList){
      initHeader();
      initResultMap();
      transposeResultsToMap(resultList);
    }

    protected void initResultMap() {
      results = new HashMap<Integer, String>();
      rowNames = new HashMap<Integer, String>();
    }

    private void initHeader() {
        headerNames = new HashMap<Integer, String>();
        headerNames.put(0,"PROPERTY");
        headerNames.put(1,"VALUE");
    }

    /**
     * This method is responsible for converting the result into Map
     * @param resultList
     */
    protected abstract void transposeResultsToMap(List resultList);

    @Override
    public int getRowCount() {
        return results.keySet().size();
    }

    @Override
    public int getColumnCount() {
        return headerNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return headerNames.get(column);
    }

    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
}
