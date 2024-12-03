package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import kotlin.jvm.internal.j;

public final class ErrorResponse$ErrorJsonAdapterFactory$create$1 extends h<ErrorResponse.Error> {
    private final h<ErrorResponse.Error> errorAdapter;

    ErrorResponse$ErrorJsonAdapterFactory$create$1(h<?> hVar) {
        j.e(hVar, "null cannot be cast to non-null type com.squareup.moshi.JsonAdapter<com.withpersona.sdk2.inquiry.network.ErrorResponse.Error>");
        this.errorAdapter = hVar;
    }

    public static /* synthetic */ void getErrorAdapter$annotations() {
    }

    public final h<ErrorResponse.Error> getErrorAdapter() {
        return this.errorAdapter;
    }

    public ErrorResponse.Error fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        JsonReader F = jsonReader.F();
        ErrorResponse.ErrorJsonAdapterFactory errorJsonAdapterFactory = ErrorResponse.ErrorJsonAdapterFactory.INSTANCE;
        j.f(F, "peeked");
        if (errorJsonAdapterFactory.hasLabel(F)) {
            return this.errorAdapter.fromJson(jsonReader);
        }
        return ErrorResponse.UnknownErrorAdapter.INSTANCE.fromJson(jsonReader);
    }

    public void toJson(q qVar, ErrorResponse.Error error) {
        j.g(qVar, "writer");
        this.errorAdapter.toJson(qVar, error);
    }
}
