package com.rixon.lms_console.command.operation;

/**
 * This class represents the issue operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class IssueOperation extends AbstractOperation {
    public IssueOperation(String operationType) {
        super(operationType);
        usage = "Usage:issue <book> <user>";
    }
}