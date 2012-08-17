package com.rixon.lms_console.command.operation;

/**
 * @see com.rixon.lms_console.command.operation.Operation
 * User: 229921
 * Date: 8/17/12
 * Time: 11:01 AM
 */
public abstract class AbstractOperation implements Operation {

    private String operationType;
    protected String usage;


    public AbstractOperation(String operationType)  {
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
