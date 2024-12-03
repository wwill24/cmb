package com.coffeemeetsbagel.models.enums;

public enum Importance {
    NO_PREFERENCE(0),
    SOMEWHAT(1),
    VERY(2);
    
    private final int mImportanceId;

    private Importance(int i10) {
        this.mImportanceId = i10;
    }

    public static Importance fromId(int i10) {
        for (Importance importance : values()) {
            if (importance.mImportanceId == i10) {
                return importance;
            }
        }
        throw new IllegalArgumentException("Could not find Importance with id " + i10);
    }
}
