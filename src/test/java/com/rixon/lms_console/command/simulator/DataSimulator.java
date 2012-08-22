/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import java.util.*;

/**
 * This class is used to simulate stub titles based on a set of seed entries. This logic can
 * be used to create random values that conform to a given pattern with random values in the
 * places where pattern is not required
 * User: rixon|Date: 8/20/12|Time: 1:18 AM
 */
public class DataSimulator {

    private List<String> seedWords;
    private String titlePattern = " %1$s %2$s %3$s %4$s" ;
    Random random = new Random();
    private List<Date> seedDates;

    public void setTitleSeed(List<String> seedWords) {
        this.seedWords = seedWords;
    }

    public List<String> mockTitles(int number) {
        List<String> mockTitles = new ArrayList<String>();
        for (int i=0;i<number;i++) {
            Formatter stringFormatter = new Formatter();
            String sampleTitle = stringFormatter.format(titlePattern, randomTitle(),
                                            randomTitle(),randomTitle(),randomTitle()).toString();
            mockTitles.add(sampleTitle);
        }
        return mockTitles;
    }

    private String randomTitle() {
        return seedWords.get(random.nextInt(seedWords.size()));
    }

    public void setDateSeed(List<Date> seedDates) {
        this.seedDates = seedDates;
    }

    public List<Date> mockDates(int number) {
        List<Date> mockDates = new ArrayList<Date>();
        for (int i=0;i<number;i++) {
            mockDates.add(randomDate());
        }
        return mockDates;
    }

    private Date randomDate() {
        return seedDates.get(random.nextInt(seedDates.size()));
    }

}


/**
 //TODO
 1) Strategy pattern to get the sampleString based on template and seedList
 2) Higher level function based on domain object that knows which simulator to call
 e.g. Title Simulator, Author Simulator, Date Simulator,  Property Simulator based on the attributes
 of the domain object.

 3) Create configuration that takes count
 4) create sequence for each table and associated with the dao object to save repetitive manual effort

 */