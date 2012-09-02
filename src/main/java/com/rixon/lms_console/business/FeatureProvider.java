/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.business;

import com.rixon.lms_console.dao.Feature;
import com.rixon.lms_console.dao.mapper.FeatureMapper;
import com.rixon.lms_console.dao.recordset.FeatureRecord;
import com.rixon.lms_console.dao.recordset.RoleRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to get all the features available in the system
 * User: rixon|Date: 9/2/12|Time: 10:46 AM
 */
public class FeatureProvider {

    private static Map<String, Feature> featureMap;
    private static Map<String, List<Feature>> featuresForRoleMap;

    static {
        loadFeatureMap();
    }

    private static void loadFeatureMap() {
        Store store = SimpleStore.getInstance();
        featureMap = new HashMap<String, Feature>();
        List<FeatureRecord> featureRecords = store.allFeatures();
        for (FeatureRecord featureRecord : featureRecords) {
            Feature feature = FeatureMapper.mapToFeature(featureRecord);
            featureMap.put(feature.getName(), feature);
        }

        featuresForRoleMap = new HashMap<String, List<Feature>>();
        List<RoleRecord> roleRecords = store.allRoles();
        for (RoleRecord roleRecord : roleRecords) {
            List<FeatureRecord> featuresForRole = store.featuresForRole(roleRecord.getRole());
            List<Feature> features = new ArrayList<Feature>();
            for (FeatureRecord featureRecord : featuresForRole) {
                features.add(FeatureMapper.mapToFeature(featureRecord));
            }
            featuresForRoleMap.put(roleRecord.getRole(), features);
        }
    }

    public static Feature featureForName(String name) {
        Feature feature = featureMap.get(name);
        if (feature == null) {
            throw new IllegalArgumentException("Invalid feature name" + name);
        }
        return feature;
    }

    public static List<Feature> featureForRole(String roleName) {
        List<Feature> features = featuresForRoleMap.get(roleName);
        if (features == null) {
            throw new IllegalArgumentException("Invalid role name" + roleName);
        }
        return features;
    }
}
