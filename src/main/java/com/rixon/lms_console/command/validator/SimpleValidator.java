package com.rixon.lms_console.command.validator;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.operation.OperationsCatalog;
import com.rixon.lms_console.command.validator.parameterValidation.ParameterValidator;
import org.jetbrains.annotations.NotNull;

import static com.rixon.lms_console.command.validator.ValidationMessageProvider.*;

/**
 * ${CLASS_NAME}
 * User: rixon|Date: 8/3/12|Time: 8:27 PM
 */
public class SimpleValidator implements Validator<String> {


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
            if (!isOperationValid) {
                messageKey = INVALID_OPERATION_KEY;
            } else if (!areParametersValid) {
                messageKey = INVALID_PARAMETERS_KEY;
            } else {
                messageKey = DEFAULT_KEY;
            }
        }
        validationMessage = ValidationMessageProvider.getMessageForKey(messageKey);
        validationHint = operation.getUsage();//ValidationHintProvider.getHintForKey(hintKey);
        return new BasicValidationResult(isCommandValid, validationMessage,
                validationHint);
    }
}
