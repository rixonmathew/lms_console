package com.rixon.lms_console.service;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import org.jetbrains.annotations.Nullable;

/**
 * This interface represents the services for performing operations
 * User: rixon
 * Date: 8/17/12
 * Time: 7:00 PM
 */
public interface Service {

    /**
     * This method will invoke the given service and provide the result of the Service
     *
     * @param parameter the parameter object
     * @return an instance of Result
     */
    @Nullable
    public Result invoke(Parameter<String> parameter);
}