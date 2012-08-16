package com.rixon.lms_console.commandvalidator;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.Parameter;

/**
 * This class is responsible for validating the command object
 * User: 229921|Date: 8/2/12|Time: 1:37 AM
 */
public interface Validator<TYPE> {

    /**
     * This method will validate the operation and return the result in the Validation message.
     * If the operation is valid then the isValid flag will be yes and the message and hint can be ignored.
     * If the operation is invalid then the message will contain the reason why the validation failed and hint
     * will provide users the hint to correct the operation
     * @param operation operation for the command
     * @param parameter the parameters for the operation
     * @return validationResult
     */
    public ValidationResult validateCommand(String operation,Parameter<TYPE> parameter);
}
