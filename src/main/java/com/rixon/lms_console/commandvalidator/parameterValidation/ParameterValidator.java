package com.rixon.lms_console.commandvalidator.parameterValidation;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.Operation;

/**
 * Created with IntelliJ IDEA.
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 10:52 AM
 * The function of this class is to validate the parameters required for a given operation.
 */
public class ParameterValidator {

    public static boolean validateParameter(Parameter<String> parameter, Operation operation) {
       ParameterValidationStrategy validationStrategy = StrategyContext.strategyForOperation(operation);
       return validationStrategy.validateParameter(parameter);
    }
}
