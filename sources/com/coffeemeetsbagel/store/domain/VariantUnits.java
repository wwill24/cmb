package com.coffeemeetsbagel.store.domain;

public enum VariantUnits {
    WEEK("week"),
    MONTH("month");
    
    private final String unit;

    private VariantUnits(String str) {
        this.unit = str;
    }

    public final String b() {
        return this.unit;
    }
}
