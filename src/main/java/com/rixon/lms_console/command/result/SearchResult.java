package com.rixon.lms_console.command.result;

import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.dao.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;

import static com.rixon.lms_console.util.Constants.*;

/**
 * This class represents the search results for books
 * User: rixon|Date: 8/17/12|Time: 6:29 PM
 */

public class SearchResult extends AbstractResult {

    public SearchResult(List results) {
        super(results);
    }

    @NotNull
    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new SearchTableModel(searchItems);
    }

    class SearchTableModel extends AbstractResultTableModel {

        protected SearchTableModel(List results) {
            super(results);
        }

        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0, "isbn");
            headerNames.put(1, "Title");
            headerNames.put(2, "Author");
            headerNames.put(3, "Publisher");
            headerNames.put(4, "Published Date");
        }

        @Nullable
        protected Object getCellValueAt(int rowIndex, int columnIndex) {
            Item item = ((List<Item>) results).get(rowIndex);

            Object cellValue = null;
            switch (columnIndex) {
                case 0:
                    cellValue = item.getItemPropertyValue(PropertyProvider.getProperty(ISBN)).getPropertyValue();
                    break;
                case 1:
                    cellValue = item.getName();
                    break;
                case 2:
                    cellValue = item.getItemPropertyValue(PropertyProvider.getProperty(AUTHOR)).getPropertyValue();
                    break;
                case 3:
                    cellValue = item.getItemPropertyValue(PropertyProvider.getProperty(PUBLISHER)).getPropertyValue();
                    break;
                case 4:
                    cellValue = item.getItemPropertyValue(PropertyProvider.getProperty(PUBLISHED_DATE)).getPropertyValue();
                    break;
            }
            return cellValue;
        }
    }
}
