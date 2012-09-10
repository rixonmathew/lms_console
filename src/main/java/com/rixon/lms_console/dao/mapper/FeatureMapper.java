/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.dao.mapper;

import com.rixon.lms_console.dao.Feature;
import com.rixon.lms_console.dao.recordset.FeatureRecord;
import org.jetbrains.annotations.NotNull;

/**
 * User: rixon|Date: 9/2/12|Time: 11:06 AM
 */
public class FeatureMapper {
    public static Feature mapToFeature(@NotNull FeatureRecord featureRecord) {
        Feature.FeatureBuilder featureBuilder = new Feature.FeatureBuilder();
        featureBuilder.setName(featureRecord.getName());
        featureBuilder.setDescription(featureRecord.getDescription());
        return featureBuilder.createFeature();
    }
}
