package com.rixon.lms_console.command.validator;

import java.util.ArrayList;
import java.util.List;

import static com.rixon.lms_console.command.operation.OperationTypes.*;

/**
 * ${CLASS_NAME}
 * User: 229921|Date: 8/3/12|Time: 8:30 PM
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
    }

    public static boolean isOperationValid(String operationType){
        if (validOperationTypes.contains(operationType)) {
            return true;
        }
        return false;
    }
}
