package com.rixon.lms_console.command.builder;

import com.rixon.lms_console.command.Command;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/1/12
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandBuilder {

    public Command buildCommand(String commandString) {
        Parser stringParser = new SimpleParser();
        Command command = stringParser.parse(commandString);
        return command;
    }
}