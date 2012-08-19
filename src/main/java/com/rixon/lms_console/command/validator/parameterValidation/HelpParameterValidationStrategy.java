package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * This class represents the strategy for validating the help command
 * User: 229921|Date: 8/17/12|Time: 10:01 AM
 */
public class HelpParameterValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid=false;
        if (parameter == null || parameter.getParameters().size()==0){
            isValid = true;
            return isValid;
        }
        if (parameter!=null && parameter.getParameters().size()!=1) {
            isValid = false;
        } else {
            isValid = true;
        }
        return isValid;
    }
}
