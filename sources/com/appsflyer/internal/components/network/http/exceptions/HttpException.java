package com.appsflyer.internal.components.network.http.exceptions;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFc1jSDK;
import java.io.IOException;

public class HttpException extends IOException {
    private final AFc1jSDK AFInAppEventType;

    public HttpException(@NonNull Throwable th2, @NonNull AFc1jSDK aFc1jSDK) {
        super(th2.getMessage(), th2);
        this.AFInAppEventType = aFc1jSDK;
    }

    @NonNull
    public AFc1jSDK getMetrics() {
        return this.AFInAppEventType;
    }
}
