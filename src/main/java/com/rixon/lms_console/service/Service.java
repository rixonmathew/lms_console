package com.rixon.lms_console.service;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;

/**
 * This interface represents the services for performing operations
 * User: 229921
 * Date: 8/17/12
 * Time: 7:00 PM
 */
public interface Service {

    /**
     * This method executes the operations using the parameter
     * and provides a result instance containing the results
     * @param parameter
     * @return an instance of Result
     */
    public Result executeService(Parameter<String> parameter);
}