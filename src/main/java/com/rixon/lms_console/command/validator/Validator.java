package com.rixon.lms_console.command.validator;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.Operation;
import org.jetbrains.annotations.NotNull;

/**
 * This class is responsible for validating the command object
 * User: rixon|Date: 8/2/12|Time: 1:37 AM
 */
public interface Validator<TYPE> {

    /**
     * This method will validate the operationTypes and return the result in the Validation message.
     * If the operationTypes is valid then the isValid flag will be yes and the message and hint can be ignored.
     * If the operationTypes is invalid then the message will contain the reason why the validation failed and hint
     * will provide users the hint to correct the operationTypes
     *
     * @param operation operationTypes for the command
     * @param parameter the parameters for the operationTypes
     * @return validationResult
     */
    @NotNull
    public ValidationResult validateCommand(Operation operation, Parameter<TYPE> parameter);
}
