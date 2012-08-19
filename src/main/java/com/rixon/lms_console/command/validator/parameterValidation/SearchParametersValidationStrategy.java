package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * This class represents the strategy for validating the search command
 * User: 229921|Date: 8/17/12|Time: 10:01 AM
 */
public class SearchParametersValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        return super.validateParameter(parameter);
        //TODO check if any Search specific logic needs to be added;
    }
}
