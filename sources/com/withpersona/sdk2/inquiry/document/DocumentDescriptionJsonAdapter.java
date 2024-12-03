package com.withpersona.sdk2.inquiry.document;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentDescriptionJsonAdapter extends h<DocumentDescription> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f24967a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f24968b;

    public DocumentDescriptionJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("kind", "title", "prompt", "description");
        j.f(a10, "of(\"kind\", \"title\", \"prompt\",\n      \"description\")");
        this.f24967a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "kind");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"kind\")");
        this.f24968b = f10;
    }

    /* renamed from: a */
    public DocumentDescription fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f24967a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f24968b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("kind", "kind", jsonReader);
                    j.f(x10, "unexpectedNull(\"kind\", \"kind\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str2 = this.f24968b.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException x11 = c.x("title", "title", jsonReader);
                    j.f(x11, "unexpectedNull(\"title\", …tle\",\n            reader)");
                    throw x11;
                }
            } else if (L == 2) {
                str3 = this.f24968b.fromJson(jsonReader);
                if (str3 == null) {
                    JsonDataException x12 = c.x("prompt", "prompt", jsonReader);
                    j.f(x12, "unexpectedNull(\"prompt\",…        \"prompt\", reader)");
                    throw x12;
                }
            } else if (L == 3 && (str4 = this.f24968b.fromJson(jsonReader)) == null) {
                JsonDataException x13 = c.x("description", "description", jsonReader);
                j.f(x13, "unexpectedNull(\"descript…\", \"description\", reader)");
                throw x13;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("kind", "kind", jsonReader);
            j.f(o10, "missingProperty(\"kind\", \"kind\", reader)");
            throw o10;
        } else if (str2 == null) {
            JsonDataException o11 = c.o("title", "title", jsonReader);
            j.f(o11, "missingProperty(\"title\", \"title\", reader)");
            throw o11;
        } else if (str3 == null) {
            JsonDataException o12 = c.o("prompt", "prompt", jsonReader);
            j.f(o12, "missingProperty(\"prompt\", \"prompt\", reader)");
            throw o12;
        } else if (str4 != null) {
            return new DocumentDescription(str, str2, str3, str4);
        } else {
            JsonDataException o13 = c.o("description", "description", jsonReader);
            j.f(o13, "missingProperty(\"descrip…ion\",\n            reader)");
            throw o13;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, DocumentDescription documentDescription) {
        j.g(qVar, "writer");
        if (documentDescription != null) {
            qVar.c();
            qVar.u("kind");
            this.f24968b.toJson(qVar, documentDescription.c());
            qVar.u("title");
            this.f24968b.toJson(qVar, documentDescription.e());
            qVar.u("prompt");
            this.f24968b.toJson(qVar, documentDescription.d());
            qVar.u("description");
            this.f24968b.toJson(qVar, documentDescription.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("DocumentDescription");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
