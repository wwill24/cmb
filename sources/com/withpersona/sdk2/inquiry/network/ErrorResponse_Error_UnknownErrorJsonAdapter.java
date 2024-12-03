package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ErrorResponse_Error_UnknownErrorJsonAdapter extends h<ErrorResponse.Error.UnknownError> {
    private final h<String> nullableStringAdapter;
    private final JsonReader.b options;

    public ErrorResponse_Error_UnknownErrorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "originalCode");
        j.f(a10, "of(\"title\", \"originalCode\")");
        this.options = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"title\")");
        this.nullableStringAdapter = f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ErrorResponse.Error.UnknownError");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public ErrorResponse.Error.UnknownError fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.nullableStringAdapter.fromJson(jsonReader);
            } else if (L == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new ErrorResponse.Error.UnknownError(str, str2);
    }

    public void toJson(q qVar, ErrorResponse.Error.UnknownError unknownError) {
        j.g(qVar, "writer");
        if (unknownError != null) {
            qVar.c();
            qVar.u("title");
            this.nullableStringAdapter.toJson(qVar, unknownError.getTitle());
            qVar.u("originalCode");
            this.nullableStringAdapter.toJson(qVar, unknownError.getOriginalCode());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
