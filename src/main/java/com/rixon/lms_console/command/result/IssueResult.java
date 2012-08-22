/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import java.util.List;

/**
 * This class is used to return the result of issue command.
 * User: rixon|Date: 8/17/12|Time: 11:24 PM
 */
public class IssueResult extends ResultWithMessage {

    public IssueResult(List results) {
        super(results);
    }
}
