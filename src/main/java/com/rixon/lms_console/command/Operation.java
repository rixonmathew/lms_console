package com.rixon.lms_console.command;

/**
 * This enum represents the valid operations that are support by LMS
 * User: 229921
 * Date: 8/17/12
 * Time: 8:57 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Operation {
    HELP("help"),
    COMMON("common"),
    SEARCH("search"),
    ISSUE("issue"),
    TRANSFER("transfer"),
    RETURN("return");

    private String description;

    Operation(String description){
        this.description = description;
    }

    public static Operation operationFor(String description) {
        Operation operation=null;
        if (SEARCH.description.equalsIgnoreCase(description)) {
            operation = SEARCH;
        } else if (ISSUE.description.equalsIgnoreCase(description)) {
            operation = ISSUE;
        } else if (TRANSFER.description.equalsIgnoreCase(description)) {
            operation = TRANSFER;
        } else if (HELP.description.equalsIgnoreCase(description)) {
            operation = HELP;
        }
        return operation;
    }
}
