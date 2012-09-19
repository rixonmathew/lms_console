/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import com.rixon.lms_console.dao.Member;

import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the results for the list command
 * User: rixon|Date: 9/19/12|Time: 9:07 PM
 */
public class ListResult extends AbstractResult {
    public ListResult(List results) {
        super(results);
    }

    @Override
    public String getFormatStringForHeader(int columnIndex) {
        if (columnIndex==3) {
            return "%1$40s |";
        }
        return super.getFormatStringForHeader(columnIndex);
    }

    @Override
    public String getFormatStringForRecord(int columnIndex) {
        if (columnIndex==3) {
            return "%1$40s |";
        }
        return super.getFormatStringForRecord(columnIndex);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new ListResultTableModel(searchItems);
    }

    class ListResultTableModel extends AbstractResultTableModel {
        protected ListResultTableModel(List results) {
            super(results);
        }

        @Override
        protected void initHeader() {
            headerNames = new HashMap<Integer,String>();
            headerNames.put(0,"ID");
            headerNames.put(1,"First Name");
            headerNames.put(2,"Last Name");
            headerNames.put(3,"email id");
        }

        @Override
        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            Member member = ((List<Member>) results).get(rowIndex);
            String cellValue="";
            switch (columnIndex) {
                case 0:
                    cellValue= String.valueOf(member.getId());
                    break;
                case 1:
                    cellValue = member.getFirstName();
                    break;
                case 2:
                    cellValue = member.getLastName();
                    break;
                case 3:
                    cellValue = member.getEmailID();
                    break;
            }
           return cellValue;
        }
    }
}
