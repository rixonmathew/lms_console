/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade;

import java.util.HashMap;
import java.util.Map;

import com.rixon.lms_console.service.SearchService;
import com.rixon.lms_console.service.Service;

import static com.rixon.lms_console.command.operation.OperationTypes.SEARCH;

/**
 * This class represents the facade to access all the services associated with LMS
 * User: 229921
 * Date: 8/17/12
 * Time: 7:05 PM
 */
public class ServiceFacade {

    private static Map<String,Service> serviceMap = new HashMap<String,Service>();

    static {
        loadServiceMap();
    }

    private static void loadServiceMap(){
        serviceMap.put(SEARCH,new SearchService());
    }
    public static Service serviceForOperation(String operationName) {
      Service service = serviceMap.get(operationName);
      return service;
    }
}
