package com.rixon.lms_console.command.operation;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.operation.OperationTypes.*;

/**
 * This class represents the flyweight factory used to get the shared instances of
 * operation object
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class OperationFlyWeightFactory {

    private static Map<String, Operation> operationMap;

    static {
        loadOperationMap();
    }

    private static void loadOperationMap() {
        operationMap = new HashMap<String, Operation>();
        operationMap.put(SEARCH, new SearchOperation());
        operationMap.put(HELP, new HelpOperation());
        operationMap.put(ISSUE, new IssueOperation());
        operationMap.put(RETURN, new ReturnOperation());
        operationMap.put(TRANSFER, new TransferOperation());
        operationMap.put(EXIT, new ExitOperation());
        operationMap.put(RESERVE, new ReserveOperation());
        operationMap.put(LIST_USER, new ListUserOperation());
        operationMap.put(LIST_ITEM, new ListItemOperation());
    }

    public static Operation operationForType(String operationType) {
        Operation operation = operationMap.get(operationType);
        if (operation == null) {
            operation = operationMap.get(COMMON);
        }
        return operation;
    }
}
