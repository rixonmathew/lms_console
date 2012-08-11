package com.rixon.lms_console.main;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.commandbuilder.CommandBuilder;

import java.io.Console;

/**
 * Created with IntelliJ IDEA.
 * User: rixonmathew
 * Date: 04/08/12
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class LMSConsole {

    public static final String EXIT_COMMAND = "exit";
    public static final String EXIT_MESSAGE = "Have a good day %n";

    private static Command<String> createCommand(String commandString){
      CommandBuilder builder = new CommandBuilder();
      return builder.buildCommand(commandString);
    }

    private static void executeCommand(Command<String> command){

    }
    public static void main(String[] args) {
        //TODO Create a console that displays the system and gets the command from the users
        //TODO Display the results of the command validation
        //TODO Display the results of the command
        Console console = System.console();
        String userCommandString="";
        if (console!=null){
            console.printf("****** Welcome to LMS ******.%n");
            console.printf("-----------------------------.%n");
            console.printf("(Type help to get help, exit|quit to quit the application)%n");
            do{
              userCommandString = console.readLine("LMS>");
              console.printf("Command typed is: %1$4s%n",userCommandString);
            }
            while (!userCommandString.equalsIgnoreCase(EXIT_COMMAND));
            console.printf(EXIT_MESSAGE);
        }

    }
}
