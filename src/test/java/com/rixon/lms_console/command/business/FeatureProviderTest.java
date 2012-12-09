/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.business;

import com.rixon.lms_console.business.FeatureProvider;
import com.rixon.lms_console.dao.Feature;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * User: rixon|Date: 9/2/12|Time: 10:36 AM
 */
public class FeatureProviderTest {

    @Test
    public void testValidFeature() {
        final String expectedFeatureName = "SEARCH";
        Feature feature = FeatureProvider.featureForName(expectedFeatureName);
        assertNotNull(feature);
        assertThat("Feature name not as expected", expectedFeatureName, equalTo(feature.getName()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFeature() {
        final String featureName = "DELETE";
        FeatureProvider.featureForName(featureName);
        fail("An exception should have been raised by now");
    }

    @Test
    public void testFeatureForRole() {
        final String roleName = "ADMIN";
        final int expectedFeatureCount = 5;
        List<Feature> featureList = FeatureProvider.featureForRole(roleName);
        assertNotNull(featureList);
        assertEquals("Count of features is not as expected", expectedFeatureCount, featureList.size());
    }
}
