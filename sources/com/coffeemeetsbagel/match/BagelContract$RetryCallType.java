package com.coffeemeetsbagel.match;

public enum BagelContract$RetryCallType {
    PUT_ACTION("PUT_ACTION");
    
    final String internalTag;

    private BagelContract$RetryCallType(String str) {
        this.internalTag = str;
    }

    public String a() {
        return this.internalTag;
    }
}
