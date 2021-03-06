package com.rixon.lms_console.command.operation;

/**
 * This interface represents an operation part of the command.
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */

public interface Operation {

    /**
     * This method will return the type of the operation.
     *
     * @return the operation type
     */
    public String getOperationType();

    /**
     * This method will provide the usage of the operation. This usage will be provided
     * to the user when the format of the command is invalid
     *
     * @return the usage of the operation
     */
    public String getUsage();
}
