package com.rixon.lms_console.commandvalidator;

import java.util.ArrayList;
import java.util.List;

/**
 * ${CLASS_NAME}
 * User: 229921|Date: 8/3/12|Time: 8:30 PM
 */
public class OperationsCatalog {

    private static List<String> validCommandStrings;

    static {
        validCommandStrings = new ArrayList<String>();
        validCommandStrings.add("search");
        validCommandStrings.add("issue");
        validCommandStrings.add("transfer");
        validCommandStrings.add("return");
        validCommandStrings.add("list");
    }

    public static boolean isOperationValid(String operation){
        if (validCommandStrings.contains(operation)) {
            return true;
        }
        return false;
    }
}
