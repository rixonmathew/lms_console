/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import java.util.List;

/**
 * This class is used to provide a random Genre value
 * User: rixon|Date: 9/11/12|Time: 7:29 PM
 */
public class GenreMockValueProvider extends DefaultMockPropertyValueProvider {

    @Override
    protected String randomValue() {
        return randomString();
    }

    @Override
    protected String randomString() {
        List<String> randomGenres = mockDataSeed.getSeedGenres();
        int index = random.nextInt(randomGenres.size());
        return randomGenres.get(index);
    }
}
