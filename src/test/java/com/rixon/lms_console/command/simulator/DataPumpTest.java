/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import org.junit.Test;

/**
 * User: 229921|Date: 8/21/12|Time: 8:19 PM
 */
public class DataPumpTest {

    @Test
    public void testDataPump() {
        /**
         * 1) Identify the seed tables
         * 2) Load data from the data structures. Since the seed tables need to be
         *    semantic, this data should not be generated from simulator. It should come
         *    from a provider.
         * 3) Load all seed tables into data structures
         * 4) Identify the data simulator for each table and generate the simulated fields
         * 5) Replace foreign keys with corresponding ids from data structures
         * 6) Find child tables of this table and create entry till there are no child tables.
         * 7) Repeat this process till the configured number of elements are created in these
         *    tables
         * 8) assert count in all related tables to be same as master count
         */
    }
}
