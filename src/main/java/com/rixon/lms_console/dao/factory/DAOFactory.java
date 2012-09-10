/*
 * Copyright (c) 2012. 
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com) 
 * This source is distributed as is without warranty of any kind. Please use this at your 
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.factory;

import com.rixon.lms_console.dao.LMSDao;
import com.rixon.lms_console.dao.LMSDaoSQL;
import org.jetbrains.annotations.Nullable;

/**
 * User: rixon|Date: 8/25/12|Time: 9:19 PM
 */
public class DAOFactory {

    private static final String DAO_MODE = "com.rixon.lms_console.dao_mode";
    private static final String SQL_MODE = "SQL";
    private static final String NOSQL_MODE = "NOSQL";

    @Nullable
    public static LMSDao lmsDao() {
        LMSDao lmsDao = null;
        String daoMode = System.getProperty(DAO_MODE);
        if (daoMode == null) {
            daoMode = SQL_MODE;
        }
        if (daoMode.equalsIgnoreCase(SQL_MODE)) {
            lmsDao = new LMSDaoSQL();
        } else if (daoMode.equalsIgnoreCase(NOSQL_MODE)) {

        }
        return lmsDao;
    }
}
