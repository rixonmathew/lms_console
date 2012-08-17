package com.rixon.lms_console.command.operation;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class IssueOperation extends AbstractOperation {
    public IssueOperation(String operationType) {
        super(operationType);
        usage = "Usage:issue <book> <user>";
    }
}