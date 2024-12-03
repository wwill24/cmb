package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentFileUploadResponseJsonAdapter extends h<DocumentFileUploadResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25218a;

    /* renamed from: b  reason: collision with root package name */
    private final h<DocumentFileData> f25219b;

    public DocumentFileUploadResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("data");
        j.f(a10, "of(\"data\")");
        this.f25218a = a10;
        h<DocumentFileData> f10 = sVar.f(DocumentFileData.class, n0.e(), "data");
        j.f(f10, "moshi.adapter(DocumentFi…java, emptySet(), \"data\")");
        this.f25219b = f10;
    }

    /* renamed from: a */
    public DocumentFileUploadResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        DocumentFileData documentFileData = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25218a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (documentFileData = this.f25219b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("data_", "data", jsonReader);
                j.f(x10, "unexpectedNull(\"data_\",\n…          \"data\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (documentFileData != null) {
            return new DocumentFileUploadResponse(documentFileData);
        }
        JsonDataException o10 = c.o("data_", "data", jsonReader);
        j.f(o10, "missingProperty(\"data_\", \"data\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, DocumentFileUploadResponse documentFileUploadResponse) {
        j.g(qVar, "writer");
        if (documentFileUploadResponse != null) {
            qVar.c();
            qVar.u("data");
            this.f25219b.toJson(qVar, documentFileUploadResponse.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("DocumentFileUploadResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
