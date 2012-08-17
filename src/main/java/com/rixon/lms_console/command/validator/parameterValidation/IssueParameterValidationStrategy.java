package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 7:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class IssueParameterValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid = super.validateParameter(parameter);
        if (isValid) {
            int parameterLength = parameter.getParameters().size();
            if (parameterLength!=2){
                isValid = false;
            }
        }
        return isValid;
    }
}
