package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents the strategy for validating the search command
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class SearchParametersValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(@NotNull Parameter<String> parameter) {
        return super.validateParameter(parameter);
        //TODO check if any Search specific logic needs to be added;
    }
}
