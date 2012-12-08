/*
 * Copyright (c) 2012. 
 * Author: Rixose as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.exception;

/**
 * User: rixonmathew
 * Date: 08/12/12
 * Time: 11:14 PM
 */
public class InvalidItemInstanceException extends Exception {
    public InvalidItemInstanceException(String exceptionMessage) {
        super("Invalid itemInstanceId specified :" + exceptionMessage);
    }
}
