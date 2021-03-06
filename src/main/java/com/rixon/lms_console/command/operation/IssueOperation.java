package com.rixon.lms_console.command.operation;

import static com.rixon.lms_console.command.operation.OperationTypes.ISSUE;

/**
 * This class represents the issue operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class IssueOperation extends AbstractOperation {
    public IssueOperation() {
        super(ISSUE);
        usage = "Usage:issue <book> <user>";
    }
}