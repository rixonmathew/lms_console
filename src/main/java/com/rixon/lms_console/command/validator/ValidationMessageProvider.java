package com.rixon.lms_console.command.validator;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for providing the validation messages depending on the error type
 * User: rixon|Date: 8/3/12|Time: 8:39 PM
 */
public class ValidationMessageProvider {
    private static Map<String, String> validationMessages;
    private final static String DEFAULT_MESSAGE = "This command cannot be executed. Type help for more details";
    private final static String ERROR_MESSAGE = "There was an error in the command syntax. refer usage of the command via help \n";
    private final static String SUCCESS_MESSAGE = "The command has been executed successfully";

    static {
        validationMessages = new HashMap<String,String>();
        validationMessages.put("default", ERROR_MESSAGE);
        validationMessages.put("success", SUCCESS_MESSAGE);
    }

    public static String getMessageForKey(String key) {
        String message = DEFAULT_MESSAGE;
        if (validationMessages.containsKey(key)) {
          message = validationMessages.get(key);
        }
        return message;
    }
}
