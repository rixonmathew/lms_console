/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import org.apache.commons.lang.StringUtils;

import java.util.Formatter;
import java.util.List;

/**
 * This class is used to provide mock title values
 * User: rixon|Date: 9/11/12|Time: 7:18 PM
 */
public class TitleMockValueProvider extends DefaultMockPropertyValueProvider {

    @Override
    protected String randomValue() {
        int digits = StringUtils.countMatches(template, "%");
        Formatter stringFormatter = new Formatter();
        return stringFormatter.format(template, strings(digits)).toString();
    }

    @Override
    protected String randomString() {
        List<String> mockTitles = mockDataSeed.getSeedWordsTitle();
        int index = random.nextInt(mockTitles.size());
        return mockTitles.get(index);
    }
}
