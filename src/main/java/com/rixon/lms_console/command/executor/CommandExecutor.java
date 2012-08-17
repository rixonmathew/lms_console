package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.result.Result;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CommandExecutor {

    /**
     * This method is used to execute a command and return the result associated with the command
     * @param command
     * @return Result associated with the command
     */
    public Result executeCommand(Command command);
}
