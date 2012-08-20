/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.*;

/**
 * This entity represents a record in the MEMBER table
 * User: 229921|Date: 8/20/12|Time: 9:03 AM
 */
@Entity
@Table(name="MEMBER")
@NamedQueries({
        @NamedQuery(name=MemberRecord.FIND_MEMBER_QUERY,query = "select x from MemberRecord x where x.emailId = :emailId and x.password = :password"),
        @NamedQuery(name=MemberRecord.ALL_MEMBERS_QUERY,query = "select x from MemberRecord x")
})
public class MemberRecord {

    public static final String FIND_MEMBER_QUERY = "find_member";
    public static final String ALL_MEMBERS_QUERY = "all_members";

    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String mobileNumber;
    private String postalAddress;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "member_id_gen")
    @SequenceGenerator(name="member_id_gen",sequenceName = "member_id_seq",allocationSize = 1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="EMAIL_ID")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name="MOBILE_NUMBER")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Column(name="POSTAL_ADDRESS")
    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
