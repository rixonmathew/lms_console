package com.rixon.lms_console.commandvalidator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 10:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class TransferParameterValidationStrategy  extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid = super.validateParameter(parameter);
        if (isValid) {
            int length = parameter.getParameters().size();
            if (length!=3) {
                isValid = false;
            }
        }
        return isValid;
    }
}
