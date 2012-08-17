package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.facade.ServiceFacade;
import com.rixon.lms_console.facade.ServiceFacadeFactory;
import com.rixon.lms_console.facade.ServiceFacadeReal;
import com.rixon.lms_console.service.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCommandExecutor implements CommandExecutor {
    @Override
    public Result executeCommand(Command command) {
        String operationName = command.getOperation().getOperationType();
        ServiceFacade serviceFacade = ServiceFacadeFactory.serviceFacade();
        Service service = serviceFacade.serviceForOperation(operationName);
        Result result =  service.executeService(command.getParameter());
        return result;
    }
}
