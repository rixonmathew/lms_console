package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * This interface represents the strategy to validate the parameters of a command. The context to
 * determine the strategy will be the operation. Different operations will have different
 * strategies to validate their parameter syntax.
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 12:11 PM
 */
public interface ParameterValidationStrategy {

    /**
     * This method represents the interface that validates the parameters.
     * @param parameter
     * @return true if valid
     */
    public boolean validateParameter(Parameter<String> parameter);
}
