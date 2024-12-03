package com.coffeemeetsbagel.likes_you.presentation;

public enum MainGroups {
    ALL("all"),
    MY_TYPE("my_type");
    
    private final String key;

    private MainGroups(String str) {
        this.key = str;
    }

    public final String b() {
        return this.key;
    }
}
