package com.rixon.lms_console.commandvalidator;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.commandvalidator.parameterValidation.ParameterValidator;

/**
 * ${CLASS_NAME}
 * User: 229921|Date: 8/3/12|Time: 8:27 PM
 */
public class SimpleValidator implements Validator<String> {

    private final static String SUCCESS_KEY = "success";
    private final static String DEFAULT_KEY = "default";

    @Override
    public ValidationResult validateCommand(String operation,Parameter<String> parameter) {
        boolean isOperationValid = OperationsCatalog.isOperationValid(operation);
        boolean areParametersValid = ParameterValidator.validateParameter(parameter, operation);
        boolean isCommandValid = isOperationValid && areParametersValid;
        String validationMessage, validationHint;
        String messageKey, hintKey;
        if (isCommandValid) {
            messageKey = SUCCESS_KEY;
            hintKey = SUCCESS_KEY;
        } else {
            messageKey = DEFAULT_KEY;
            hintKey = DEFAULT_KEY;
        }
        validationMessage = ValidationMessageProvider.getMessageForKey(messageKey);
        validationHint = ValidationHintProvider.getHintForKey(hintKey);
        ValidationResult validationResult = new BasicValidationResult(isCommandValid,validationMessage,
                validationHint);
        return validationResult;
    }
}
