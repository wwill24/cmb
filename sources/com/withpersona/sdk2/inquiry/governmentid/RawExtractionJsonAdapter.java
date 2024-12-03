package com.withpersona.sdk2.inquiry.governmentid;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class RawExtractionJsonAdapter extends h<RawExtraction> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25718a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25719b;

    public RawExtractionJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("type", "value");
        j.f(a10, "of(\"type\", \"value\")");
        this.f25718a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "type");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.f25719b = f10;
    }

    /* renamed from: a */
    public RawExtraction fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25718a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25719b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("type", "type", jsonReader);
                    j.f(x10, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f25719b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("value__", "value", jsonReader);
                j.f(x11, "unexpectedNull(\"value__\"…         \"value\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("type", "type", jsonReader);
            j.f(o10, "missingProperty(\"type\", \"type\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new RawExtraction(str, str2);
        } else {
            JsonDataException o11 = c.o("value__", "value", jsonReader);
            j.f(o11, "missingProperty(\"value__\", \"value\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, RawExtraction rawExtraction) {
        j.g(qVar, "writer");
        if (rawExtraction != null) {
            qVar.c();
            qVar.u("type");
            this.f25719b.toJson(qVar, rawExtraction.a());
            qVar.u("value");
            this.f25719b.toJson(qVar, rawExtraction.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("RawExtraction");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
