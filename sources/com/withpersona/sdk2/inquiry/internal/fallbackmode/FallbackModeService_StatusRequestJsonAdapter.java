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

public final class FallbackModeService_StatusRequestJsonAdapter extends h<FallbackModeService.StatusRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26353a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26354b;

    public FallbackModeService_StatusRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("inquiry-template-id");
        j.f(a10, "of(\"inquiry-template-id\")");
        this.f26353a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "inquiryTemplateId");
        j.f(f10, "moshi.adapter(String::cl…     \"inquiryTemplateId\")");
        this.f26354b = f10;
    }

    /* renamed from: a */
    public FallbackModeService.StatusRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26353a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26354b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("inquiryTemplateId", "inquiry-template-id", jsonReader);
                j.f(x10, "unexpectedNull(\"inquiryT…iry-template-id\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new FallbackModeService.StatusRequest(str);
        }
        JsonDataException o10 = c.o("inquiryTemplateId", "inquiry-template-id", jsonReader);
        j.f(o10, "missingProperty(\"inquiry…iry-template-id\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.StatusRequest statusRequest) {
        j.g(qVar, "writer");
        if (statusRequest != null) {
            qVar.c();
            qVar.u("inquiry-template-id");
            this.f26354b.toJson(qVar, statusRequest.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.StatusRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
