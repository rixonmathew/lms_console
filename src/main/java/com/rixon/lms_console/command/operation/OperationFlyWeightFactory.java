package com.rixon.lms_console.command.operation;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.operation.OperationTypes.*;

/**
 * This class represents the flyweight factory used to get the shared instances of
 * operation object
 * User: 229921
 * Date: 8/17/12
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class OperationFlyWeightFactory {

    private static Map<String,Operation> operationMap;

    static {
        loadOperationMap();
    }

    private static void loadOperationMap() {
      operationMap = new HashMap<String,Operation>();
      operationMap.put(SEARCH,new SearchOperation(SEARCH));
      operationMap.put(HELP,new HelpOperation(HELP));
      operationMap.put(COMMON,new CommonOperation(COMMON));
      operationMap.put(ISSUE,new IssueOperation(ISSUE));
      operationMap.put(RETURN,new ReturnOperation(RETURN));
      operationMap.put(TRANSFER,new TransferOperation(TRANSFER));
    }

    public static Operation operationForType(String operationType){
       Operation operation = operationMap.get(operationType);
       if (operation==null){
           operation = operationMap.get(COMMON);
       }
       return operation;
    }
}
