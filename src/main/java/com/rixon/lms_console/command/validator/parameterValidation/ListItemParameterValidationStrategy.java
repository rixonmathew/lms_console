/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;

/**
 * User: rixon|Date: 10/2/12|Time: 12:11 PM
 */
public class ListItemParameterValidationStrategy extends CommonValidationStrategy {

    @Override
    public boolean validateParameter(Parameter<String> parameter) {
        boolean isValid =  super.validateParameter(parameter);
        if (isValid) {
            isValid = (parameter.getParameters().size()==1);
        }
        return isValid;
    }
}
