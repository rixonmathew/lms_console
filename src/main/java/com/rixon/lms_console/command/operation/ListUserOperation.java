/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.operation;

import static com.rixon.lms_console.command.operation.OperationTypes.LIST_USER;

/**
 * This class represents the operation type list
 * User: rixon|Date: 9/19/12|Time: 4:43 PM
 */
public class ListUserOperation extends AbstractOperation {
    ListUserOperation() {
        super(LIST_USER);
        usage = "Usage: list-user [userid]";
    }
}
