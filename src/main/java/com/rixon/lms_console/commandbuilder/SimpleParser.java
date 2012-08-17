package com.rixon.lms_console.commandbuilder;

import com.rixon.lms_console.command.*;
import com.rixon.lms_console.commandvalidator.SimpleValidator;
import com.rixon.lms_console.commandvalidator.ValidationResult;
import com.rixon.lms_console.commandvalidator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @see Parser
 * User: 229921|Date: 8/1/12|Time: 8:13 PM
 */
public class SimpleParser implements Parser {

    private Operation operation;
    private Parameter<String> parameter;
    private String commandString;
    private ValidationResult validationResult;
    private Command command;
    private Validator commandValidator;

    @Override
    public Command parse(String commandString) {
        this.commandString = commandString;
        this.tokenizeCommandString();
        this.validateCommand();
        this.createCommand();
        return command;
    }

    private void tokenizeCommandString() {
        StringTokenizer tokenizer = new StringTokenizer(commandString, " ");
        List<String> parameterList = new ArrayList<String>();
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (i == 0) {
                operation = Operation.operationFor(token);
            } else {
                parameterList.add(token);
            }
            i++;
        }
        parameter = new SimpleParameter(parameterList);
    }

    private void validateCommand() {
        commandValidator = new SimpleValidator();
        this.validationResult = commandValidator.validateCommand(this.operation,this.parameter);
    }

    private void createCommand(){
      this.command = new SimpleCommand(operation,parameter,validationResult);
    }
}