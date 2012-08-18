/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.operation;

/**
 * User: 229921|Date: 8/18/12|Time: 8:30 PM
 */
public class ExitOperation extends AbstractOperation {
    public ExitOperation(String operationType) {
        super(operationType);
        usage = "Usage: exit";
    }
}
