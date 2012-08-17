package com.rixon.lms_console.command.operation;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReturnOperation extends AbstractOperation {

    public ReturnOperation(String operationType) {
        super(operationType);
        usage = "Usage: return <book> <user>";
    }
}
