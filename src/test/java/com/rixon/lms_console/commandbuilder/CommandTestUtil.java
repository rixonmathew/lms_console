package com.rixon.lms_console.commandbuilder;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.commandvalidator.ValidationResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 10:32 AM
 * This class provides all the util functionality while creating, validating the command objects
 */
public class CommandTestUtil {

    public static Command<String> createCommand(String operationString,String parameters,CommandBuilder builder){
        String commandString = operationString+" "+parameters;
        Command<String> command = null;
        if(builder!=null){
            command = builder.buildCommand(commandString);
        }
        return command;
    }

    public static void assertValidationResult(ValidationResult validationResult, boolean expectedValidity) {
        assertNotNull(validationResult);
        assertEquals("Is valid flag is not match", expectedValidity, validationResult.isValid());
        assertNotNull(validationResult.validationMessage());
        assertNotNull(validationResult.hint());
    }

}
