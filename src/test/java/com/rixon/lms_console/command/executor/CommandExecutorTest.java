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
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandExecutorTest extends AbstractCommandTest {

    CommandExecutor executor;

    @Before
    public void setUp() {
      super.setup();
      executor = new SimpleCommandExecutor();
      System.setProperty(ServiceFacadeFactory.LMS_MODE,ServiceFacadeFactory.FAKE);
    }

    @Test
    public void testBasicCommandExecution() {
       Command searchCommand = CommandTestUtil.createCommand("search","1123123123,1232311123123",builder);
       Result result = executor.executeCommand(searchCommand);
       assertNotNull(result);
       TableModel tableModel = result.getResultsTable();
       assertEquals("count of results not same",2,tableModel.getRowCount());
       assertEquals("count of columns not same",5,tableModel.getColumnCount());
       assertCellValues(tableModel);
    }

    @Test
    public void testHelpCommandExecution() {
        Command helpCommand = CommandTestUtil.createCommand("help","",builder);
        Result result = executor.executeCommand(helpCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed count of commands is not same",4,tableModel.getRowCount());
        assertEquals("Displayed count of result columns is not same",1,tableModel.getColumnCount());
        assertCellValues(tableModel);
    }

    @Test
    public void testIssueCommandExecution() {
        Command issueCommand = CommandTestUtil.createCommand("issue","1123122 u100120",builder);
        Result result = executor.executeCommand(issueCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for issue command is not same",1,tableModel.getRowCount());
    }

    @Test
    public void testTransferCommandExecution() {
        Command transferCommand = CommandTestUtil.createCommand("transfer","1123122 u100120 u112232",builder);
        Result result = executor.executeCommand(transferCommand);
        assertNotNull(result);
        TableModel tableModel = result.getResultsTable();
        assertEquals("Displayed rows for issue command is not same",1,tableModel.getRowCount());
    }


    private void assertCellValues(TableModel tableModel) {
        for (int row=0;row<tableModel.getRowCount();row++) {
            for (int column=0;column<tableModel.getColumnCount();column++){
                Object cellValue = tableModel.getValueAt(row,column);
                assertNotNull("Cell value null at row:"+row+" column:"+column,cellValue);
            }
        }
    }

}
