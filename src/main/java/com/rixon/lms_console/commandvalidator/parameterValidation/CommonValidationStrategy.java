package com.rixon.lms_console.commandvalidator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

import java.util.Collection;

/**
 * This class represents the common validation logic that needs to be implemented for all
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommonValidationStrategy implements ParameterValidationStrategy{

    @Override
    public boolean validateParameter(Parameter parameter) {
        boolean isValid = true;
        Collection parameterValues = parameter.getParameters();
        if (parameterValues==null || parameterValues.isEmpty()){
            isValid = false;
        }
        return isValid;
    }
}
