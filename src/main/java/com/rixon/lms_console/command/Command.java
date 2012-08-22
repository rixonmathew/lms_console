package com.rixon.lms_console.command;

import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.validator.ValidationResult;

/**
 * This interface represents a command to be executed. The command consists of two parts
 * operation and parameters required to perform the operation.
 * User: rixon|Date: 8/1/12|Time: 7:58 PM
 */
public interface Command {

    /**
     * This method will return the operation that the command will perform
     * @return
     */
    public Operation getOperation();

    /**
     * This method will return the parameter associated with the Command object
     * @return parameter object
     */
    public Parameter<String> getParameter();


    /**
     * This method return true if the command is valid
     * @return
     */
    boolean isValid();

    /**
     * This method will return the detailed object that contains the result of the command validation
     *
     * @return
     */
    public ValidationResult getValidationResult();

    /**
     * This method will return the original command string that was used to parse the command object
     * @return original command string
     */
    public String getOriginalCommandString();
}
