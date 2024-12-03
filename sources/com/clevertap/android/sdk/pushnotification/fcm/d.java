package com.clevertap.android.sdk.pushnotification.fcm;

import com.clevertap.android.sdk.pushnotification.PushConstants;

public interface d {
    PushConstants.PushType getPushType();

    boolean isAvailable();

    boolean isSupported();

    void requestToken();
}
