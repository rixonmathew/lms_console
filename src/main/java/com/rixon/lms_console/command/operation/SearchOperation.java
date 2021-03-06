package com.rixon.lms_console.command.operation;

import static com.rixon.lms_console.command.operation.OperationTypes.SEARCH;

/**
 * This class represents the search operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class SearchOperation extends AbstractOperation {
    public SearchOperation() {
        super(SEARCH);
        usage = "Usage: search <book1> <book2> ..";
    }
}
