package com.rixon.lms_console.main;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.builder.CommandBuilder;
import com.rixon.lms_console.command.executor.CommandExecutor;
import com.rixon.lms_console.command.executor.SimpleCommandExecutor;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.facade.ServiceFacadeFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.TableModel;
import java.io.Console;

/**
 * This class is represents the console for the LMS system
 * User: rixon|Date: 8/19/12|Time: 12:16 AM
 */
public class LMSConsole {

    private final Console console = System.console();

    private CommandBuilder builder;
    private CommandExecutor executor;
    private long currentTime;
    private final int LINE_LENGTH = 50;

    public LMSConsole() {
        initializeEnvironment();
    }

    public void start() {
        if (console != null) {
            printBanner();
            initializeEnvironment();
            processUserInput();
        }
    }

    private void printBanner() {
        final String welcomeMessage = "****** Welcome to Library Management System ******.%n";
        console.printf(welcomeMessage);
        drawLine(LINE_LENGTH);
        final String helpMessage = "(Type help to get help, exit|quit to quit the application)%n";
        console.printf(helpMessage);
    }

    private void drawLine(int length) {
        final String LINE_CHAR = "_";
        for (int i = 0; i < length; i++) {
            console.printf(LINE_CHAR);
        }
        console.printf("%n");
    }

    private void initializeEnvironment() {
        builder = new CommandBuilder();
        executor = new SimpleCommandExecutor(ServiceFacadeFactory.serviceFacade());
    }


    private void processUserInput() {
        String userCommandString;
        String EXIT_COMMAND = "exit";
        do {
            String LMS_PROMPT = "LMS>";
            userCommandString = console.readLine(LMS_PROMPT);
            if ((userCommandString == null) || (userCommandString.length() == 0)) {
                userCommandString = "continue";
                continue;
            }
            Command command = builder.buildCommand(userCommandString);
            if (command.isValid()) {
                startTimer();
                Result result = executor.executeCommand(command);
                displayResultInConsole(result);
            } else {
                displayErrorInConsole(command);
            }
        }
        while (!userCommandString.equalsIgnoreCase(EXIT_COMMAND));
    }

    private void startTimer() {
        currentTime = System.nanoTime();
    }


    private void displayErrorInConsole(@NotNull Command command) {
        console.printf("Invalid command %1$s %n", command.getOriginalCommandString());
        console.printf("%1$s %2$s%n", command.getValidationResult().validationMessage(), command.getValidationResult().hint());
    }


    private void displayResultInConsole(@NotNull Result result) {
        TableModel tableModel = result.getResultsTable();
        int columns = tableModel.getColumnCount();
        int rows = tableModel.getRowCount();
        int LINE_LENGTH = 160;
        drawLine(LINE_LENGTH);
        for (int column = 0; column < columns; column++) {
            console.printf(result.getFormatStringForHeader(column), tableModel.getColumnName(column));
        }
        console.printf("%n");
        drawLine(LINE_LENGTH);
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                console.printf(result.getFormatStringForRecord(column), tableModel.getValueAt(row, column));
            }
            console.printf("%n");
        }
        drawLine(LINE_LENGTH);
        displayTimeTaken();
        drawLine(LINE_LENGTH);
    }

    private void displayTimeTaken() {
        float timeTaken = (System.nanoTime() - currentTime);
        timeTaken /= 10e9;
        console.printf("Time taken: %1$f seconds \n", timeTaken);
    }

}
