package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.h;
import kotlin.jvm.internal.j;

public final class JsonAdapterBinding<T> {
    private final Class<T> clazz;
    private final h<T> jsonAdapter;

    public JsonAdapterBinding(Class<T> cls, h<T> hVar) {
        j.g(cls, "clazz");
        j.g(hVar, "jsonAdapter");
        this.clazz = cls;
        this.jsonAdapter = hVar;
    }

    public final Class<T> getClazz() {
        return this.clazz;
    }

    public final h<T> getJsonAdapter() {
        return this.jsonAdapter;
    }
}
