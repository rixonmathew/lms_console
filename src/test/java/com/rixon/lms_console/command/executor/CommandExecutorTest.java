package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.AbstractCommandTest;
import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.CommandTestUtil;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.facade.ServiceFacadeFactory;
import org.junit.Before;
import org.junit.Test;

import javax.swing.table.TableModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class is for testing the command execution functionality
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class CommandExecutorTest extends AbstractCommandTest {

    private CommandExecutor executor;

    @Before
    public void setUp() {
        super.setup();
        executor = new SimpleCommandExecutor();
        //System.setProperty(ServiceFacadeFactory.LMS_MODE, ServiceFacadeFactory.FAKE);
    }

    @Test
    public void testBasicCommandExecution() {
        Command searchCommand = CommandTestUtil.createCommand("search", "1123123123,1232311123123", builder);
        Result result = executor.executeCommand(searchCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expectedItemCount = 3;
        assertEquals("count of results not same", expectedItemCount, tableModel.getRowCount());
        assertEquals("count of columns not same", 5, tableModel.getColumnCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testHelpCommandExecution() {
        Command helpCommand = CommandTestUtil.createCommand("help", "", builder);
        Result result = executor.executeCommand(helpCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expected = 8;
        assertEquals("Displayed count of commands is not same", expected, tableModel.getRowCount());
        assertEquals("Displayed count of result columns is not same", 1, tableModel.getColumnCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testHelpCommandExecutionForOperation() {
        Command helpCommand = CommandTestUtil.createCommand("help", "search", builder);
        Result result = executor.executeCommand(helpCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed count of commands is not same", 1, tableModel.getRowCount());
        assertEquals("Displayed count of result columns is not same", 1, tableModel.getColumnCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testIssueCommandExecution() {
        Command issueCommand = CommandTestUtil.createCommand("issue", "1123122 u100120", builder);
        Result result = executor.executeCommand(issueCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for issue command is not same", 1, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testTransferCommandExecution() {
        Command transferCommand = CommandTestUtil.createCommand("transfer", "1123122 u100120 u112232", builder);
        Result result = executor.executeCommand(transferCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for issue command is not same", 1, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testReturnCommandExecution() {
        Command returnCommand = CommandTestUtil.createCommand("return", "1123122 u100120", builder);
        Result result = executor.executeCommand(returnCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for issue command is not same", 1, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testInvalidCommandExecution() {
        Command invalidCommand = CommandTestUtil.createCommand("invalid", "112312312,123123,12312312,123123", builder);
        Result result = executor.executeCommand(invalidCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for invalid command is not same", 2, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testExitCommandExecution() {
        Command exitCommand = CommandTestUtil.createCommand("exit", "", builder);
        Result result = executor.executeCommand(exitCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for invalid command is not same", 1, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testExitCommandExecutionWithInvalidParameters() {
        Command exitCommand = CommandTestUtil.createCommand("exit", "112321123", builder);
        CommandTestUtil.assertValidationResult(exitCommand.getValidationResult(), false);
        Result result = executor.executeCommand(exitCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for invalid command is not same", 2, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testReserveCommand() {
        Command reservedCommand = CommandTestUtil.createCommand("reserve", "112321123 user123", builder);
        CommandTestUtil.assertValidationResult(reservedCommand.getValidationResult(), true);
        Result result = executor.executeCommand(reservedCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expectedMessageCount = 1;
        assertEquals("Displayed rows for invalid command is not same", expectedMessageCount, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testReserveCommandWithInvalidParameters() {
        Command reservedCommand = CommandTestUtil.createCommand("reserve", "112321123", builder);
        CommandTestUtil.assertValidationResult(reservedCommand.getValidationResult(), false);
        Result result = executor.executeCommand(reservedCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expectedMessageCount = 2;
        assertEquals("Displayed rows for invalid command is not same", expectedMessageCount, tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testListUserCommandWithNoParameters() {
        Command listCommand = CommandTestUtil.createCommand("list-user","",builder);
        assertNotNull(listCommand);
        CommandTestUtil.assertValidationResult(listCommand.getValidationResult(),true);
        Result result = executor.executeCommand(listCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expectedRowCount = 4;
    }

    @Test
    public void testListItemCommand() {
        final long itemID = 12982;
        Command listItemCommand = CommandTestUtil.createCommand("list-item",String.valueOf(itemID),builder);
        assertNotNull(listItemCommand);
        CommandTestUtil.assertValidationResult(listItemCommand.getValidationResult(),true);
        Result result = executor.executeCommand(listItemCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expectedRowCount = 15;
        assertEquals("Displayed rows for list command is not as expected",expectedRowCount,tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);

    }

    @Test
    public void testLitstItemCommandForInvalidItemID() {
        final long itemID = 101;
        Command listItemCommand = CommandTestUtil.createCommand("list-item",String.valueOf(itemID),builder);
        assertNotNull(listItemCommand);
        CommandTestUtil.assertValidationResult(listItemCommand.getValidationResult(),true);
        Result result = executor.executeCommand(listItemCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        final int expectedRowCount = 1;
        assertEquals("Displayed rows for list command is not as expected",expectedRowCount,tableModel.getRowCount());
        CommandTestUtil.assertCellValues(tableModel);

    }
}
