/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.service;/**
 *
 * User: rixon|Date: 9/3/12|Time: 4:42 PM
 */

import com.rixon.lms_console.command.CommandTestUtil;
import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.operation.OperationTypes;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.facade.ServiceFacade;
import com.rixon.lms_console.facade.ServiceFacadeFactory;
import com.rixon.lms_console.service.Service;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.table.TableModel;

import static org.junit.Assert.*;

public class ServiceTest {

    ServiceFacade facade;

    @Before
    public void setup() {
        System.setProperty(ServiceFacadeFactory.LMS_MODE, ServiceFacadeFactory.REAL);
        facade = ServiceFacadeFactory.serviceFacade();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHelpServiceWitNoParameters() {
        Service helpService = facade.serviceForOperation(OperationTypes.HELP);
        Parameter<String> parameter = CommandTestUtil.parameterWithString(null);
        Result helpResult = helpService.execute(parameter);
        assertNotNull(helpResult);
        TableModel tableModel = helpResult.getResultsTable();
        final int expectedCount = 8;
        assertEquals("Count is not same", expectedCount, tableModel.getRowCount());
    }

    @Test
    public void testHelpServiceWitParameters() {
        Service helpService = facade.serviceForOperation(OperationTypes.HELP);
        Parameter<String> parameter = CommandTestUtil.parameterWithString("search");
        Result helpResult = helpService.execute(parameter);
        assertNotNull(helpResult);
        TableModel tableModel = helpResult.getResultsTable();
        final int expectedCount = 1;
        assertEquals("Count is not same", expectedCount, tableModel.getRowCount());
    }

    @Test
    public void testSearchServiceWithOneParameter() {
        Service searchService = facade.serviceForOperation(OperationTypes.SEARCH);
        Parameter<String> parameter = CommandTestUtil.parameterWithString("Charlie");
        Result searchResult = searchService.execute(parameter);
        assertNotNull(searchResult);
        TableModel tableModel = searchResult.getResultsTable();
        final int expectedColumnCount = 6;
        assertEquals("Column Count not as expected", expectedColumnCount,tableModel.getColumnCount());
        final int expectedCount = 26;
        assertTrue("Count should be more than expected count", tableModel.getRowCount() > expectedCount);
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testSearchServiceWithMultipleParameters() {
        Service searchService = facade.serviceForOperation(OperationTypes.SEARCH);
        Parameter<String> searchParameter = CommandTestUtil.parameterWithString("Charlie", "Goa");
        Result searchResult = searchService.execute(searchParameter);
        assertNotNull(searchResult);
        TableModel tableModel = searchResult.getResultsTable();
        final int expectedCount = 49;
        assertTrue("Count should be more than expected count", tableModel.getRowCount() > expectedCount);
    }

    @Test
    public void testIssueServiceWithWithValidItem() {
        Service issueService = facade.serviceForOperation(OperationTypes.ISSUE);
        Parameter<String> issueParameter = CommandTestUtil.parameterWithString("101", "1");

    }
}
