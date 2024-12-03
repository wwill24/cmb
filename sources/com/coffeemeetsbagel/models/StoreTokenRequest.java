package com.coffeemeetsbagel.models;

import lg.c;

public class StoreTokenRequest {
    @c("device_token")
    private final String deviceToken;

    public StoreTokenRequest(String str) {
        if (str != null) {
            this.deviceToken = str;
            return;
        }
        throw new NullPointerException("Null deviceToken");
    }

    @c("device_token")
    public String deviceToken() {
        return this.deviceToken;
    }
}
