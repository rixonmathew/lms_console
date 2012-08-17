package com.rixon.lms_console.command.result;

import com.rixon.lms_console.domain.Book;
import javax.swing.table.AbstractTableModel;


import javax.swing.table.TableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the search results for books
 * User: 229921
 * Date: 8/17/12
 * Time: 6:29 PM
 */

public class SearchBookResult extends AbstractResult {

    public SearchBookResult(List results) {
        super(results);
    }

    @Override
    protected TableModel convertListToModel(List searchItems) {
        return new BookTableModel(searchItems);
    }

    class BookTableModel extends AbstractTableModel{

        private Map<Integer,String> headerNames;
        private List<Book> books;

        BookTableModel(List<Book> books) {
            this.books = books;
            initHeader();
        }

        private void initHeader() {
            headerNames = new HashMap<Integer, String>();
            headerNames.put(0,"isbn");
            headerNames.put(1,"Title");
            headerNames.put(2,"Author");
            headerNames.put(3,"Publisher");
            headerNames.put(4,"Published Date");
        }

        @Override
        public int getRowCount() {
            return books.size();
        }

        @Override
        public int getColumnCount() {
            return headerNames.values().size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Book book = null; //TODO null object pattern
            if (rowIndex<0|| rowIndex>books.size()||
                columnIndex<0||columnIndex>headerNames.values().size())
                return book;
            book = books.get(rowIndex);
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
