package com.rixon.lms_console.command.validator;

/**
 * This interface will hold the result of the validation process
 *
 * User: 229921|Date: 8/2/12|Time: 1:38 AM
 */
public interface ValidationResult {

    /**
     * This method will return whether the result is valid or not
     * @return  true if the result is valid else false
     */
    public boolean isValid();

    /**
     * This method will return the detailed message explaining why validation has failed.
     * In case of success it will return Success
     * @return validation message
     */
    public String validationMessage();

    /**
     * This method will return the hint to assist the user in rectifying the validation message.
     * @return
     */
    public String hint();

}
