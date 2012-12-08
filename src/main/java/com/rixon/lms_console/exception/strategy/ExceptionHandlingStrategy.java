/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.exception.strategy;

/**
 * This interface represents the strategy that is used for handling the various exceptions. This is especially useful in scnearios
 * User: rixonmathew
 * Date: 08/12/12
 * Time: 11:29 PM
 */
public interface ExceptionHandlingStrategy {

    /**
     * This is the main method for handling the exception
     *
     * @param e
     */
    public void handleException(Exception e);
}
