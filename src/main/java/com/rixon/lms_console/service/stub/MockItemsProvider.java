/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.service.stub;

import com.rixon.lms_console.business.ItemTypeProvider;
import com.rixon.lms_console.business.PropertyProvider;
import com.rixon.lms_console.dao.Item;
import com.rixon.lms_console.dao.ItemType;
import com.rixon.lms_console.dao.Property;
import com.rixon.lms_console.dao.PropertyValue;

import java.util.HashMap;
import java.util.Map;

import static com.rixon.lms_console.util.Constants.*;

/**
 * Created with IntelliJ IDEA.
 * User: rixonmathew
 * Date: 05/10/12
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class MockItemsProvider {

    public static Item createMockItem(String name, String description) {
        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();
        itemBuilder.setName(name);
        itemBuilder.setDescription(description);
        ItemType itemType = ItemTypeProvider.getItemType(BOOK);
        itemBuilder.setItemType(itemType);
        Property isbn = PropertyProvider.getProperty(ISBN);
        PropertyValue.PropertyValueBuilder propertyValueBuilder = new PropertyValue.PropertyValueBuilder();
        PropertyValue isbnPropertyValue = propertyValueBuilder.setProperty(isbn).setPropertyValue("1123123123").createPropertyValue();
        Property author = PropertyProvider.getProperty(AUTHOR);
        PropertyValue authorPropertyValue = propertyValueBuilder.setProperty(author).setPropertyValue("Thomas Edison").createPropertyValue();
        Property publisher = PropertyProvider.getProperty(PUBLISHER);
        PropertyValue publisherPropertyValue = propertyValueBuilder.setProperty(publisher).setPropertyValue("Free Publishers").createPropertyValue();
        Property publishedDate = PropertyProvider.getProperty(PUBLISHED_DATE);
        PropertyValue publishedDatePropertyValue = propertyValueBuilder.setProperty(publishedDate).setPropertyValue("01/01/2010").createPropertyValue();
        Map<Property, PropertyValue> properties = new HashMap<Property, PropertyValue>();
        properties.put(isbn, isbnPropertyValue);
        properties.put(author, authorPropertyValue);
        properties.put(publisher, publisherPropertyValue);
        properties.put(publishedDate, publishedDatePropertyValue);
        itemBuilder.setItemProperties(properties);
        return itemBuilder.createItem();
    }
}
