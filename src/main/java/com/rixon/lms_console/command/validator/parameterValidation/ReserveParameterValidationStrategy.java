/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents the validation strategy for the parameters associated
 * with reserve command
 * User: rixon|Date: 8/23/12|Time: 8:38 PM
 */
public class ReserveParameterValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(@NotNull Parameter<String> parameter) {
        boolean isValid = super.validateParameter(parameter);
        if (isValid) {
            int length = parameter.getParameters().size();
            if (length != 2) {
                isValid = false;
            }
        }
        return isValid;
    }
}
