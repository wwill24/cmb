package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.TransitionBackRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class TransitionBackRequest_MetaJsonAdapter extends h<TransitionBackRequest.Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26896a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26897b;

    public TransitionBackRequest_MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fromStep");
        j.f(a10, "of(\"fromStep\")");
        this.f26896a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "fromStep");
        j.f(f10, "moshi.adapter(String::cl…ySet(),\n      \"fromStep\")");
        this.f26897b = f10;
    }

    /* renamed from: a */
    public TransitionBackRequest.Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26896a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26897b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("fromStep", "fromStep", jsonReader);
                j.f(x10, "unexpectedNull(\"fromStep…      \"fromStep\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new TransitionBackRequest.Meta(str);
        }
        JsonDataException o10 = c.o("fromStep", "fromStep", jsonReader);
        j.f(o10, "missingProperty(\"fromStep\", \"fromStep\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, TransitionBackRequest.Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u("fromStep");
            this.f26897b.toJson(qVar, meta.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TransitionBackRequest.Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
