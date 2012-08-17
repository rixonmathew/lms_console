package com.rixon.lms_console.command.builder;

import com.rixon.lms_console.command.Command;

/**
 * This interface is responsible for parsing the input string into a command object
 * User: 229921| Date: 8/1/12|Time: 8:08 PM
 */
public interface Parser {

    /**
     * This method will parse the command string into the command object
     * @return command object
     */
    public Command parse(String commandString);
}
