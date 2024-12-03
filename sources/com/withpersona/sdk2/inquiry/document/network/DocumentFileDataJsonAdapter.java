package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileData;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentFileDataJsonAdapter extends h<DocumentFileData> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25203a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25204b;

    /* renamed from: c  reason: collision with root package name */
    private final h<DocumentFileData.Attributes> f25205c;

    public DocumentFileDataJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("id", "attributes");
        j.f(a10, "of(\"id\", \"attributes\")");
        this.f25203a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "id");
        j.f(f10, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.f25204b = f10;
        h<DocumentFileData.Attributes> f11 = sVar.f(DocumentFileData.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(DocumentFi…emptySet(), \"attributes\")");
        this.f25205c = f11;
    }

    /* renamed from: a */
    public DocumentFileData fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        DocumentFileData.Attributes attributes = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25203a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25204b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("id", "id", jsonReader);
                    j.f(x10, "unexpectedNull(\"id\", \"id\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f25205c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new DocumentFileData(str, attributes);
        }
        JsonDataException o10 = c.o("id", "id", jsonReader);
        j.f(o10, "missingProperty(\"id\", \"id\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, DocumentFileData documentFileData) {
        j.g(qVar, "writer");
        if (documentFileData != null) {
            qVar.c();
            qVar.u("id");
            this.f25204b.toJson(qVar, documentFileData.b());
            qVar.u("attributes");
            this.f25205c.toJson(qVar, documentFileData.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("DocumentFileData");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
