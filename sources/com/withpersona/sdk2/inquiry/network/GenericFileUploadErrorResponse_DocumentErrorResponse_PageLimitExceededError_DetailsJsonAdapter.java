package com.withpersona.sdk2.inquiry.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GenericFileUploadErrorResponse_DocumentErrorResponse_PageLimitExceededError_DetailsJsonAdapter extends h<GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError.Details> {
    private final h<Integer> intAdapter;
    private final JsonReader.b options;

    public GenericFileUploadErrorResponse_DocumentErrorResponse_PageLimitExceededError_DetailsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("page_limit");
        j.f(a10, "of(\"page_limit\")");
        this.options = a10;
        h<Integer> f10 = sVar.f(Integer.TYPE, n0.e(), "pageLimit");
        j.f(f10, "moshi.adapter(Int::class… emptySet(), \"pageLimit\")");
        this.intAdapter = f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(105);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError.Details");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError.Details fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Integer num = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (num = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("pageLimit", "page_limit", jsonReader);
                j.f(x10, "unexpectedNull(\"pageLimi…    \"page_limit\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (num != null) {
            return new GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError.Details(num.intValue());
        }
        JsonDataException o10 = c.o("pageLimit", "page_limit", jsonReader);
        j.f(o10, "missingProperty(\"pageLimit\", \"page_limit\", reader)");
        throw o10;
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError.Details details) {
        j.g(qVar, "writer");
        if (details != null) {
            qVar.c();
            qVar.u("page_limit");
            this.intAdapter.toJson(qVar, Integer.valueOf(details.getPageLimit()));
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
