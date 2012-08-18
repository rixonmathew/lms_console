/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * User: 229921|Date: 8/18/12|Time: 8:19 PM
 */
public class ExitValidationStrategy implements ParameterValidationStrategy {
    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid = true;
        if (parameter.getParameters()!=null && parameter.getParameters().size()>0) {
            isValid = false;
        }
        return isValid;
    }
}
