/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.business.SimpleStore;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemInstance;
import org.jetbrains.annotations.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: rixon|Date: 8/21/12|Time: 8:19 PM
 */
public class DataPumpTest {

    @Nullable
    private DataSimulator dataSimulator;

    @Before
    public void setUp() {
        dataSimulator = new DataSimulator();
        try {
            dataSimulator.loadSeedsFromFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        dataSimulator = null;
    }

    @Test
    public void testItemPump() {
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
        DataPump dataPump = new DataPump(dataSimulator);
        final int expectedMockItems = 500;//  100;
        List<Item> mockItems = dataPump.generateMockItems(expectedMockItems);
        assertNotNull(mockItems);
        assertEquals("Size of item list is not as expected", expectedMockItems, mockItems.size());
        for (Item item : mockItems) {
            System.out.println("item = " + item);
        }
        SimpleStore.getInstance().addItemsToLibrary(mockItems);

    }

    @Test
    public void testItemInstancePump() {
        DataPump dataPump = new DataPump(dataSimulator);
        final int expectedInstances = 10;
        List<ItemInstance> mockItemInstances = dataPump.generateMockItemInstances(expectedInstances);
        assertNotNull(mockItemInstances);
        System.out.println("count = " + mockItemInstances.size());
        SimpleStore.getInstance().addItemInstancesToLibrary(mockItemInstances);
    }
}
