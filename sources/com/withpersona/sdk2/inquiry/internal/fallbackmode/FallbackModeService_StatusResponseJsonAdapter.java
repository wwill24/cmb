package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class FallbackModeService_StatusResponseJsonAdapter extends h<FallbackModeService.StatusResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26355a;

    /* renamed from: b  reason: collision with root package name */
    private final h<FallbackModeService.StaticTemplate> f26356b;

    public FallbackModeService_StatusResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("static-inquiry-template");
        j.f(a10, "of(\"static-inquiry-template\")");
        this.f26355a = a10;
        h<FallbackModeService.StaticTemplate> f10 = sVar.f(FallbackModeService.StaticTemplate.class, n0.e(), "staticInquiryTemplate");
        j.f(f10, "moshi.adapter(FallbackMo… \"staticInquiryTemplate\")");
        this.f26356b = f10;
    }

    /* renamed from: a */
    public FallbackModeService.StatusResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        FallbackModeService.StaticTemplate staticTemplate = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26355a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                staticTemplate = this.f26356b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new FallbackModeService.StatusResponse(staticTemplate);
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.StatusResponse statusResponse) {
        j.g(qVar, "writer");
        if (statusResponse != null) {
            qVar.c();
            qVar.u("static-inquiry-template");
            this.f26356b.toJson(qVar, statusResponse.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.StatusResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
