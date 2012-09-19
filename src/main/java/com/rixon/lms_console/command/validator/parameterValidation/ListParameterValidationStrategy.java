/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import org.jetbrains.annotations.Nullable;

/**
 * This class represents the validation strategy for list operation parameters
 * User: rixon|Date: 9/19/12|Time: 4:45 PM
 */
public class ListParameterValidationStrategy extends CommonValidationStrategy {
    @Override
    public boolean validateParameter(@Nullable Parameter<String> parameter) {
        boolean isValid;
        if (parameter == null || parameter.getParameters().size() == 0) {
            isValid = true;
            return isValid;
        }
        isValid = !(parameter.getParameters().size() != 1);
        return isValid;
    }

}
