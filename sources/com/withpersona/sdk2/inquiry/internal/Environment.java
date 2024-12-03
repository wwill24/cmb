package com.withpersona.sdk2.inquiry.internal;

public enum Environment {
    PRODUCTION("production"),
    SANDBOX("sandbox");
    
    private final String lowercase;

    private Environment(String str) {
        this.lowercase = str;
    }

    public final String b() {
        return this.lowercase;
    }
}
