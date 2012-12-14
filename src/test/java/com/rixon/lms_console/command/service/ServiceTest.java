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
        facade = ServiceFacadeFactory.serviceFacade();
    }

    @After
    public void tearDown() {
        facade = null;
    }

    @Test
    public void testHelpServiceWitNoParameters() {
        Service helpService = facade.serviceForOperation(OperationTypes.HELP);
        Parameter<String> parameter = CommandTestUtil.parameterWithString(null);
        Result helpResult = helpService.invoke(parameter);
        assertNotNull(helpResult);
        TableModel tableModel = helpResult.getResultsTable();
        final int expectedCount = 9;
        assertEquals("Count is not same", expectedCount, tableModel.getRowCount());
    }

    @Test
    public void testHelpServiceWitParameters() {
        Service helpService = facade.serviceForOperation(OperationTypes.HELP);
        Parameter<String> parameter = CommandTestUtil.parameterWithString("search");
        Result helpResult = helpService.invoke(parameter);
        assertNotNull(helpResult);
        TableModel tableModel = helpResult.getResultsTable();
        final int expectedCount = 1;
        assertEquals("Count is not same", expectedCount, tableModel.getRowCount());
    }

    @Test
    public void testSearchServiceWithOneParameter() {
        Service searchService = facade.serviceForOperation(OperationTypes.SEARCH);
        Parameter<String> parameter = CommandTestUtil.parameterWithString("Charlie");
        Result searchResult = searchService.invoke(parameter);
        assertNotNull(searchResult);
        TableModel tableModel = searchResult.getResultsTable();
        final int expectedColumnCount = 6;
        assertEquals("Column Count not as expected", expectedColumnCount, tableModel.getColumnCount());
        final int expectedCount = 26;
        assertTrue("Count should be more than expected count", tableModel.getRowCount() > expectedCount);
        CommandTestUtil.assertCellValues(tableModel);
    }

    @Test
    public void testSearchServiceWithMultipleParameters() {
        Service searchService = facade.serviceForOperation(OperationTypes.SEARCH);
        Parameter<String> searchParameter = CommandTestUtil.parameterWithString("Charlie", "Goa");
        Result searchResult = searchService.invoke(searchParameter);
        assertNotNull(searchResult);
        TableModel tableModel = searchResult.getResultsTable();
        assertNotNull(tableModel);
        final int expectedCount = 49;
        assertTrue("Count should be more than expected count", tableModel.getRowCount() > expectedCount);
    }

    @Test
    public void testReserveServiceWithValidParameters() {
        Service reserveService = facade.serviceForOperation(OperationTypes.RESERVE);
        Parameter<String> reserveParameter = CommandTestUtil.parameterWithString("27240", "1");
        Result reserveResult = reserveService.invoke(reserveParameter);
        assertNotNull(reserveResult);
        TableModel tableModel = reserveResult.getResultsTable();
        final int expectedRowCount = 1;
        assertEquals("Count of rows not as expected", tableModel.getRowCount(), expectedRowCount);
        final String expectedMessage = "Item Reserved Successfully";
        String actualMessage = (String) tableModel.getValueAt(0, 0);
        assertEquals("Reservation message not as expected", expectedMessage, actualMessage);
    }

    @Test
    public void testReserveServiceForDamagedItemInstance() {
        final String instanceID = "27241";
        final String userID = "1";
        Service reserveService = facade.serviceForOperation(OperationTypes.RESERVE);
        Parameter<String> reserveParameter = CommandTestUtil.parameterWithString(instanceID, userID);
        Result reserveResult = reserveService.invoke(reserveParameter);
        assertNotNull(reserveResult);
        TableModel tableModel = reserveResult.getResultsTable();
        final int expectedRowCount = 1;
        assertEquals("Count of rows not as expected", tableModel.getRowCount(), expectedRowCount);
        final String expectedMessage = "Item cannot be reserved as it is damaged";
        String actualMessage = (String) tableModel.getValueAt(0, 0);
        assertEquals("Reservation message not as expected", expectedMessage, actualMessage);

    }
}
