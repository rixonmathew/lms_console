package com.rixon.lms_console.command.result;

import javax.swing.table.TableModel;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractResult implements Result {

    protected TableModel tableModel;

    public AbstractResult(List results){
        this.tableModel = convertListToModel(results);
    }

    protected abstract TableModel convertListToModel(List searchItems);

    @Override
    public TableModel getResultsTable() {
        return tableModel;
    }

}
