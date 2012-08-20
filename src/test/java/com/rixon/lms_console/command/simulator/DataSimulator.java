/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

/**
 * This class is used to simulate mock titles based on a set of seed entries. This logic can
 * be used to create random values that conform to a given pattern with random values in the
 * places where pattern is not required
 * User: 229921|Date: 8/20/12|Time: 1:18 AM
 */
public class DataSimulator {

    private List<String> seedWords;
    private String titlePattern = " %1$s %2$s %3$s %4$s" ;
    Random random = new Random();

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
}
