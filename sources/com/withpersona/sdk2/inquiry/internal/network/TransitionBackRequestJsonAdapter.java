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

public final class TransitionBackRequestJsonAdapter extends h<TransitionBackRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26894a;

    /* renamed from: b  reason: collision with root package name */
    private final h<TransitionBackRequest.Meta> f26895b;

    public TransitionBackRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("meta");
        j.f(a10, "of(\"meta\")");
        this.f26894a = a10;
        h<TransitionBackRequest.Meta> f10 = sVar.f(TransitionBackRequest.Meta.class, n0.e(), "meta");
        j.f(f10, "moshi.adapter(Transition…java, emptySet(), \"meta\")");
        this.f26895b = f10;
    }

    /* renamed from: a */
    public TransitionBackRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        TransitionBackRequest.Meta meta = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26894a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (meta = this.f26895b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("meta", "meta", jsonReader);
                j.f(x10, "unexpectedNull(\"meta\", \"meta\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (meta != null) {
            return new TransitionBackRequest(meta);
        }
        JsonDataException o10 = c.o("meta", "meta", jsonReader);
        j.f(o10, "missingProperty(\"meta\", \"meta\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, TransitionBackRequest transitionBackRequest) {
        j.g(qVar, "writer");
        if (transitionBackRequest != null) {
            qVar.c();
            qVar.u("meta");
            this.f26895b.toJson(qVar, transitionBackRequest.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TransitionBackRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
