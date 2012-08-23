package com.rixon.lms_console.command;

import java.util.Collection;

/**
 * This interface represents the parameters that is required for the command to
 * execute the operation
 * User: rixon|Date: 8/1/12|Time: 8:01 PM
 */
public interface Parameter<TYPE> {

    /**
     * This method will return all the parameters of a particular type
     * @return collection of parameters
     */
    public Collection<TYPE> getParameters();
}
