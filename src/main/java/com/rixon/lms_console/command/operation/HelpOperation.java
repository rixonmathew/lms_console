package com.rixon.lms_console.command.operation;

import static com.rixon.lms_console.command.operation.OperationTypes.HELP;

/**
 * This class represents the help operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class HelpOperation extends AbstractOperation {
    public HelpOperation() {
        super(HELP);
        usage = "Usage: help [operation]";
    }
}
