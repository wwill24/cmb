package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.b;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcRequest {
    @JsonProperty

    /* renamed from: id  reason: collision with root package name */
    public Long f37933id;
    @JsonProperty(required = true)
    public String method;
    @JsonProperty
    public b params;

    public JsonRpcRequest() {
    }

    public JsonRpcRequest(Long l10, String str, b bVar) {
        this.f37933id = l10;
        this.method = str;
        this.params = bVar;
    }
}
