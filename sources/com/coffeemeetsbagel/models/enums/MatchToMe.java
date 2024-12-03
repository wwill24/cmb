package com.coffeemeetsbagel.models.enums;

public enum MatchToMe {
    OTHER("other"),
    MY_TYPE("my_type");
    
    private final String value;

    private MatchToMe(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
