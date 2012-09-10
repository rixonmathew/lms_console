/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

/**
 * This class is used to hold the property value for a given property.
 * All property values are stored as String
 * User: rixon|Date: 8/25/12|Time: 8:05 PM
 */
public class PropertyValue {

    private final Property property;
    private final String propertyValue;

    private PropertyValue(Property property,
                          String propertyValue) {
        this.property = property;
        this.propertyValue = propertyValue;
    }

    public Property getProperty() {
        return property;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "property=" + property +
                ", propertyValue='" + propertyValue + '\'' +
                '}';
    }

    public static class PropertyValueBuilder {
        private Property property;
        private String propertyValue;

        public PropertyValueBuilder setProperty(Property property) {
            this.property = property;
            return this;
        }

        public PropertyValueBuilder setPropertyValue(String propertyValue) {
            this.propertyValue = propertyValue;
            return this;
        }

        public PropertyValue createPropertyValue() {
            return new PropertyValue(property, propertyValue);
        }
    }


}
