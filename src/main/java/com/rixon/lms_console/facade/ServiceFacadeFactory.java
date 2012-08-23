/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade;

import com.rixon.lms_console.facade.mock.ServiceFacadeMock;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the factory that produces ServiceFacade. Depending upon the set
 * environment a correct instance of Service Facade is returned. This class implements GoF
 * Abstract Factory Pattern
 * User: rixon|Date: 8/17/12|Time: 8:54 PM
 */
public class ServiceFacadeFactory {

    public final static String FAKE = "FAKE";
    public final static String REAL = "REAL";
    public final static String LMS_MODE = "com.rixon.lms_console.service_mode";

    private static Map<String,ServiceFacade> serviceFacadeMap;
    static {
       loadServiceFacadeMap();
    }

    private static void loadServiceFacadeMap() {
        serviceFacadeMap = new HashMap<String,ServiceFacade>();
        serviceFacadeMap.put(FAKE,new ServiceFacadeMock());
        serviceFacadeMap.put(REAL,new ServiceFacadeReal());
    }
    public static ServiceFacade serviceFacade() {
        String mode = determineServiceMode();
        return serviceFacadeMap.get(mode);
    }

    private static String determineServiceMode() {
        String mode = System.getProperty(LMS_MODE);
        if(mode==null){
            mode = REAL;
        }
        return mode;
    }
}
