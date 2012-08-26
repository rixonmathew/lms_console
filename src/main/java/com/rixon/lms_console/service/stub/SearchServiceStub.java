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
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemPropertyValue;
import com.rixon.lms_console.dao.ItemType;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.service.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rixon.lms_console.util.PropertyConstants.*;
/**
 * This class implements the stub service for search operation
 * User: rixon|Date: 8/17/12|Time: 9:16 PM
 */
public class SearchServiceStub implements Service {
    @Override
    public Result execute(Parameter<String> parameter) {
        List<Item> items = new ArrayList<Item>();
        Item item = createMockItem("Book1", "A sample Book");
        Item item2 = createMockItem("Book2", "Sample book2");
        Item item3 = createMockItem("Book3", "Sample book3");
        items.add(item);
        items.add(item2);
        items.add(item3);
        return new SearchResult(items);
    }

    private Item createMockItem(String name, String description) {
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        itemBuilder.setName(name);
        itemBuilder.setDescription(description);
        ItemType.ItemTypeBuilder itemTypeBuilder = new ItemType.ItemTypeBuilder();
        ItemType itemType=itemTypeBuilder.setType("BOOK").setDescription("Book").createItemType();
        itemBuilder.setItemType(itemType);
        Property.PropertyBuilder propertyBuilder = new Property.PropertyBuilder();
        Property isbn = propertyBuilder.setName(ISBN).setDescription("ISBN").createProperty();
        ItemPropertyValue.ItemPropertyValueBuilder propertyValueBuilder = new ItemPropertyValue.ItemPropertyValueBuilder();
        ItemPropertyValue isbnPropertyValue = propertyValueBuilder.setProperty(isbn).setPropertyValue("1123123123").createItemPropertyValue();
        Property author = propertyBuilder.setName(AUTHOR).setDescription("Author").createProperty();
        ItemPropertyValue authorPropertyValue = propertyValueBuilder.setProperty(author).setPropertyValue("Thomas Edison").createItemPropertyValue();
        Property publishedDate = propertyBuilder.setName(PUBLISHED_DATE).setDescription("Published Date").createProperty();
        ItemPropertyValue publishedDatePropertyValue = propertyValueBuilder.setProperty(publishedDate).setPropertyValue("01/01/2010").createItemPropertyValue();
        Map<Property,ItemPropertyValue> properties = new HashMap<Property,ItemPropertyValue>();
        properties.put(isbn,isbnPropertyValue);
        properties.put(author,authorPropertyValue);
        properties.put(publishedDate,publishedDatePropertyValue);
        itemBuilder.setItemProperties(properties);
        return itemBuilder.createItem();
    }

}
