package com.rixon.lms_console.main;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.builder.CommandBuilder;
import com.rixon.lms_console.command.executor.CommandExecutor;
import com.rixon.lms_console.command.executor.SimpleCommandExecutor;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.facade.ServiceFacadeFactory;

import javax.swing.table.TableModel;
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
    public static final Console console = System.console();

    public static CommandBuilder builder;
    public static CommandExecutor executor;

    public static void main(String[] args) {
        //TODO Display the results of the command validation
        //TODO Display the results of the command

        String userCommandString="";
        System.setProperty(ServiceFacadeFactory.LMS_MODE,ServiceFacadeFactory.FAKE);
        if (console!=null){
            printBanner();
            do{
              userCommandString = console.readLine("LMS>");
              //create the command object. if command is invalid display general help
              // if operations is valid and then parameters are invlaid print out the usage from je operatioms
              //if commad is valid process the command, format the result and display the same
              //console.printf("Command typed is: %1$4s%n",userCommandString);
              Command command = builder.buildCommand(userCommandString);
              Result result =  executor.executeCommand(command);
              displayResultInConsole(result);
            }
            while (!userCommandString.equalsIgnoreCase(EXIT_COMMAND));
            printExitMessage();
        }

    }

    private static void printExitMessage() {
        console.printf(EXIT_MESSAGE);
    }

    private static void initializeEnvironment(){
        builder = new CommandBuilder();
        executor = new SimpleCommandExecutor();
    }

    private static void displayResultInConsole(Result result){
        TableModel tableModel = result.getResultsTable();
        int columns = tableModel.getColumnCount();
        int rows = tableModel.getRowCount();
        for (int column=0;column<columns;column++){
            console.printf("%1$4s  ",tableModel.getColumnName(column));
        }
        console.printf("%n");
        console.printf("===================================================%n");
        for (int row=0;row<rows;row++){
            for (int column=0;column<columns;column++){
                console.printf("%1$4s  ",tableModel.getValueAt(row,column));
            }
            console.printf("%n");
        }
        console.printf("===================================================%n");
    }

    private static void printBanner() {
        console.printf("****** Welcome to LMS ******.%n");
        console.printf("-----------------------------.%n");
        console.printf("(Type help to get help, exit|quit to quit the application)%n");
    }
}
