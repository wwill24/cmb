package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_CompleteJsonAdapter extends h<NextStep.Complete> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26720a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26721b;

    public NextStep_CompleteJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name");
        j.f(a10, "of(\"name\")");
        this.f26720a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f26721b = f10;
    }

    /* renamed from: a */
    public NextStep.Complete fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26720a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26721b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("name", "name", jsonReader);
                j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new NextStep.Complete(str);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Complete complete) {
        j.g(qVar, "writer");
        if (complete != null) {
            qVar.c();
            qVar.u("name");
            this.f26721b.toJson(qVar, complete.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Complete");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
