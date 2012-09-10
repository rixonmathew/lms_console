package com.rixon.lms_console.command.validator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.Operation;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents the class for validating the parameters associated with a
 * given operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class ParameterValidator {

    public static boolean validateParameter(Parameter<String> parameter, @NotNull Operation operation) {
        ParameterValidationStrategy validationStrategy = StrategyContext.strategyForOperation(operation.getOperationType());
        return validationStrategy.validateParameter(parameter);
    }
}
