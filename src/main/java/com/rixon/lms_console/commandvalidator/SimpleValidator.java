package com.rixon.lms_console.commandvalidator;

import com.rixon.lms_console.command.Command;

/**
 * ${CLASS_NAME}
 * User: 229921|Date: 8/3/12|Time: 8:27 PM
 */
public class SimpleValidator implements Validator<String> {

    private final static String SUCCESS_KEY = "success";
    private final static String DEFAULT_KEY = "default";

    @Override
    public ValidationResult validateCommand(String operation) {
        boolean isOperationValid = OperationsCatalog.isOperationValid(operation);
        String validationMessage, validationHint;
        String messageKey, hintKey;
        if (isOperationValid) {
            messageKey = SUCCESS_KEY;
            hintKey = SUCCESS_KEY;
        } else {
            messageKey = DEFAULT_KEY;
            hintKey = DEFAULT_KEY;
        }
        validationMessage = ValidationMessageProvider.getMessageForKey(messageKey);
        validationHint = ValidationHintProvider.getHintForKey(hintKey);
        ValidationResult validationResult = new BasicValidationResult(isOperationValid,validationMessage,
                validationHint);
        return validationResult;
    }
}
