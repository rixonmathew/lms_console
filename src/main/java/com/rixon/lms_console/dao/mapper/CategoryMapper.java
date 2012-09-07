/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Category;
import com.rixon.lms_console.dao.recordset.CategoryRecord;

/**
 * This class will map the CategoryRecord to Category entity
 * User: rixon|Date: 8/26/12|Time: 4:10 PM
 */
public class CategoryMapper {

    public static Category mapToCategory(CategoryRecord categoryRecord) {
        Category.CategoryBuilder categoryBuilder = new Category.CategoryBuilder();
        categoryBuilder.setName(categoryRecord.getName()).setDescription(categoryRecord.getDescription());
        return categoryBuilder.createCategory();
    }

    public static CategoryRecord mapToCategoryRecord(Category category) {
        CategoryRecord categoryRecord = new CategoryRecord();
        categoryRecord.setName(category.getName());
        categoryRecord.setDescription(category.getDescription());
        return categoryRecord;
    }
}


