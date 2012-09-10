package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents the strategy for validating the issue command
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class IssueParameterValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(@NotNull Parameter<String> parameter) {
        boolean isValid = super.validateParameter(parameter);
        if (isValid) {
            int parameterLength = parameter.getParameters().size();
            if (parameterLength != 2) {
                isValid = false;
            }
        }
        return isValid;
    }
}
