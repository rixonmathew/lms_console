/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.operation;

/**
 * User: rixon|Date: 8/23/12|Time: 8:33 PM
 */
public class ReserveOperation extends AbstractOperation {
    public ReserveOperation(String operationType) {
        super(operationType);
        usage = "Usage: reserve <book> <user>";
    }
}
