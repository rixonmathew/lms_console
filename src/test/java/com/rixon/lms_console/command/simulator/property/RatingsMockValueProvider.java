/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import java.util.List;

/**
 * This class will provide the mock values for various Ratings
 * User: rixon|Date: 9/11/12|Time: 7:38 PM
 */
public class RatingsMockValueProvider extends DefaultMockPropertyValueProvider {

    @Override
    protected String randomValue() {
        return randomString();
    }

    @Override
    protected String randomString() {
        List<String> mockRatings = mockDataSeed.getSeedRatings();
        int index = random.nextInt(mockRatings.size());
        return mockRatings.get(index);
    }
}
