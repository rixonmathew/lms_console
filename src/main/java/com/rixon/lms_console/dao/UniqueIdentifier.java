/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

import java.util.UUID;

/**
 * This class is used to model the Unique identifier for all entities in the
 * system
 * User: rixon|Date: 8/25/12|Time: 8:14 PM
 */
public class UniqueIdentifier {

    private final String type;
    private final String value;

    private UniqueIdentifier(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "UniqueIdentifier{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static class UniqueIdentifierBuilder {
        private String type;
        private String value;

        public UniqueIdentifierBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public UniqueIdentifierBuilder setValue(String value) {
            this.value = value;
            return this;
        }

        public UniqueIdentifierBuilder generateUniqueValue() {
            this.value = UUID.randomUUID().toString();
            return this;
        }
        public UniqueIdentifier createUniqueIdentifier() {
            return new UniqueIdentifier(type, value);
        }
    }

}
