package com.rixon.lms_console.command.validator;

/**
 * This class holds the result of the validation of a Command object
 * User: rixon|Date: 8/3/12|Time: 8:29 PM
 */
public class BasicValidationResult implements ValidationResult {

    private final boolean isValid;
    private final String validationMessage;
    private final String hint;

    public BasicValidationResult(boolean valid, String validationMessage, String hint) {
        isValid = valid;
        this.validationMessage = validationMessage;
        this.hint = hint;
    }

    @Override
    public boolean isValid() {
        return isValid;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String validationMessage() {
        return validationMessage;
    }

    @Override
    public String hint() {
        return hint;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
