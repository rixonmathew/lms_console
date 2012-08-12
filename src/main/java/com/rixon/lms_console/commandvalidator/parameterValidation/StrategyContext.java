package com.rixon.lms_console.commandvalidator.parameterValidation;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the context in the Strategy design pattern. This class will
 * provide the required strategy based on the operation
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 12:16 PM
 */
public class StrategyContext {

    private final static String COMMON = "common";
    private final static String SEARCH = "search";

    private static Map<String,ParameterValidationStrategy> validationStrategyMap;

    static {
        loadValidationStrategyMap();
    }

    private static void loadValidationStrategyMap() {
        validationStrategyMap = new HashMap<String, ParameterValidationStrategy>();
        validationStrategyMap.put(SEARCH,new SearchParametersValidationStrategy());
        validationStrategyMap.put(COMMON,new CommonValidationStrategy());

    }

    public static ParameterValidationStrategy strategyForOperation(String operation){
        ParameterValidationStrategy validationStrategy = validationStrategyMap.get(operation);
        if(validationStrategy==null){
            validationStrategy = validationStrategyMap.get(COMMON);
        }
        return validationStrategy;
    }
}
