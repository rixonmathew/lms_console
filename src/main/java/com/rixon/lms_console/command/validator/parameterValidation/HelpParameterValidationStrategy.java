package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
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
