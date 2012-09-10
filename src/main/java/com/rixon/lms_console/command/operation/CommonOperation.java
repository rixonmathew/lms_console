package com.rixon.lms_console.command.operation;

/**
 * This class represents the base operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
class CommonOperation extends AbstractOperation {
    public CommonOperation(String operationType) {
        super(operationType);
        usage = "Usage: <operation> <parameters>";
    }
}
