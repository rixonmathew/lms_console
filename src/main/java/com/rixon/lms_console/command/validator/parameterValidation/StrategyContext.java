package com.rixon.lms_console.command.validator.parameterValidation;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.operation.OperationTypes.*;


/**
 * This class represents the context in the Strategy design pattern. This class will
 * provide the required strategy based on the operation
 * User: rixon|Date: 12/08/12|Time: 12:16 PM
 */
public class StrategyContext {
    private static Map<String,ParameterValidationStrategy> validationStrategyMap;

    static {
        loadValidationStrategyMap();
    }

    private static void loadValidationStrategyMap() {
        validationStrategyMap = new HashMap<String, ParameterValidationStrategy>();
        validationStrategyMap.put(SEARCH,new SearchParametersValidationStrategy());
        validationStrategyMap.put(ISSUE,new IssueParameterValidationStrategy());
        validationStrategyMap.put(TRANSFER,new TransferParameterValidationStrategy());
        validationStrategyMap.put(RETURN,new ReturnParameterValidationStrategy());
        validationStrategyMap.put(HELP,new HelpParameterValidationStrategy());
        validationStrategyMap.put(COMMON,new CommonValidationStrategy());
        validationStrategyMap.put(EXIT,new ExitValidationStrategy());
        validationStrategyMap.put(RESERVE,new ReserveParameterValidationStrategy());
        validationStrategyMap.put(LIST,new ListParameterValidationStrategy());
    }

    public static ParameterValidationStrategy strategyForOperation(String operationType){
        return validationStrategyMap.get(operationType);
    }
}
