/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.mock;

import com.rixon.lms_console.command.Parameter;
import com.rixon.lms_console.command.result.Result;
import com.rixon.lms_console.command.result.SearchBookResult;
import com.rixon.lms_console.domain.Book;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 229921|Date: 8/17/12|Time: 9:16 PM
 */
public class SearchServiceMock implements Service {
    @Override
    public Result executeService(Parameter<String> parameter) {
        Book book1 = new Book();
        book1.setIsbn("1123");
        Book book2 = new Book();
        book2.setIsbn("1124");
        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        SearchBookResult searchBookResult = new SearchBookResult(books);
        return searchBookResult;
    }
}
