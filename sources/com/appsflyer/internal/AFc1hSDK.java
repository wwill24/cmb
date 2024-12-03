package com.appsflyer.internal;

import androidx.annotation.NonNull;
import org.json.JSONException;

public interface AFc1hSDK<ResponseType> {
    @NonNull
    ResponseType values(String str) throws JSONException;
}
