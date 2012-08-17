package com.rixon.lms_console.command;

import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.validator.ValidationResult;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/1/12
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCommand implements Command {

    private Operation operation;
    private Parameter<String> parameter;
    private ValidationResult validationResult;

    public SimpleCommand(Operation operation, Parameter<String> parameter, ValidationResult validationResult) {
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
}
