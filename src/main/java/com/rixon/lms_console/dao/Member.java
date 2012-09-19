/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao;

/**
 * This class represents the domain entity Member
 * User: rixon|Date: 9/19/12|Time: 9:14 PM
 */
public class Member {

    private long id;
    private String firstName;
    private String lastName;
    private String emailID;
    private String password;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getPassword() {
        return password;
    }

    Member(long id, String firstName, String lastName, String emailID, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.password = password;
    }

    public static class MemberBuilder {
        private long id;
        private String firstName;
        private String lastName;
        private String emailID;
        private String password;

        public MemberBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public MemberBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public MemberBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public MemberBuilder setEmailID(String emailID) {
            this.emailID = emailID;
            return this;
        }

        public MemberBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Member createMember() {
            return new Member(id, firstName, lastName, emailID, password);
        }
    }
}
