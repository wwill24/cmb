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

public final class FallbackModeService_UploadUrlRequestJsonAdapter extends h<FallbackModeService.UploadUrlRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26357a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Long> f26358b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26359c;

    public FallbackModeService_UploadUrlRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("expected-content-length", "expected-content-type");
        j.f(a10, "of(\"expected-content-len… \"expected-content-type\")");
        this.f26357a = a10;
        h<Long> f10 = sVar.f(Long.TYPE, n0.e(), "expectedContentLength");
        j.f(f10, "moshi.adapter(Long::clas… \"expectedContentLength\")");
        this.f26358b = f10;
        h<String> f11 = sVar.f(String.class, n0.e(), "expectedContentType");
        j.f(f11, "moshi.adapter(String::cl…   \"expectedContentType\")");
        this.f26359c = f11;
    }

    /* renamed from: a */
    public FallbackModeService.UploadUrlRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Long l10 = null;
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26357a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                l10 = this.f26358b.fromJson(jsonReader);
                if (l10 == null) {
                    JsonDataException x10 = c.x("expectedContentLength", "expected-content-length", jsonReader);
                    j.f(x10, "unexpectedNull(\"expected…-content-length\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (str = this.f26359c.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("expectedContentType", "expected-content-type", jsonReader);
                j.f(x11, "unexpectedNull(\"expected…ed-content-type\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (l10 != null) {
            long longValue = l10.longValue();
            if (str != null) {
                return new FallbackModeService.UploadUrlRequest(longValue, str);
            }
            JsonDataException o10 = c.o("expectedContentType", "expected-content-type", jsonReader);
            j.f(o10, "missingProperty(\"expecte…ed-content-type\", reader)");
            throw o10;
        }
        JsonDataException o11 = c.o("expectedContentLength", "expected-content-length", jsonReader);
        j.f(o11, "missingProperty(\"expecte…-content-length\", reader)");
        throw o11;
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.UploadUrlRequest uploadUrlRequest) {
        j.g(qVar, "writer");
        if (uploadUrlRequest != null) {
            qVar.c();
            qVar.u("expected-content-length");
            this.f26358b.toJson(qVar, Long.valueOf(uploadUrlRequest.a()));
            qVar.u("expected-content-type");
            this.f26359c.toJson(qVar, uploadUrlRequest.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.UploadUrlRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
