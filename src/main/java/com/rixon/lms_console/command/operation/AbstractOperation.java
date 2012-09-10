package com.rixon.lms_console.command.operation;

/**
 * This class represents the Abstract operation and is an implementation
 * of Operation interface @see Operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public abstract class AbstractOperation implements Operation {

    private final String operationType;
    protected String usage;


    AbstractOperation(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String getOperationType() {
        return operationType;
    }

    @Override
    public String getUsage() {
        return usage;
    }
}
