/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.facade;

import com.rixon.lms_console.service.Service;

/**
 * This interface represents the facade for accessing the service. It is an implementation of
 * Abstract Factory Design Pattern by GoF
 * User: 229921|Date: 8/17/12|Time: 8:51 PM
 */
public interface ServiceFacade {

    /**
     * This method will provide the Service instance for the given operation
     * @param operationName
     * @return Service instance
     */
    public Service serviceForOperation(String operationName);
}
