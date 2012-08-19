package com.rixon.lms_console.command;

import com.rixon.lms_console.command.builder.CommandBuilder;
import org.junit.After;
import org.junit.Before;

/**
 * This class is the abstract test associated with testing the command
 * User: 229921|Date: 8/17/12|Time: 10:01 AM
 */
public abstract class AbstractCommandTest {

    protected CommandBuilder builder;

    @Before
    public void setup() {
        builder = new CommandBuilder();
    }

    @After
    public void tearDown() {
        builder = null;
    }

}
