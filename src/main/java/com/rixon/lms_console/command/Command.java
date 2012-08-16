package com.rixon.lms_console.command;

import com.rixon.lms_console.commandvalidator.ValidationResult;

/**
 * This interface represents a command to be executed. The command consists of two parts
 * operation and parameters required to perform the operation.
 *  User: 229921
 * Date: 8/1/12
 * Time: 7:58 PM
 *
 */
public interface Command<PARAMETER_TYPE> {

    /**
     * This method will return the operation that the command will perform
     * @return
     */
    public String getOperation();

    /**
     * This method will return the parameter associated with the Command object
     * @return parameter object
     */
    public Parameter<PARAMETER_TYPE> getParameter();


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
}