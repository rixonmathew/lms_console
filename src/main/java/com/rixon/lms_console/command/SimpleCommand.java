package com.rixon.lms_console.command;

import com.rixon.lms_console.commandvalidator.ValidationResult;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/1/12
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleCommand implements Command<String> {

    private String operation;
    private Parameter<String> parameter;
    private boolean  isValid;
    private ValidationResult validationResult;

    public SimpleCommand(String operation, Parameter<String> parameter, boolean valid, ValidationResult validationResult) {
        this.operation = operation;
        this.parameter = parameter;
        isValid = valid;
        this.validationResult = validationResult;
    }

    @Override
    public String getOperation() {
        return operation;
    }

    @Override
    public Parameter<String> getParameter() {
        return parameter;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }

    @Override
    public ValidationResult getValidationResult() {
        return this.validationResult;
    }
}
