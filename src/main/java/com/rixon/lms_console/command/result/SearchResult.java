package com.rixon.lms_console.command.result;

import com.rixon.lms_console.domain.Book;

import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents the search results for books
 * User: rixon|Date: 8/17/12|Time: 6:29 PM
 */

public class SearchResult extends AbstractResult {

    public SearchResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new SearchTableModel(searchItems);
    }

    class SearchTableModel extends AbstractResultTableModel{

        protected SearchTableModel(List results) {
            super(results);
        }

        protected void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0,"isbn");
            headerNames.put(1,"Title");
            headerNames.put(2,"Author");
            headerNames.put(3,"Publisher");
            headerNames.put(4,"Published Date");
        }

        protected Object getCellValueAt(int rowIndex,int columnIndex){
          Book book = ((List<Book>)results).get(rowIndex);
            Object cellValue = null;
            switch (columnIndex){
                case 0:
                    cellValue = book.getIsbn();
                    break;
                case 1:
                    cellValue = book.getTitle();
                    break;
                case 2:
                    cellValue = book.getAuthor();
                    break;
                case 3:
                    cellValue = book.getPublisher();
                    break;
                case 4:
                    cellValue = book.getReleaseDate();
                    break;
            }
            return cellValue;
        }
    }
}
