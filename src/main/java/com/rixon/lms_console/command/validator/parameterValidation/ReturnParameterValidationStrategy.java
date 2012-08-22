package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * This class represents the strategy for validating the return command
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class ReturnParameterValidationStrategy extends CommonValidationStrategy {

    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid =  super.validateParameter(parameter);
        if (isValid) {
            int length = parameter.getParameters().size();
            if (length!=2){
                isValid = false;
            }
        }
        return isValid;
    }
}
