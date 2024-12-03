package com.facebook.stetho.inspector.jsonrpc.protocol;

import android.annotation.SuppressLint;
import com.facebook.stetho.json.annotation.JsonProperty;
import org.json.b;

@SuppressLint({"UsingDefaultJsonDeserializer", "EmptyJsonPropertyUse"})
public class JsonRpcEvent {
    @JsonProperty(required = true)
    public String method;
    @JsonProperty
    public b params;

    public JsonRpcEvent() {
    }

    public JsonRpcEvent(String str, b bVar) {
        this.method = str;
        this.params = bVar;
    }
}
