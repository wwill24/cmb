package com.appsflyer.internal.components.network.http;

import androidx.annotation.NonNull;
import java.util.List;

public interface ResponseNetwork<Body> {
    @NonNull
    Body getBody();

    List<String> getHeaderField(String str);

    int getStatusCode();

    boolean isSuccessful();
}
