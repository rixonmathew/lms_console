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
 * User: rixon|Date: 9/11/12|Time: 6:41 PM
 */
public class NamesMockValueProvider extends DefaultMockPropertyValueProvider {

    @Override
    protected String randomValue() {
        int digits = StringUtils.countMatches(template,"%");
        Formatter stringFormatter = new Formatter();
        String randomText = stringFormatter.format(template, strings(digits)).toString();
        return randomText;
    }

    @Override
    protected String randomString() {
        List<String> seedNames = mockDataSeed.getSeedNames();
        int index = random.nextInt(seedNames.size());
        return seedNames.get(index);
    }
}
