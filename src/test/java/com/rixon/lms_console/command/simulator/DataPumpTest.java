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
 * This class is used for testing the Datapump which is responsible for creating mock data for the lms
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
    public void testItemPumpForBooks() {
        testItemsForItemType("BOOK", 500);
    }

    @Test
    public void testItemPumpForMovie() {
        testItemsForItemType("MOVIE", 500);
    }

    @Test
    public void testItemPumpForMusic() {
        testItemsForItemType("MUSIC", 500);
    }

    @Test
    public void testItemPumpForGames() {
        testItemsForItemType("GAME", 500);
    }

    @Test
    public void testItemPumpForMagazine() {
        testItemsForItemType("MAGAZINE", 500);
    }

    @Test
    public void testItemPumpForJournal() {
        testItemsForItemType("JOURNAL", 500);
    }

    @Test
    public void testItemPumpForNewspaperArchives() {
        testItemsForItemType("MUSIC", 500);
    }

    private void testItemsForItemType(String itemType, int expectedMockItems) {
        DataPump dataPump = new DataPump(dataSimulator);
        List<Item> mockItems = dataPump.generateMockItems(expectedMockItems, itemType);
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
