/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import com.rixon.lms_console.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * User: rixon|Date: 9/11/12|Time: 7:09 PM
 */
public class DatesMockValueProvider extends DefaultMockPropertyValueProvider {

    @Override
    protected String randomValue() {
        List<Date> seedDates = mockDataSeed.getSeedDates();
        int index = random.nextInt(seedDates.size());
        Date randomDate = seedDates.get(index);
        return DateUtil.getDateAsString(randomDate);
    }
}
