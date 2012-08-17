package com.rixon.lms_console.commandbuilder;

import com.rixon.lms_console.command.Command;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is responsible for verifying the validator logic of the command
 * User: rixonmathew
 * Date: 12/08/12
 * Time: 10:25 AM
 */
public class CommandValidatorTest {

    private CommandBuilder builder;

    @Before
    public void setup() {
        builder = new CommandBuilder();
    }

    @After
    public void tearDown() {
        builder = null;
    }

    @Test
    public void validateBasicInvalidSearchCommand() {
        final String operationString = "search";
        final String parameterString = "";
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),false);
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
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),false);
    }

    @Test
    public void validateBasicInvalidIssueCommandWithMoreParameters() {
        final String operationString = "issue";
        final String parameterString = "112321321 1123232 112321312";
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),false);
    }

    @Test
    public void validateBasicValidIssueCommandWithMoreParameters() {
        final String operationString = "issue";
        final String parameterString = "112321321 1123232";
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),true);
    }

    @Test
    public void validateBasicInvalidTransferCommand() {
        final String operationString = "transfer";
        final String parameterString = "";
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),false);
    }

    @Test
    public void validateBasicValidTransferCommand() {
        final String operationString = "transfer";
        final String parameterString = "1123123123 123123 111230";
        Command searchCommand = CommandTestUtil.createCommand(operationString,parameterString,builder);
        CommandTestUtil.assertValidationResult(searchCommand.getValidationResult(),true);
    }


}
