package com.rixon.lms_console.command.operation;

/**
 * This class represents the return operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class ReturnOperation extends AbstractOperation {

    public ReturnOperation(String operationType) {
        super(operationType);
        usage = "Usage: return <book> <user>";
    }
}
