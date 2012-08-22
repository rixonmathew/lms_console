/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.operation;

/**
 * This class represents the exit operation
 * User: rixon|Date: 8/17/12|Time: 10:01 AM
 */
public class ExitOperation extends AbstractOperation {
    public ExitOperation(String operationType) {
        super(operationType);
        usage = "Usage: exit";
    }
}
