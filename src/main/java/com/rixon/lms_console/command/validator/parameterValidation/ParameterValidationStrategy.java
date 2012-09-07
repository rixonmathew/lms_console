package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * This class represents the interface for parameter validation strategy
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public interface ParameterValidationStrategy {

    /**
     * This method represents the interface that validates the parameters.
     *
     * @param parameter the parameter that has to be validated
     * @return true if valid else false
     */
    public boolean validateParameter(Parameter<String> parameter);
}
