/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.exception.strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Basic Exception Strategy will only log the exception messages. This will not cause the failure of the application
 * User: rixonmathew
 * Date: 08/12/12
 * Time: 11:35 PM
 */
public class BasicExceptionStrategy implements ExceptionHandlingStrategy {
    @Override
    public void handleException(Exception e) {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.FINE, e.getMessage());
    }
}
