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

public final class FallbackModeService_UploadUrlResponseJsonAdapter extends h<FallbackModeService.UploadUrlResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26360a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26361b;

    public FallbackModeService_UploadUrlResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("location");
        j.f(a10, "of(\"location\")");
        this.f26360a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "location");
        j.f(f10, "moshi.adapter(String::cl…ySet(),\n      \"location\")");
        this.f26361b = f10;
    }

    /* renamed from: a */
    public FallbackModeService.UploadUrlResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26360a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26361b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("location", "location", jsonReader);
                j.f(x10, "unexpectedNull(\"location…      \"location\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new FallbackModeService.UploadUrlResponse(str);
        }
        JsonDataException o10 = c.o("location", "location", jsonReader);
        j.f(o10, "missingProperty(\"location\", \"location\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.UploadUrlResponse uploadUrlResponse) {
        j.g(qVar, "writer");
        if (uploadUrlResponse != null) {
            qVar.c();
            qVar.u("location");
            this.f26361b.toJson(qVar, uploadUrlResponse.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.UploadUrlResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
