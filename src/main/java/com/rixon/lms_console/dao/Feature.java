/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

/**
 * This class is used to get the Feature available in the system
 * User: rixon|Date: 9/2/12|Time: 10:37 AM
 */
public class Feature {

    private final String name;
    private final String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private Feature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static class FeatureBuilder {
        private String name;
        private String description;

        public FeatureBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public FeatureBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Feature createFeature() {
            return new Feature(name, description);
        }
    }
}
