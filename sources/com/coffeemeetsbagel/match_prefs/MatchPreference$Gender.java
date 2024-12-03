package com.coffeemeetsbagel.match_prefs;

public enum MatchPreference$Gender {
    MEN("Men"),
    WOMEN("Women"),
    EVERYONE("Everyone");
    
    private final String apiKey;

    private MatchPreference$Gender(String str) {
        this.apiKey = str;
    }

    public final String b() {
        return this.apiKey;
    }
}
