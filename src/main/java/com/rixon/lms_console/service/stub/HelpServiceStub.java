/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.operation.OperationFlyWeightFactory;
import com.rixon.lms_console.command.operation.OperationTypes;
import com.rixon.lms_console.command.result.HelpResult;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the stub service for help operation
 * User: rixon|Date: 8/17/12|Time: 9:26 PM
 */
public class HelpServiceStub implements Service {
    @Override
    public Result executeService(Parameter<String> parameter) {
        List<String> commands = new ArrayList<String>();
        List<String> helpParameter = (List<String>)parameter.getParameters();

        if (helpParameter==null||helpParameter.size()==0){
            commands.add(OperationTypes.SEARCH);
            commands.add(OperationTypes.ISSUE);
            commands.add(OperationTypes.TRANSFER);
            commands.add(OperationTypes.RETURN);
        }  else {
            for (String string:helpParameter) {
                Operation operation = OperationFlyWeightFactory.operationForType(string);
                if (operation!=null) {
                    commands.add(operation.getUsage());
                }
            }
        }
        return new HelpResult(commands);
    }
}
