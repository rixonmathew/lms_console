package com.rixon.lms_console.command.builder;

import com.rixon.lms_console.command.Command;

/**
 * This class represents the builder of the command from the given input string
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class CommandBuilder {

    public Command buildCommand(String commandString) {
        Parser stringParser = new SimpleParser();
        Command command = stringParser.parse(commandString);
        return command;
    }
}
