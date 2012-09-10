package com.rixon.lms_console.command;

import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.validator.ValidationResult;

/**
 * This class represents a simple implementation of Command interface
 * User: rixon|Date: 8/1/12|Time: 8:04 PM
 */
public class SimpleCommand implements Command {

    private final Operation operation;
    private final Parameter<String> parameter;
    private final ValidationResult validationResult;
    private final String originalCommandString;

    public SimpleCommand(String originalCommandString, Operation operation, Parameter<String> parameter, ValidationResult validationResult) {
        this.originalCommandString = originalCommandString;
        this.operation = operation;
        this.parameter = parameter;
        this.validationResult = validationResult;
    }

    @Override
    public Operation getOperation() {
        return operation;
    }

    @Override
    public Parameter<String> getParameter() {
        return parameter;
    }

    @Override
    public boolean isValid() {
        return this.validationResult.isValid();
    }

    @Override
    public ValidationResult getValidationResult() {
        return this.validationResult;
    }

    @Override
    public String getOriginalCommandString() {
        return originalCommandString;
    }
}
