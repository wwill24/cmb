package com.clevertap.android.sdk.pushnotification;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.pushnotification.PushConstants;

public interface b {
    int getPlatform();

    @NonNull
    PushConstants.PushType getPushType();

    boolean isAvailable();

    boolean isSupported();

    int minSDKSupportVersionCode();

    void requestToken();
}
