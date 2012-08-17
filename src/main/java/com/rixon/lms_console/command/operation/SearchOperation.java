package com.rixon.lms_console.command.operation;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchOperation extends AbstractOperation {
    public SearchOperation(String operationType) {
        super(operationType);
        usage = "Usage: search <book1> <book2> ..";
    }
}
