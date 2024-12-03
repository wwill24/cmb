package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class FallbackModeService_SessionIdResponseJsonAdapter extends h<FallbackModeService.SessionIdResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26349a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26350b;

    public FallbackModeService_SessionIdResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("token");
        j.f(a10, "of(\"token\")");
        this.f26349a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "token");
        j.f(f10, "moshi.adapter(String::cl…mptySet(),\n      \"token\")");
        this.f26350b = f10;
    }

    /* renamed from: a */
    public FallbackModeService.SessionIdResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26349a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26350b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("token", "token", jsonReader);
                j.f(x10, "unexpectedNull(\"token\", …ken\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new FallbackModeService.SessionIdResponse(str);
        }
        JsonDataException o10 = c.o("token", "token", jsonReader);
        j.f(o10, "missingProperty(\"token\", \"token\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.SessionIdResponse sessionIdResponse) {
        j.g(qVar, "writer");
        if (sessionIdResponse != null) {
            qVar.c();
            qVar.u("token");
            this.f26350b.toJson(qVar, sessionIdResponse.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.SessionIdResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
