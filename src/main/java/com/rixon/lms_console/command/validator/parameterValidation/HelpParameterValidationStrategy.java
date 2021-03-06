package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import org.jetbrains.annotations.Nullable;

/**
 * This class represents the strategy for validating the help command
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class HelpParameterValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(@Nullable Parameter<String> parameter) {
        boolean isValid;
        if (parameter == null || parameter.getParameters().size() == 0) {
            isValid = true;
            return isValid;
        }
        isValid = parameter.getParameters().size() == 1;
        return isValid;
    }
}
