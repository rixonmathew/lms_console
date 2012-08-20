/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * User: 229921|Date: 8/20/12|Time: 1:15 AM
 */
public class DataSimulatorTest {

    @Test
    public void testTitleGenerationFromDataPool() {
        List<String> seedWords = new ArrayList<String>();
        seedWords.add("Grace");
        seedWords.add("Epiphany");
        seedWords.add("Uneqivocal");
        seedWords.add("Ipkiss");
        seedWords.add("Journey");
        seedWords.add("Meaning");
        seedWords.add("Defense");
        seedWords.add("Arcade");
        DataSimulator dataSimulator = new DataSimulator();
        dataSimulator.setTitleSeed(seedWords);
        List<String> titles = dataSimulator.mockTitles(20);
        assertNotNull(titles);
        for (String title:titles) {
            System.out.println(title);
        }

    }
}
