package com.rixon.lms_console.commandvalidator;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for providing the validation messages depending on the error type
 * User: 229921|Date: 8/3/12|Time: 8:39 PM
 */
public class ValidationMessageProvider {
    private static Map<String, String> validationMessages;
    private final static String DEFAULT_MESSAGE = "This command cannot be executed. Type help for more details";
    static {
        validationMessages = new HashMap<String,String>();
        validationMessages.put("default","default message");
        validationMessages.put("success","success");
    }

    public static String getMessageForKey(String key) {
        String message = DEFAULT_MESSAGE;
        if (validationMessages.containsKey(key)) {
          message = validationMessages.get(key);
        }
        return message;
    }
}
