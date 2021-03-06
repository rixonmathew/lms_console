/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.operation;

import static com.rixon.lms_console.command.operation.OperationTypes.LIST_ITEM;

/**
 * This class represents the operation for ListItem
 * User: rixon|Date: 10/2/12|Time: 12:08 PM
 */
public class ListItemOperation extends AbstractOperation {
    ListItemOperation() {
        super(LIST_ITEM);
        this.usage = "list-item <item-id>";
    }
}
