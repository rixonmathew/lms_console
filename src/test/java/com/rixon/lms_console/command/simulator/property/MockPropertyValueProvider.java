/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator.property;

import com.rixon.lms_console.command.simulator.MockDataSeed;

/**
 * User: rixon|Date: 9/11/12|Time: 3:52 PM
 */
interface MockPropertyValueProvider {
    /**
     * This method will provide a random value conforming to the template
     *
     * @return
     */
    String randomMockValue(MockDataSeed mockDataSeed, String template);
}
