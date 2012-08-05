package com.rixon.lms_console.commandvalidator;

import java.util.HashMap;
import java.util.Map;

/**
 * ${CLASS_NAME}
 * User: 229921|Date: 8/3/12|Time: 9:01 PM
 */
public class ValidationHintProvider {
    private static Map<String, String> validationHints;
    private final static String DEFAULT_HINT = "Type help for more details";
    static {
        validationHints = new HashMap<String,String>();
        validationHints.put("default", "default message");
        validationHints.put("success", "success");
    }

    public static String getHintForKey(String key) {
        String message = DEFAULT_HINT;
        if (validationHints.containsKey(key)) {
            message = validationHints.get(key);
        }
        return message;
    }
}