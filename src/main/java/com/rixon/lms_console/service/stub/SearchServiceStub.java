/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.SearchResult;
import com.rixon.lms_console.domain.Book;
import com.rixon.lms_console.service.Service;
import com.rixon.lms_console.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the stub service for search operation
 * User: rixon|Date: 8/17/12|Time: 9:16 PM
 */
public class SearchServiceStub implements Service {
    @Override
    public Result executeService(Parameter<String> parameter) {
        Book book1 = createBook("11231","Test Book","Author1","Some publisher","01/01/2000");
        Book book2 = createBook("22231","Test Book2","Author2","Some publisher","01/01/2001");
        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        return new SearchResult(books);
    }

    private Book createBook(String isbn,String title,String author,String publisher,String releaseDate) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setReleaseDate(DateUtil.getFormattedDate(releaseDate));
        return book;
    }

}
