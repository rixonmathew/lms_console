package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

import java.util.Collection;

/**
 * This class represents the base strategy for validating the operations. If
 * no specific strategy is found for validating an operation
 * User: 229921|Date: 8/17/12|Time: 10:01 AM
 */
public class CommonValidationStrategy implements ParameterValidationStrategy{

    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid = true;
        Collection parameterValues = parameter.getParameters();
        if (parameterValues==null || parameterValues.isEmpty()){
            isValid = false;
        }
        return isValid;
    }
}
