/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains all utility functions associated with date formatting
 * User: 229921|Date: 8/17/12|Time: 10:36 PM
 */
public class DateUtil {
    private static final DateFormat dateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT);

    public static Date getFormattedDate(String dateString)
    {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid date string "+dateString);
        }
    }

    public static String getDateAsString(Date date) {
        return dateFormat.format(date);
    }
}
