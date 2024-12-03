package com.coffeemeetsbagel.features.models;

public class FeatureFlag {
    private String key;
    private Boolean overrideValue;
    private boolean value;

    public FeatureFlag(String str, boolean z10, Boolean bool) {
        this.key = str;
        this.value = z10;
        this.overrideValue = bool;
    }

    public String getKey() {
        return this.key;
    }

    public Boolean getOverrideValue() {
        return this.overrideValue;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setOverrideValue(Boolean bool) {
        this.overrideValue = bool;
    }
}
