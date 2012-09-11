package com.rixon.lms_console.command.result;

import javax.swing.table.TableModel;
import java.util.List;

/**
 * This class represents the abstract result and is the implementation of the Result interface
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public abstract class AbstractResult implements Result {

    protected final TableModel tableModel;

    AbstractResult(List results) {
        this.tableModel = convertListToModel(results);
    }

    protected abstract TableModel convertListToModel(List searchItems);

    @Override
    public TableModel getResultsTable() {
        return tableModel;
    }

    @Override
    public String getFormatStringForHeader(int columnIndex) {
        return "%1$20s |";
    }

    @Override
    public String getFormatStringForRecord(int columnIndex) {
        return "%1$20s |";
    }
}
