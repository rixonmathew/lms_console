/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade.mock;

import com.rixon.lms_console.facade.ServiceFacade;
import com.rixon.lms_console.service.Service;
import com.rixon.lms_console.service.stub.*;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.operation.OperationTypes.*;

/**
 * This class represents the facade for accessing the stub services.
 * User: rixon|Date: 8/17/12|Time: 8:57 PM
 */
public class ServiceFacadeMock implements ServiceFacade {

    private Map<String,Service> serviceMap;

    public ServiceFacadeMock() {
        loadServiceMap();
    }

    private void loadServiceMap(){
        serviceMap  = new HashMap<String,Service>();
        serviceMap.put(SEARCH,new SearchServiceStub());
        serviceMap.put(HELP,new HelpServiceStub());
        serviceMap.put(ISSUE,new IssueServiceStub());
        serviceMap.put(TRANSFER,new TransferServiceStub());
        serviceMap.put(RETURN,new ReturnServiceStub());
        serviceMap.put(EXIT,new ExitServiceStub());
    }
    public Service serviceForOperation(String operationName) {
        Service service = serviceMap.get(operationName);
        return service;
    }

}
