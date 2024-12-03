package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.document.network.CreateDocumentRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateDocumentRequest_DataJsonAdapter extends h<CreateDocumentRequest.Data> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25177a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25178b;

    /* renamed from: c  reason: collision with root package name */
    private final h<CreateDocumentRequest.Attributes> f25179c;

    public CreateDocumentRequest_DataJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("type", "attributes");
        j.f(a10, "of(\"type\", \"attributes\")");
        this.f25177a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "type");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.f25178b = f10;
        h<CreateDocumentRequest.Attributes> f11 = sVar.f(CreateDocumentRequest.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(CreateDocu…emptySet(), \"attributes\")");
        this.f25179c = f11;
    }

    /* renamed from: a */
    public CreateDocumentRequest.Data fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        CreateDocumentRequest.Attributes attributes = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25177a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25178b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("type", "type", jsonReader);
                    j.f(x10, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (attributes = this.f25179c.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("attributes", "attributes", jsonReader);
                j.f(x11, "unexpectedNull(\"attributes\", \"attributes\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("type", "type", jsonReader);
            j.f(o10, "missingProperty(\"type\", \"type\", reader)");
            throw o10;
        } else if (attributes != null) {
            return new CreateDocumentRequest.Data(str, attributes);
        } else {
            JsonDataException o11 = c.o("attributes", "attributes", jsonReader);
            j.f(o11, "missingProperty(\"attribu…s\", \"attributes\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateDocumentRequest.Data data) {
        j.g(qVar, "writer");
        if (data != null) {
            qVar.c();
            qVar.u("type");
            this.f25178b.toJson(qVar, data.b());
            qVar.u("attributes");
            this.f25179c.toJson(qVar, data.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateDocumentRequest.Data");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
