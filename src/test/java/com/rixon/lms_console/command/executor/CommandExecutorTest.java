package com.rixon.lms_console.command.executor;

import com.rixon.lms_console.command.AbstractCommandTest;
import com.rixon.lms_console.command.Command;
import com.rixon.lms_console.command.CommandTestUtil;
import com.rixon.lms_console.command.result.Result;
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
    }

    @Test
    public void testBasicCommandExecution() {
       Command searchCommand = CommandTestUtil.createCommand("search","1123123123,1232311123123",builder);
       Result result = executor.executeCommand(searchCommand);
       assertNotNull(result);
       TableModel tableModel = result.getResultsTable();
       assertEquals("count of results not same",2,tableModel.getRowCount());
    }
}
