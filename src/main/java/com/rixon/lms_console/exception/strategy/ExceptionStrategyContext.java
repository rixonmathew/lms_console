/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.exception.strategy;

import com.rixon.lms_console.exception.InvalidItemInstanceException;
import com.rixon.lms_console.exception.InvalidMemberException;
import com.rixon.lms_console.exception.ItemCannotBeReservedException;

import java.util.HashMap;
import java.util.Map;

/**
 * This classis the context for Exception Strategy.
 * User: rixonmathew
 * Date: 08/12/12
 * Time: 11:31 PM
 */
public class ExceptionStrategyContext {

    private static final Map<Class, ExceptionHandlingStrategy> strategyMap = new HashMap<Class, ExceptionHandlingStrategy>();
    private static final ExceptionHandlingStrategy defaultStrategy;

    static {
        ExceptionHandlingStrategy simpleStrategy = new BasicExceptionStrategy();
        defaultStrategy = simpleStrategy;
        strategyMap.put(InvalidItemInstanceException.class, simpleStrategy);
        strategyMap.put(InvalidMemberException.class, simpleStrategy);
        strategyMap.put(ItemCannotBeReservedException.class, simpleStrategy);
    }

    public static ExceptionHandlingStrategy strategyForException(Exception e) {
        ExceptionHandlingStrategy strategy = strategyMap.get(e.getClass());
        if (strategy == null) {
            strategy = defaultStrategy;
        }
        return strategy;
    }
}
