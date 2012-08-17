/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade.mock;

import com.rixon.lms_console.facade.ServiceFacade;
import com.rixon.lms_console.service.SearchService;
import com.rixon.lms_console.service.Service;
import com.rixon.lms_console.service.mock.SearchServiceMock;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.operation.OperationTypes.HELP;
import static com.rixon.lms_console.command.operation.OperationTypes.SEARCH;

/**
 * User: 229921|Date: 8/17/12|Time: 8:57 PM
 */
public class ServiceFacadeMock implements ServiceFacade {

    private Map<String,Service> serviceMap;

    public ServiceFacadeMock() {
        loadServiceMap();
    }

    private void loadServiceMap(){
        serviceMap  = new HashMap<String,Service>();
        serviceMap.put(SEARCH,new SearchServiceMock());
        serviceMap.put(HELP,new HelpServiceMock());
    }
    public Service serviceForOperation(String operationName) {
        Service service = serviceMap.get(operationName);
        return service;
    }

}
