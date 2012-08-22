package com.rixon.lms_console.command.operation;

/**
 * This class represents the transfer operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class TransferOperation extends AbstractOperation {
    public TransferOperation(String operationType) {
        super(operationType);
        usage = "Usage: transfer <book> <fromUser> <toUser>";
    }
}