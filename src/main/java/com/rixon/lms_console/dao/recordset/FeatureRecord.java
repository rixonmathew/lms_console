/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.recordset;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * This entity represents a record in the CATEGORY table
 *  User: rixon|Date: 8/22/12|Time: 1:42 PM
 */
@Entity
@Table(name = "CATEGORY")
@NamedQuery(name = CategoryRecord.ALL_CATEGORIES_QUERY,query = "select category from CategoryRecord category")
public class FeatureRecord {

}
