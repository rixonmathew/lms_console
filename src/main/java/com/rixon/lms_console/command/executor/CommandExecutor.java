package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.result.Result;

/**
 * This interface represents the executor of the command.
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public interface CommandExecutor {

    /**
     * This method is used to invoke a command and return the result associated with the command
     *
     * @param command the command object
     * @return Result associated with the command
     */
    public Result executeCommand(Command command);
}
