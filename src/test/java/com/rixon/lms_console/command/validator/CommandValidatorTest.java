package com.rixon.lms_console.command.validator;

import com.rixon.lms_console.command.AbstractCommandTest;
import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.CommandTestUtil;
import com.rixon.lms_console.command.builder.CommandBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * This class is responsible for verifying the validator logic of the command
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 10:25 AM
 */
public class CommandValidatorTest extends AbstractCommandTest {

    @Test
    public void validateBasicInvalidSearchCommand() {
        final String operationString = "search";
        final String parameterString = "";
        final String expectedUsageString = "Usage: search <book1> <book2> ..";
        Command searchCommand = CommandTestUtil.createCommand(operationString, parameterString, builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),false);
        String actualUsageString = searchCommand.getOperation().getUsage();
        assertEquals("Usage string not equal",expectedUsageString,actualUsageString);
    }

    @Test
    public void validateBasicValidSearchCommand() {
        final String operationString = "search";
        final String parameterString = "12123123,112322,122312,1232";
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),true);
    }

    @Test
    public void validateBasicInvalidIssueCommand() {
        final String operationString = "issue";
        final String parameterString = "";
        final String expectedUsageString = "Usage:issue <book> <user>";
        Command issueCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(issueCommand.getValidationResult(),false);
        String actualUsageString = issueCommand.getOperation().getUsage();
        assertEquals("Usage string not equal", expectedUsageString, actualUsageString);
    }

    @Test
    public void validateBasicInvalidIssueCommandWithMoreParameters() {
        final String operationString = "issue";
        final String parameterString = "112321321 1123232 112321312";
        Command issueCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(issueCommand.getValidationResult(),false);
    }

    @Test
    public void validateBasicValidIssueCommandWithCorrectParameters() {
        final String operationString = "issue";
        final String parameterString = "112321321 1123232";
        Command issueCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(issueCommand.getValidationResult(),true);
    }

    @Test
    public void validateBasicInvalidTransferCommand() {
        final String operationString = "transfer";
        final String parameterString = "";
        final String expectedUsageString = "Usage: transfer <book> <fromUser> <toUser>";
        Command transferCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(transferCommand.getValidationResult(),false);
        String actualUsageString = transferCommand.getOperation().getUsage();
        assertEquals("Usage string not equal", expectedUsageString, actualUsageString);
    }

    @Test
    public void validateBasicValidTransferCommand() {
        final String operationString = "transfer";
        final String parameterString = "1123123123 123123 111230";
        Command transferCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(transferCommand.getValidationResult(),true);
    }

    @Test
    public void validateInValidTransferCommandWithMoreParameters() {
        final String operationString = "transfer";
        final String parameterString = "1123123123 123123 111230 123123 123213";
        Command transferCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(transferCommand.getValidationResult(),false);
    }


    @Test
    public void validateBasicInvalidReturnCommand() {
        final String operationString = "return";
        final String parameterString = "";
        final String expectedUsageString = "Usage: return <book> <user>";
        Command returnCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(returnCommand.getValidationResult(),false);
        String actualUsageString = returnCommand.getOperation().getUsage();
        assertEquals("Usage string not equal", expectedUsageString, actualUsageString);
    }

    @Test
    public void validateBasicValidReturnCommand() {
        final String operationString = "return";
        final String parameterString = "1123123123 123123";
        Command returnCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(returnCommand.getValidationResult(),true);
    }

    @Test
    public void validateBasicInvalidReturnCommandWithMoreParameters() {
        final String operationString = "return";
        final String parameterString = "1123123123 123123 123123123";
        Command returnCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(returnCommand.getValidationResult(),false);
    }

    @Test
    public void validateHelpCommand() {
        final String operationString = "help";
        final String parameterString = "";
        Command helpCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(helpCommand.getValidationResult(),true);
    }
    @Test
    public void validateHelpCommandWithParameter() {
        final String operationString = "help";
        final String parameterString = "search";
        Command helpCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(helpCommand.getValidationResult(),true);
    }

    @Test
    public void validateHelpCommandWithMultipleParameter() {
        final String operationString = "help";
        final String parameterString = "search issue";
        Command helpCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(helpCommand.getValidationResult(),false);
    }

}
