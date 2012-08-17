package com.rixon.lms_console.commandvalidator;

import com.rixon.lms_console.command.Operation;

import java.util.ArrayList;
import java.util.List;

import static com.rixon.lms_console.command.Operation.*;

/**
 * ${CLASS_NAME}
 * User: 229921|Date: 8/3/12|Time: 8:30 PM
 */
public class OperationsCatalog {

    private static List<Operation> validOperations;

    static {
        //TODO Move the commands to a resource file
        validOperations = new ArrayList<Operation>();
        validOperations.add(SEARCH);
        validOperations.add(ISSUE);
        validOperations.add(TRANSFER);
        validOperations.add(RETURN);
    }

    public static boolean isOperationValid(Operation operation){
        if (validOperations.contains(operation)) {
            return true;
        }
        return false;
    }
}
