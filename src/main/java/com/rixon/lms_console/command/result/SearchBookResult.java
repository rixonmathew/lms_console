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
            headerNames.put(0,"ID");
            headerNames.put(1,"Type");
            headerNames.put(2,"Title");
            headerNames.put(3,"Author");
            headerNames.put(4,"Description");
            headerNames.put(5,"Published Date");
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
            switch (columnIndex){
                //TODO add implementation
            }
            return book.getIsbn();
        }
    }
}
