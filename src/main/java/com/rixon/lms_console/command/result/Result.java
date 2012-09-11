package com.rixon.lms_console.command.result;

import javax.swing.table.TableModel;

/**
 * This interface represents the results of executing a command
 * User: rixon|Date: 8/17/12|Time: 5:00 PM
 */
public interface Result {

    /**
     * This method returns the data as a table model that can be rendered on a console or
     * within a table
     *
     * @return tableModel representing the table
     */
    public TableModel getResultsTable();


    /**
     * This method will return the format string for the header column
     *
     * @param columnIndex the index of the column for which the format string is required
     * @return the format string
     */
    public String getFormatStringForHeader(int columnIndex);


    /**
     * This method will return the format string for the result column
     *
     * @param columnIndex
     * @return the format string
     */
    public String getFormatStringForRecord(int columnIndex);
}
