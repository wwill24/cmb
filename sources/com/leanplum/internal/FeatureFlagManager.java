package com.leanplum.internal;

import java.util.HashSet;
import java.util.Set;

public class FeatureFlagManager {
    public static final String FEATURE_FLAG_REQUEST_REFACTOR = "request_refactor";
    public static final FeatureFlagManager INSTANCE = new FeatureFlagManager();
    private Set<String> enabledFeatureFlags = new HashSet();

    FeatureFlagManager() {
    }

    public Boolean isFeatureFlagEnabled(String str) {
        return Boolean.valueOf(this.enabledFeatureFlags.contains(str));
    }

    public void setEnabledFeatureFlags(Set<String> set) {
        this.enabledFeatureFlags = set;
    }
}
