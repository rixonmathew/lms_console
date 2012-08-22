/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.console;

import com.rixon.lms_console.main.LMSConsole;
import org.junit.Test;

/**
 * This class is used for testing the LMSConsole functionality
 * User: rixon|Date: 8/18/12|Time: 9:59 PM
 */
public class LMSConsoleTest {
    @Test
    public void testBasicConsoleFunctionality() {
        LMSConsole console = new LMSConsole();
        console.start();
    }
}
