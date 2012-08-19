package com.rixon.lms_console.command.operation;

/**
 * This class represents the base operation
 * User: 229921|Date: 8/17/12|Time: 10:01 AM
 */
public class CommonOperation extends AbstractOperation {
    public CommonOperation(String operationType) {
        super(operationType);
        usage = "Usage: <operation> <parameters>";
    }
}
