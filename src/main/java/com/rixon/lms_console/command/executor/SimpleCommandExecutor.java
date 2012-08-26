package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.ValidationMessageResult;
import com.rixon.lms_console.facade.ServiceFacade;
import com.rixon.lms_console.facade.ServiceFacadeFactory;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the implementation of the CommandExecutor interface
 * @see CommandExecutor
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class SimpleCommandExecutor implements CommandExecutor {
    @Override
    public Result executeCommand(Command command) {
        boolean isCommandValid = command.isValid();
        if(!isCommandValid) {
            return resultWithValidationMessage(command);
        }
        String operationName = command.getOperation().getOperationType();
        ServiceFacade serviceFacade = ServiceFacadeFactory.serviceFacade();
        Service service = serviceFacade.serviceForOperation(operationName);
        return service.execute(command.getParameter());
    }

    private Result resultWithValidationMessage(Command command) {
        List<String> messages = new ArrayList<String>();
        messages.add(command.getValidationResult().validationMessage());
        messages.add(command.getValidationResult().hint());
        return new ValidationMessageResult(messages);
    }
}
