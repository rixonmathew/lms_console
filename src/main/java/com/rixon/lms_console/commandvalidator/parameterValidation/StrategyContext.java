package com.rixon.lms_console.commandvalidator.parameterValidation;

import com.rixon.lms_console.command.Operation;
import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.Operation.*;


/**
 * This class represents the context in the Strategy design pattern. This class will
 * provide the required strategy based on the operation
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 12:16 PM
 */
public class StrategyContext {
    private static Map<Operation,ParameterValidationStrategy> validationStrategyMap;

    static {
        loadValidationStrategyMap();
    }

    private static void loadValidationStrategyMap() {
        validationStrategyMap = new HashMap<Operation, ParameterValidationStrategy>();
        validationStrategyMap.put(SEARCH,new SearchParametersValidationStrategy());
        validationStrategyMap.put(ISSUE,new IssueParameterValidationStrategy());
        validationStrategyMap.put(TRANSFER,new TransferParameterValidationStrategy());
        validationStrategyMap.put(COMMON,new CommonValidationStrategy());
    }

    public static ParameterValidationStrategy strategyForOperation(Operation operation){
        ParameterValidationStrategy validationStrategy = validationStrategyMap.get(operation);
        if(validationStrategy==null){
            validationStrategy = validationStrategyMap.get(COMMON);
        }
        return validationStrategy;
    }
}
