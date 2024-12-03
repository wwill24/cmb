package com.clevertap.android.sdk.events;

public enum EventGroup {
    REGULAR(""),
    PUSH_NOTIFICATION_VIEWED("-spiky");
    
    public final String httpResource;

    private EventGroup(String str) {
        this.httpResource = str;
    }
}
