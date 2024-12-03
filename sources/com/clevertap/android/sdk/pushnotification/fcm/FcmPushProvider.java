package com.clevertap.android.sdk.pushnotification.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.b;
import com.clevertap.android.sdk.pushnotification.c;

@SuppressLint({"unused"})
public class FcmPushProvider implements b {
    private d handler;

    @SuppressLint({"unused"})
    public FcmPushProvider(c cVar, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.handler = new c(cVar, context, cleverTapInstanceConfig);
    }

    public int getPlatform() {
        return 1;
    }

    @NonNull
    public PushConstants.PushType getPushType() {
        return this.handler.getPushType();
    }

    public boolean isAvailable() {
        return this.handler.isAvailable();
    }

    public boolean isSupported() {
        return this.handler.isSupported();
    }

    public int minSDKSupportVersionCode() {
        return 0;
    }

    public void requestToken() {
        this.handler.requestToken();
    }

    /* access modifiers changed from: package-private */
    public void setHandler(d dVar) {
        this.handler = dVar;
    }
}
