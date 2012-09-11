/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import org.jetbrains.annotations.Nullable;
import org.junit.After;
import org.junit.Before;

/**
 * This is a test file for validating the DataSimulator
 * User: rixon|Date: 8/20/12|Time: 1:15 AM
 */
public class DataSimulatorTest {

    @Nullable
    private
    DataSimulator dataSimulator;

    @Before
    public void setup() {
        dataSimulator = new DataSimulator();
    }

    @After
    public void tearDown() {
        dataSimulator = null;
    }

}
