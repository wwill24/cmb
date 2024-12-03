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

public final class CreateDocumentRequest_AttributesJsonAdapter extends h<CreateDocumentRequest.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25174a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25175b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Integer> f25176c;

    public CreateDocumentRequest_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("kind", "fileLimit");
        j.f(a10, "of(\"kind\", \"fileLimit\")");
        this.f25174a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "kind");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"kind\")");
        this.f25175b = f10;
        h<Integer> f11 = sVar.f(Integer.TYPE, n0.e(), "fileLimit");
        j.f(f11, "moshi.adapter(Int::class… emptySet(), \"fileLimit\")");
        this.f25176c = f11;
    }

    /* renamed from: a */
    public CreateDocumentRequest.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        Integer num = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25174a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25175b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("kind", "kind", jsonReader);
                    j.f(x10, "unexpectedNull(\"kind\", \"kind\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (num = this.f25176c.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("fileLimit", "fileLimit", jsonReader);
                j.f(x11, "unexpectedNull(\"fileLimi…     \"fileLimit\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("kind", "kind", jsonReader);
            j.f(o10, "missingProperty(\"kind\", \"kind\", reader)");
            throw o10;
        } else if (num != null) {
            return new CreateDocumentRequest.Attributes(str, num.intValue());
        } else {
            JsonDataException o11 = c.o("fileLimit", "fileLimit", jsonReader);
            j.f(o11, "missingProperty(\"fileLimit\", \"fileLimit\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateDocumentRequest.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("kind");
            this.f25175b.toJson(qVar, attributes.b());
            qVar.u("fileLimit");
            this.f25176c.toJson(qVar, Integer.valueOf(attributes.a()));
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateDocumentRequest.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
