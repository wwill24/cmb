package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GenericFileUploadErrorResponse_DocumentErrorResponse_FileLimitExceededError_DetailsJsonAdapter extends h<GenericFileUploadErrorResponse.DocumentErrorResponse.FileLimitExceededError.Details> {
    private final JsonReader.b options;

    public GenericFileUploadErrorResponse_DocumentErrorResponse_FileLimitExceededError_DetailsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(new String[0]);
        j.f(a10, "of()");
        this.options = a10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(105);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse.DocumentErrorResponse.FileLimitExceededError.Details");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse.DocumentErrorResponse.FileLimitExceededError.Details fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        while (jsonReader.g()) {
            if (jsonReader.L(this.options) == -1) {
                jsonReader.S();
                jsonReader.Y();
            }
        }
        jsonReader.e();
        return new GenericFileUploadErrorResponse.DocumentErrorResponse.FileLimitExceededError.Details();
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse.DocumentErrorResponse.FileLimitExceededError.Details details) {
        j.g(qVar, "writer");
        if (details != null) {
            qVar.c();
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
