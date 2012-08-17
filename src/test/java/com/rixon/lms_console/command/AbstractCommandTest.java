package com.rixon.lms_console.command;

import com.rixon.lms_console.command.builder.CommandBuilder;
import org.junit.After;
import org.junit.Before;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/17/12
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
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
