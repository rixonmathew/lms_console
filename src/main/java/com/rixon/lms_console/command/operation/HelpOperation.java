package com.rixon.lms_console.command.operation;

/**
 * This class represents the help operation
 * User: 229921|Date: 8/17/12|Time: 10:01 AM
 */
public class HelpOperation extends AbstractOperation {
    public HelpOperation(String operationType) {
        super(operationType);
        usage = "Usage: help <operation>";
    }
}
