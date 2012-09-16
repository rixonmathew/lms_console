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
 * This class is used for
 * User: rixon|Date: 9/11/12|Time: 3:52 PM
 */
class NumbersMockValueProvider extends DefaultMockPropertyValueProvider {

    @Override
    protected String randomValue() {
        int digits = StringUtils.countMatches(template, "%d");
        Formatter stringFormatter = new Formatter();
        String mockISBN = stringFormatter.format(template, numbersForISBN(digits)).toString();
        return mockISBN;
    }

    private Integer[] numbersForISBN(int size) {
        Integer[] numbers = new Integer[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = randomNumber();
        }
        return numbers;
    }

    private int randomNumber() {
        final List<String> seedISBNs = mockDataSeed.getSeedNumbers();
        final int index = random.nextInt(seedISBNs.size());
        return Integer.valueOf(seedISBNs.get(index));
    }

}
