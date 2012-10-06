/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.result;

import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.PropertyValue;

import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the results of the list-item command
 * User: rixon|Date: 10/2/12|Time: 1:45 PM
 */
public class ListItemResult extends AbstractResult {

    public ListItemResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new ListItemResultTableModel(searchItems);
    }

    /*
    class ListItemResultTableModel extends AbstractResultTableModel{

        protected ListItemResultTableModel(List results) {
            super(results);
        }

        @Override
        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            int counter = 0;
            headerNames.put(counter++,"ID");
            headerNames.put(counter++,"Name");
            List<Property> properties = PropertyProvider.getPropertiesForCategory("ITEM_PROPERTY");
            for (Property property:properties) {
                headerNames.put(counter++,property.getName());
            }
        }

        @Override
        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            Item item = ((List<Item>)results).get(rowIndex);
            String propertyValue = null;
            switch (columnIndex) {
                case 0:
                    propertyValue = String.valueOf(item.getId());
                    break;
                case 1:
                    propertyValue = item.getName();
                    break;
                default:
                    String propertyName = headerNames.get(columnIndex);
                    Property property =  PropertyProvider.getProperty(propertyName);
                    PropertyValue propertyValueForItem =  item.getItemPropertyValue(property);
                    if (propertyValueForItem!=null) {
                        propertyValue = propertyValueForItem.getPropertyValue();
                    } else {
                        propertyValue = "";
                    }
                    break;
            }
            return propertyValue;
        }
    }*/

    class ListItemResultTableModel extends AbstractMapBasedTableModel {

        protected ListItemResultTableModel(List resultList) {
            super(resultList);
        }

        @Override
        protected void transposeResultsToMap(List resultList) {
            Item item = (Item)resultList.get(0);
            if (!item.isValidItem()) {
               setResultsForInvalidItem();
               return;

            }
            int counter = 0;
            rowNames.put(counter,"ID");
            results.put(counter++,String.valueOf(item.getId()));
            rowNames.put(counter,"Name");
            results.put(counter++,item.getName());
            rowNames.put(counter,"Description");
            results.put(counter++,item.getDescription());
            List<Property> propertiesForItem = PropertyProvider.getPropertiesForCategory("ITEM_PROPERTY");
            for (Property property:propertiesForItem) {
                PropertyValue propertyValue = item.getItemPropertyValue(property);
                rowNames.put(counter,property.getName());
                results.put(counter++,propertyValue.getPropertyValue());
            }
        }

        private void setResultsForInvalidItem() {
            headerNames.clear();
            headerNames.put(0,"Message");
            rowNames.put(0,"No results found!!");
            results.put(0,"");
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            String value ="";
            switch (columnIndex) {
                case 0:
                    value = rowNames.get(rowIndex);
                    break;
                case 1:
                    value = results.get(rowIndex);
                    break;
            }
            return value;
        }
    }
}
