package com.rixon.lms_console.commandvalidator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * Created with IntelliJ IDEA.
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchParametersValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(Parameter parameter) {
        return super.validateParameter(parameter);
        //TODO check if any Search specific logic needs to be added;
    }
}
