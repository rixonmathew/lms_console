package com.rixon.lms_console.command;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: 229921
 * Date: 8/1/12
 * Time: 8:01 PM
 * This interface represents the parameters that is required for the command to
 * execute the operation
 */
public interface Parameter<TYPE> {

    /**
     * This method will return all the parmeters of a particular type
     * @return collection of parameters
     */
    public Collection<TYPE> getParameters();
}
