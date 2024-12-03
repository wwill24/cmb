package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.InquiryFieldMap;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class FallbackModeService_SessionIdRequestJsonAdapter extends h<FallbackModeService.SessionIdRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26345a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26346b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26347c;

    /* renamed from: d  reason: collision with root package name */
    private final h<InquiryFieldMap> f26348d;

    public FallbackModeService_SessionIdRequestJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("inquiry-template-id", "reference-id", "fields");
        j.f(a10, "of(\"inquiry-template-id\"…\"reference-id\", \"fields\")");
        this.f26345a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "inquiryTemplateId");
        j.f(f10, "moshi.adapter(String::cl…     \"inquiryTemplateId\")");
        this.f26346b = f10;
        h<String> f11 = sVar.f(cls, n0.e(), "referenceId");
        j.f(f11, "moshi.adapter(String::cl…mptySet(), \"referenceId\")");
        this.f26347c = f11;
        h<InquiryFieldMap> f12 = sVar.f(InquiryFieldMap.class, n0.e(), "fields");
        j.f(f12, "moshi.adapter(InquiryFie…va, emptySet(), \"fields\")");
        this.f26348d = f12;
    }

    /* renamed from: a */
    public FallbackModeService.SessionIdRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        InquiryFieldMap inquiryFieldMap = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26345a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26346b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("inquiryTemplateId", "inquiry-template-id", jsonReader);
                    j.f(x10, "unexpectedNull(\"inquiryT…iry-template-id\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str2 = this.f26347c.fromJson(jsonReader);
            } else if (L == 2) {
                inquiryFieldMap = this.f26348d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new FallbackModeService.SessionIdRequest(str, str2, inquiryFieldMap);
        }
        JsonDataException o10 = c.o("inquiryTemplateId", "inquiry-template-id", jsonReader);
        j.f(o10, "missingProperty(\"inquiry…iry-template-id\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, FallbackModeService.SessionIdRequest sessionIdRequest) {
        j.g(qVar, "writer");
        if (sessionIdRequest != null) {
            qVar.c();
            qVar.u("inquiry-template-id");
            this.f26346b.toJson(qVar, sessionIdRequest.b());
            qVar.u("reference-id");
            this.f26347c.toJson(qVar, sessionIdRequest.c());
            qVar.u("fields");
            this.f26348d.toJson(qVar, sessionIdRequest.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("FallbackModeService.SessionIdRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
