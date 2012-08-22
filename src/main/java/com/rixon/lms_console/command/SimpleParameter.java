package com.rixon.lms_console.command;

import java.util.Collection;
import java.util.List;

/**
 * This is a simple class that provides all the parameters required for the command
 * User: rixon|Date: 8/1/12|Time: 10:16 PM
 */
public class SimpleParameter implements Parameter<String> {

    List<String> parameters;


    public SimpleParameter(List<String> parameters) {
        this.parameters = parameters;
    }

    @Override
    public Collection<String> getParameters() {
        return parameters;
    }
}
