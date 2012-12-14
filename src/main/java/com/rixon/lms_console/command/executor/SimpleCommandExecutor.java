package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.ValidationMessageResult;
import com.rixon.lms_console.facade.ServiceFacade;
import com.rixon.lms_console.service.Service;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the implementation of the CommandExecutor interface
 *
 * @see CommandExecutor
 *      User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class SimpleCommandExecutor implements CommandExecutor {

    private ServiceFacade serviceFacade;

    public SimpleCommandExecutor(ServiceFacade serviceFacade) {
        this.serviceFacade = serviceFacade;
    }

    @Override
    public Result executeCommand(@NotNull Command command) {
        boolean isCommandValid = command.isValid();
        if (!isCommandValid) {
            return resultWithValidationMessage(command);
        }
        String operationName = command.getOperation().getOperationType();
        Service service = serviceFacade.serviceForOperation(operationName);
        return service.invoke(command.getParameter());
    }

    @NotNull
    private Result resultWithValidationMessage(@NotNull Command command) {
        List<String> messages = new ArrayList<String>();
        messages.add(command.getValidationResult().validationMessage());
        messages.add(command.getValidationResult().hint());
        return new ValidationMessageResult(messages);
    }
}
