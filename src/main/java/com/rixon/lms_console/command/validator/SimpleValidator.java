package com.rixon.lms_console.command.validator;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.operation.OperationsCatalog;
import com.rixon.lms_console.command.validator.parameterValidation.ParameterValidator;
import org.jetbrains.annotations.NotNull;

/**
 * ${CLASS_NAME}
 * User: rixon|Date: 8/3/12|Time: 8:27 PM
 */
public class SimpleValidator implements Validator<String> {

    private final static String SUCCESS_KEY = "success";
    private final static String DEFAULT_KEY = "default";

    @NotNull
    @Override
    public ValidationResult validateCommand(@NotNull Operation operation, Parameter<String> parameter) {
        boolean isOperationValid = OperationsCatalog.isOperationValid(operation.getOperationType());
        boolean areParametersValid = ParameterValidator.validateParameter(parameter, operation);
        boolean isCommandValid = isOperationValid && areParametersValid;
        String validationMessage, validationHint;
        String messageKey;
        if (isCommandValid) {
            messageKey = SUCCESS_KEY;
        } else {
            messageKey = DEFAULT_KEY;
        }
        validationMessage = ValidationMessageProvider.getMessageForKey(messageKey);
        validationHint = operation.getUsage();//ValidationHintProvider.getHintForKey(hintKey);
        return new BasicValidationResult(isCommandValid, validationMessage,
                validationHint);
    }
}
