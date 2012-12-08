/*
 * Copyright (c) 2012.
 * Author: Rixolong as the credit is provided to me for this work
 */

package com.rixon.lms_console.exception;

/**
 * User: rixonmathew
 * Date: 08/12/12
 * Time: 11:52 PM
 */
public class InvalidMemberException extends Exception {
    public InvalidMemberException(String message) {
        super("Invalid Member with id:" + message);
    }
}
