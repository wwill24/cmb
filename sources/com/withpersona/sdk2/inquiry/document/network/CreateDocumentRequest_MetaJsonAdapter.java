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

public final class CreateDocumentRequest_MetaJsonAdapter extends h<CreateDocumentRequest.Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25180a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25181b;

    public CreateDocumentRequest_MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fieldKeyDocument");
        j.f(a10, "of(\"fieldKeyDocument\")");
        this.f25180a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "fieldKeyDocument");
        j.f(f10, "moshi.adapter(String::cl…      \"fieldKeyDocument\")");
        this.f25181b = f10;
    }

    /* renamed from: a */
    public CreateDocumentRequest.Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25180a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f25181b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("fieldKeyDocument", "fieldKeyDocument", jsonReader);
                j.f(x10, "unexpectedNull(\"fieldKey…ieldKeyDocument\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new CreateDocumentRequest.Meta(str);
        }
        JsonDataException o10 = c.o("fieldKeyDocument", "fieldKeyDocument", jsonReader);
        j.f(o10, "missingProperty(\"fieldKe…ieldKeyDocument\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateDocumentRequest.Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u("fieldKeyDocument");
            this.f25181b.toJson(qVar, meta.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateDocumentRequest.Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
