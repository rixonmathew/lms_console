package com.rixon.lms_console.command.result;

import javax.swing.table.TableModel;

/**
 * This interface represents the results of executing a command
 * User: 229921
 * Date: 8/17/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Result {

    /**
     * This method returns the data as a table model that can be rendered on a console or
     * within a table
     * @return tableModel representing the table
     */
    public TableModel getResultsTable();
}
