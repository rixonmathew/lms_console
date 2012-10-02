/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade;

import com.rixon.lms_console.service.*;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.command.operation.OperationTypes.*;

/**
 * This class represents the facade to access all the services associated with LMS
 * User: rixon|Date: 8/17/12|Time: 7:05 PM
 */
public class ServiceFacadeReal implements ServiceFacade {

    private Map<String,Service> serviceMap;

    public ServiceFacadeReal() {
      loadServiceMap();
    }

    private void loadServiceMap(){
        serviceMap  = new HashMap<String,Service>();
        serviceMap.put(SEARCH,new SearchService());
        serviceMap.put(HELP,new HelpService());
        serviceMap.put(ISSUE,new IssueService());
        serviceMap.put(TRANSFER,new TransferService());
        serviceMap.put(RETURN,new ReturnService());
        serviceMap.put(EXIT,new ExitService());
        serviceMap.put(LIST_USER,new ListUserService());
    }

    public Service serviceForOperation(String operationName) {
        return serviceMap.get(operationName);
    }
}
