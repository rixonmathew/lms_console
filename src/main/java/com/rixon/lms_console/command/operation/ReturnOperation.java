package com.rixon.lms_console.command.operation;

import static com.rixon.lms_console.command.operation.OperationTypes.RETURN;

/**
 * This class represents the return operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class ReturnOperation extends AbstractOperation {

    public ReturnOperation() {
        super(RETURN);
        usage = "Usage: return <book> <user>";
    }
}
