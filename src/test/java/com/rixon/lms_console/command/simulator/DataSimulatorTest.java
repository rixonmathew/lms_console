/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.util.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * User: 229921|Date: 8/20/12|Time: 1:15 AM
 */
public class DataSimulatorTest {

    DataSimulator dataSimulator;

    @Before
    public void setup() {
        dataSimulator = new DataSimulator();
    }

    @After
    public void tearDown() {
        dataSimulator = null;
    }

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
        dataSimulator.setTitleSeed(seedWords);
        List<String> titles = dataSimulator.mockTitles(20);
        assertNotNull(titles);
        for (String title:titles) {
            System.out.println(title);
        }
    }

   @Test
    public void testDateGenerationFromDataPool() {
       List<Date> seedDates = new ArrayList<Date>();
       seedDates.add(DateUtil.getFormattedDate("01/01/2001"));
       seedDates.add(DateUtil.getFormattedDate("01/01/2002"));
       seedDates.add(DateUtil.getFormattedDate("01/01/2003"));
       seedDates.add(DateUtil.getFormattedDate("01/01/2005"));
       seedDates.add(DateUtil.getFormattedDate("01/01/2006"));
       seedDates.add(DateUtil.getFormattedDate("12/21/2001"));
       dataSimulator.setDateSeed(seedDates);
       List<Date> dates = dataSimulator.mockDates(20);
       assertNotNull(dates);
       for (Date date:dates) {
           System.out.println(DateUtil.getDateAsString(date));
       }
   }
}
