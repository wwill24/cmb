package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.b;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcResponse {
    @JsonProperty
    public b error;
    @JsonProperty(required = true)

    /* renamed from: id  reason: collision with root package name */
    public long f37934id;
    @JsonProperty
    public b result;
}
