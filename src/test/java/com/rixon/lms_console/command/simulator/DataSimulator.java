/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.command.simulator.property.PropertyDataSimulator;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * This class is used to simulate stub titles based on a set of seed entries. This logic can
 * be used to create random values that conform to a given pattern with random values in the
 * places where pattern is not required
 * User: rixon|Date: 8/20/12|Time: 1:18 AM
 */
public class DataSimulator {

    private final MockDataSeed mockDataSeed;
    private final PropertyDataSimulator propertyDataSimulator;
    private final Random random = new Random();

    public DataSimulator() {
        mockDataSeed = new MockDataSeed();
        propertyDataSimulator = new PropertyDataSimulator(mockDataSeed);
    }

    @NotNull
    public List<String> mockTitles(int number) {
        List<String> mockTitles = new ArrayList<String>();
        String titlePattern = "%1$s %2$s";
        for (int i = 0; i < number; i++) {
            Formatter stringFormatter = new Formatter();
            String sampleTitle = stringFormatter.format(titlePattern, randomTitle(),
                    randomTitle()).toString();
            mockTitles.add(sampleTitle);
        }
        return mockTitles;
    }

    @NotNull
    public List<String> mockDescriptions(int number) {
        List<String> mockDescriptions = new ArrayList<String>();
        String descriptionPattern = "The %1$s is always %2$s to %3$s do %4$s something about %5$s.";
        for (int i = 0; i < number; i++) {
            Formatter stringFormatter = new Formatter();
            String sampleTitle = stringFormatter.format(descriptionPattern, randomDescription(),
                    randomDescription(), randomDescription(), randomDescription(),
                    randomDescription()).toString();
            mockDescriptions.add(sampleTitle);
        }
        return mockDescriptions;
    }


    private String randomTitle() {
        final int size = mockDataSeed.getSeedWordsTitle().size();
        //System.out.println("size = " + size);
        final int index = random.nextInt(Math.abs(size));
        //System.out.println("index = " + index);
        return mockDataSeed.getSeedWordsTitle().get(index);
    }

    private String randomDescription() {
        final int size = mockDataSeed.getSeedWordsDescription().size();
        final int index = random.nextInt(size);
        return mockDataSeed.getSeedWordsDescription().get(index);

    }

    @NotNull
    public List<Date> mockDates(int number) {
        List<Date> mockDates = new ArrayList<Date>();
        for (int i = 0; i < number; i++) {
            mockDates.add(randomDate());
        }
        return mockDates;
    }

    private Date randomDate() {
        return mockDataSeed.getSeedDates().get(random.nextInt(mockDataSeed.getSeedDates().size()));
    }


    @NotNull
    public Map<String, List<String>> mockPropertyValues(int expectedMockItems) {
        return propertyDataSimulator.mockPropertyValues(expectedMockItems);
    }
}
