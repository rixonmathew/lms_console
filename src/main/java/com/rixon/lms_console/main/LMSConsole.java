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
 * This class is represents the console for the LMS system
 * User: 229921|Date: 8/19/12|Time: 12:16 AM
 */
public class LMSConsole {

    private final String EXIT_COMMAND = "exit";
    private final Console console = System.console();

    private CommandBuilder builder;
    private CommandExecutor executor;

    public LMSConsole(){
        initializeEnvironment();
    }

    private  void initializeEnvironment(){
        builder = new CommandBuilder();
        executor = new SimpleCommandExecutor();
    }

    public void start() {
        String userCommandString="";
        System.setProperty(ServiceFacadeFactory.LMS_MODE,ServiceFacadeFactory.FAKE);
        if (console!=null){
            printBanner();
            initializeEnvironment();
            do{
                userCommandString = console.readLine("LMS>");
                Command command = builder.buildCommand(userCommandString);
                Result result =  executor.executeCommand(command);
                if (command.isValid()) {
                    displayResultInConsole(result);
                }  else {
                    displayErrorInConsole(command);
                }
            }
            while (!userCommandString.equalsIgnoreCase(EXIT_COMMAND));
        }
    }


    private void displayErrorInConsole(Command command) {
        console.printf("Invalid command %1$s %n",command.getOriginalCommandString());
        console.printf("%1$s %2$s%n",command.getValidationResult().validationMessage(),command.getValidationResult().hint());
    }


    private  void displayResultInConsole(Result result){
        TableModel tableModel = result.getResultsTable();
        int columns = tableModel.getColumnCount();
        int rows = tableModel.getRowCount();
        for (int column=0;column<columns;column++){
            console.printf("%1$12s  ",tableModel.getColumnName(column));
        }
        console.printf("%n");
        drawLine(120);
        for (int row=0;row<rows;row++){
            for (int column=0;column<columns;column++){
                console.printf("%1$12s  ",tableModel.getValueAt(row,column));
            }
            console.printf("%n");
        }
        drawLine(120);
    }

    private  void printBanner() {
        console.printf("****** Welcome to LMS ******.%n");
        drawLine(50);
        console.printf("(Type help to get help, exit|quit to quit the application)%n");
    }

    private void drawLine(int length) {
        final String LINE_CHAR = "_";
        for (int i=0;i<length;i++) {
            console.printf(LINE_CHAR);
        }
        console.printf("%n");
    }
}
