package com.rixon.lms_console.command.builder;

import com.rixon.lms_console.command.AbstractCommandTest;
import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.CommandTestUtil;
import com.rixon.lms_console.command.operation.Operation;
import com.rixon.lms_console.command.operation.OperationFlyWeightFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * This class is used for testing te command building functionality
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class CommandBuilderTest extends AbstractCommandTest {

    @Test
    public void testBasicCommandCreation() {
        final String searchOperation = "search";
        final String searchParameter = "1123331232";
        Command bookSearchCommand = CommandTestUtil.createCommand(searchOperation, searchParameter, builder);
        assertNotNull(bookSearchCommand);
        Operation operation = bookSearchCommand.getOperation();
        assertEquals("OperationTypes is not same", OperationFlyWeightFactory.operationForType(searchOperation),
                operation);
        List<String> parameters = (List<String>) bookSearchCommand.getParameter().getParameters();
        assertEquals("Parameter size is not same", 1, parameters.size());
        CommandTestUtil.assertValidationResult(bookSearchCommand.getValidationResult(), true);
    }


    @Test
    public void testCommandCreationWithMultipleParameters() {
        final String issueOperation = "issue";
        final String books = "b12312322";
        final String userId = "u1123u22";
        Command booksIssueCommand = CommandTestUtil.createCommand(issueOperation, userId + " " + books, builder);
        assertNotNull(booksIssueCommand);
        List<String> parameters = (List<String>) booksIssueCommand.getParameter().getParameters();
        assertEquals("Parameter size is not same", 2, parameters.size());
        CommandTestUtil.assertValidationResult(booksIssueCommand.getValidationResult(), true);
    }

    @Test
    public void testInvalidCommand() {
        final String invalidSearchCommand = "searchhh";
        final String books = "bb123 12312323 123123";
        Command invalidCommand = CommandTestUtil.createCommand(invalidSearchCommand, books, builder);
        assertNotNull(invalidCommand);
        assertFalse("isValid flag should be no", invalidCommand.isValid());
        assertEquals("Command string is not same", invalidSearchCommand + " " + books, invalidCommand.getOriginalCommandString());
        CommandTestUtil.assertValidationResult(invalidCommand.getValidationResult(), false);
    }

    @Test
    public void testValidationMessage() {
        final String invalidIssueCommand = "iisue";
        final String parameters = "123123,123123223,1112323";
        final String expectedValidationMessage = "The operation specified is not valid. Type help to get list of valid operations \n";
        Command bookIssueCommand = CommandTestUtil.createCommand(invalidIssueCommand, parameters, builder);
        assertNotNull(bookIssueCommand);
        CommandTestUtil.assertValidationResult(bookIssueCommand.getValidationResult(), false);
        String actualValidationMessage = bookIssueCommand.getValidationResult().validationMessage();
        assertEquals("Validation message is not as expected", expectedValidationMessage, actualValidationMessage);
    }
}
