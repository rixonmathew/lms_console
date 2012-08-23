package com.rixon.lms_console.command.operation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.rixon.lms_console.command.operation.OperationTypes.*;

/**
 * This class represents the catalog of operations in the system.
 * User: rixon|Date: 8/3/12|Time: 8:30 PM
 */
public class OperationsCatalog {

    private static List<String> validOperationTypes;

    static {
        //TODO Move the commands to a resource file
        validOperationTypes = new ArrayList<String>();
        validOperationTypes.add(SEARCH);
        validOperationTypes.add(ISSUE);
        validOperationTypes.add(TRANSFER);
        validOperationTypes.add(RETURN);
        validOperationTypes.add(HELP);
        validOperationTypes.add(EXIT);
        validOperationTypes.add(RESERVE);
    }

    public static boolean isOperationValid(String operationType){
        return validOperationTypes.contains(operationType);
    }

    public static List<String> allValidOperations() {
        return validOperationTypes;
    }
}
