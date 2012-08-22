/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.main;

/**
 * This class is the main entry point of the application where it initiates the console
 * User: rixon|Date: 8/19/12|Time: 12:16 AM
 */
public class LMSMain {

    public static void main(String[] args) {
        LMSConsole console = new LMSConsole();
        console.start();
    }
}
