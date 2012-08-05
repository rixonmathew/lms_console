package com.rixon.lms_console.commandbuilder;

import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.commandvalidator.ValidationResult;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/1/12
 * Time: 7:52 PM
 * This class is responsible for testing the functionality of the CommandBuilder class
 */
public class CommandBuilderTest {

    private CommandBuilder builder;

    @Before
    public void setup() {
        builder = new CommandBuilder();
    }

    @After
    public void teardown() {
        builder = null;
    }

    @Test
    public void testBasicCommandCreation() {
        final String searchOperation = "search";
        final String searchParameter = "1123331232";
        String commandString = searchOperation + " " + searchParameter;
        Command bookSearchCommand = builder.buildCommand(commandString);
        assertNotNull(bookSearchCommand);
        String command = bookSearchCommand.getOperation();
        assertEquals("Operation is not same", "search", command);
        List<String> parameters = (List<String>) bookSearchCommand.getParameter().getParameters();
        assertEquals("Parameter size is not same", 1, parameters.size());
        assertValidationResult(bookSearchCommand.getValidationResult(), true);
    }


    @Test
    public void testCommandCreationWithMultipleParameters() {
        final String issueOperation = "issue";
        final String books = "bb123123123 b12312322 bqwe213123123";
        final String userId = "u1123u22";
        String commandString = issueOperation + " " + userId + " " + books;
        Command booksIssueCommand = builder.buildCommand(commandString);
        assertNotNull(booksIssueCommand);
        List<String> parameters = (List<String>) booksIssueCommand.getParameter().getParameters();
        assertEquals("Parameter size is not same", 4, parameters.size());
        assertValidationResult(booksIssueCommand.getValidationResult(), true);
    }

    @Test
    public void testInvalidCommand() {
        final String invalidSearchCommand = "searchhh";
        final String books = "bb123 12312323 123123";
        final String commandString = invalidSearchCommand + " " + books;
        Command invalidCommand = builder.buildCommand(commandString);
        assertFalse("isValid flag should be no", invalidCommand.isValid());
        assertValidationResult(invalidCommand.getValidationResult(), false);
    }

    @Test
    public void testValidationMessage() {
        final String invalidIssueCommand = "iisue";
        final String parameters = "123123,123123223,1112323";
        final String expectedValidationMessage = "default message";
        final String commandString = invalidIssueCommand + " " + parameters;
        Command<String> bookIssueCommand = builder.buildCommand(commandString);
        assertNotNull(bookIssueCommand);
        assertValidationResult(bookIssueCommand.getValidationResult(), false);
        String actualValidationMessage = bookIssueCommand.getValidationResult().validationMessage();
        assertEquals("Validation message is not as expected", expectedValidationMessage, actualValidationMessage);
    }

    private void assertValidationResult(ValidationResult validationResult, boolean expectedValidity) {
        assertNotNull(validationResult);
        assertEquals("Is valid flag is not match", expectedValidity, validationResult.isValid());
        assertNotNull(validationResult.validationMessage());
        assertNotNull(validationResult.hint());
    }

}
