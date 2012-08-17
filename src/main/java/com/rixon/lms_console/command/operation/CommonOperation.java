package com.rixon.lms_console.command.operation;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonOperation extends AbstractOperation {
    public CommonOperation(String operationType) {
        super(operationType);
        usage = "Usage: <operation> <parameters>";
    }
}
