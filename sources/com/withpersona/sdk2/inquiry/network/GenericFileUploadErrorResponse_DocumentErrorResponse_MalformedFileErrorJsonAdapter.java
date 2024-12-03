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
import org.bouncycastle.i18n.ErrorBundle;

public final class GenericFileUploadErrorResponse_DocumentErrorResponse_MalformedFileErrorJsonAdapter extends h<GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError> {
    private final h<GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError.Details> detailsAdapter;
    private final JsonReader.b options;
    private final h<String> stringAdapter;

    public GenericFileUploadErrorResponse_DocumentErrorResponse_MalformedFileErrorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "code", ErrorBundle.DETAIL_ENTRY);
        j.f(a10, "of(\"title\", \"code\", \"details\")");
        this.options = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.stringAdapter = f10;
        h<GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError.Details> f11 = sVar.f(GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError.Details.class, n0.e(), ErrorBundle.DETAIL_ENTRY);
        j.f(f11, "moshi.adapter(GenericFil…   emptySet(), \"details\")");
        this.detailsAdapter = f11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(93);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError.Details details = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("title", "title", jsonReader);
                    j.f(x10, "unexpectedNull(\"title\", …tle\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException x11 = c.x("code", "code", jsonReader);
                    j.f(x11, "unexpectedNull(\"code\", \"code\",\n            reader)");
                    throw x11;
                }
            } else if (L == 2 && (details = this.detailsAdapter.fromJson(jsonReader)) == null) {
                JsonDataException x12 = c.x(ErrorBundle.DETAIL_ENTRY, ErrorBundle.DETAIL_ENTRY, jsonReader);
                j.f(x12, "unexpectedNull(\"details\"…       \"details\", reader)");
                throw x12;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("title", "title", jsonReader);
            j.f(o10, "missingProperty(\"title\", \"title\", reader)");
            throw o10;
        } else if (str2 == null) {
            JsonDataException o11 = c.o("code", "code", jsonReader);
            j.f(o11, "missingProperty(\"code\", \"code\", reader)");
            throw o11;
        } else if (details != null) {
            return new GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError(str, str2, details);
        } else {
            JsonDataException o12 = c.o(ErrorBundle.DETAIL_ENTRY, ErrorBundle.DETAIL_ENTRY, jsonReader);
            j.f(o12, "missingProperty(\"details\", \"details\", reader)");
            throw o12;
        }
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError malformedFileError) {
        j.g(qVar, "writer");
        if (malformedFileError != null) {
            qVar.c();
            qVar.u("title");
            this.stringAdapter.toJson(qVar, malformedFileError.getTitle());
            qVar.u("code");
            this.stringAdapter.toJson(qVar, malformedFileError.getCode());
            qVar.u(ErrorBundle.DETAIL_ENTRY);
            this.detailsAdapter.toJson(qVar, malformedFileError.getDetails());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
