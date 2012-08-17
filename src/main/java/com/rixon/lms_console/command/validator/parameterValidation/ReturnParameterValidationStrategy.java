package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * This class represents the validator strategy for return operation
 * User: 229921
 * Date: 8/17/12
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
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
