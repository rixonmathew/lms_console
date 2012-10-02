package com.rixon.lms_console.command.validator;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for providing the validation messages depending on the error type
 * User: rixon|Date: 8/3/12|Time: 8:39 PM
 */
public class ValidationMessageProvider {
    public final static String SUCCESS_KEY = "success";
    public final static String DEFAULT_KEY = "default";
    public static final String INVALID_OPERATION_KEY = "invalid_operation";
    public static final String INVALID_PARAMETERS_KEY = "invalid_parameters";

    private static final Map<String, String> validationMessages;
    private final static String DEFAULT_MESSAGE = "This command cannot be executed. Type help for more details";
    //private final static String ERROR_MESSAGE = "There was an error in the command syntax. refer usage of the command via help \n";
    private final static String INVALID_OPERATION_MESSAGE = "The operation specified is not valid. Type help to get list of valid operations \n";
    private final static String INVALID_PARAMETERS_MESSAGE = "The parameters specified for operation is not valid. refer usage of the command via help \n";
    private final static String SUCCESS_MESSAGE = "The command has been executed successfully";

    static {
        validationMessages = new HashMap<String, String>();
        validationMessages.put(DEFAULT_KEY, DEFAULT_MESSAGE);
        validationMessages.put(SUCCESS_KEY, SUCCESS_MESSAGE);
        validationMessages.put(INVALID_OPERATION_KEY, INVALID_OPERATION_MESSAGE);
        validationMessages.put(INVALID_PARAMETERS_KEY, INVALID_PARAMETERS_MESSAGE);
    }

    public static String getMessageForKey(String key) {
        String message = DEFAULT_MESSAGE;
        if (validationMessages.containsKey(key)) {
            message = validationMessages.get(key);
        }
        return message;
    }
}
