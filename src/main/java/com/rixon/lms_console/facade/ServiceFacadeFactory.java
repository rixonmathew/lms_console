/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the factory that produces ServiceFacade. Depending upon the set
 * environment a correct instance of Service Facade is returned. This class implements GoF
 * Abstract Factory Pattern
 * User: rixon|Date: 8/17/12|Time: 8:54 PM
 */
public class ServiceFacadeFactory {

    public final static String LOCAL = "LOCAL";
    //TODO think about other modes in which Service can be separated out from the application
    public final static String SERVICE_MODE = "com.rixon.lms_console.service_mode";

    private static Map<String, ServiceFacade> serviceFacadeMap;

    static {
        loadServiceFacadeMap();
    }

    private static void loadServiceFacadeMap() {
        serviceFacadeMap = new HashMap<String, ServiceFacade>();
        serviceFacadeMap.put(LOCAL, new ServiceFacadeLocal());
    }

    public static ServiceFacade serviceFacade() {
        String mode = determineServiceMode();
        return serviceFacadeMap.get(mode);
    }

    private static String determineServiceMode() {
        String mode = System.getProperty(SERVICE_MODE);
        if (mode == null) {
            mode = LOCAL;
        }
        return mode;
    }
}
