/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.dao.Category;
import com.rixon.lms_console.dao.mapper.CategoryMapper;
import com.rixon.lms_console.dao.recordset.CategoryRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will provide a Category Object against the input key
 * User: rixon|Date: 8/26/12|Time: 4:16 PM
 */
public class CategoryProvider {

    private static Map<String,Category> categoryMap;

    static {
        loadCategoryMap();
    }

    private static void loadCategoryMap() {
        categoryMap = new HashMap<String,Category>();
        List<CategoryRecord> categoryRecordList = SimpleStore.getInstance().allCategories();
        for(CategoryRecord categoryRecord:categoryRecordList) {
            Category category = CategoryMapper.mapToCategory(categoryRecord);
            categoryMap.put(category.getName(),category);
        }
    }

    public static Category getCategory(String categoryName){
        Category category = categoryMap.get(categoryName);
        if (category==null) {
            throw new IllegalArgumentException("Invalid category name :"+categoryName);
        }
        return category;
    }
}
