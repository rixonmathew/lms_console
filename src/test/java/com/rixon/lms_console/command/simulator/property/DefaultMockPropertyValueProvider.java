/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import com.rixon.lms_console.command.simulator.MockDataSeed;

import java.util.List;
import java.util.Random;

/**
 * This class is the default Mock value provider that will be accessed when no specific providers
 * are in place for a given property
 * User: rixon|Date: 9/11/12|Time: 4:43 PM
 */
public class DefaultMockPropertyValueProvider implements MockPropertyValueProvider {

    protected MockDataSeed mockDataSeed;
    protected Random random = new Random();
    protected String template;

    @Override
    public String randomMockValue(MockDataSeed mockDataSeed, String template) {
        this.mockDataSeed = mockDataSeed;
        this.template = template;
        return randomValue();
    }

    protected String randomValue() {
        List<String> randomTitles = mockDataSeed.getSeedWordsTitle();
        int index = random.nextInt(randomTitles.size());
        return randomTitles.get(index);
    }

    protected String[] strings(int size) {
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = randomString();
        }
        return strings;
    }

    protected String randomString() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}

