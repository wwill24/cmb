package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.document.network.SubmitDocumentRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class SubmitDocumentRequest_MetaJsonAdapter extends h<SubmitDocumentRequest.Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25269a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25270b;

    public SubmitDocumentRequest_MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fromStep", "fromComponent");
        j.f(a10, "of(\"fromStep\", \"fromComponent\")");
        this.f25269a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "fromStep");
        j.f(f10, "moshi.adapter(String::cl…ySet(),\n      \"fromStep\")");
        this.f25270b = f10;
    }

    /* renamed from: a */
    public SubmitDocumentRequest.Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25269a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25270b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("fromStep", "fromStep", jsonReader);
                    j.f(x10, "unexpectedNull(\"fromStep…      \"fromStep\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f25270b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("fromComponent", "fromComponent", jsonReader);
                j.f(x11, "unexpectedNull(\"fromComp… \"fromComponent\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("fromStep", "fromStep", jsonReader);
            j.f(o10, "missingProperty(\"fromStep\", \"fromStep\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new SubmitDocumentRequest.Meta(str, str2);
        } else {
            JsonDataException o11 = c.o("fromComponent", "fromComponent", jsonReader);
            j.f(o11, "missingProperty(\"fromCom… \"fromComponent\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, SubmitDocumentRequest.Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u("fromStep");
            this.f25270b.toJson(qVar, meta.b());
            qVar.u("fromComponent");
            this.f25270b.toJson(qVar, meta.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SubmitDocumentRequest.Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
