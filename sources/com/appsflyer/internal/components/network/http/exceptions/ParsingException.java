package com.appsflyer.internal.components.network.http.exceptions;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFc1dSDK;
import java.io.IOException;

public class ParsingException extends IOException {
    @NonNull
    private final AFc1dSDK<String> values;

    public ParsingException(String str, Throwable th2, @NonNull AFc1dSDK<String> aFc1dSDK) {
        super(str, th2);
        this.values = aFc1dSDK;
    }

    @NonNull
    public AFc1dSDK<String> getRawResponse() {
        return this.values;
    }
}
