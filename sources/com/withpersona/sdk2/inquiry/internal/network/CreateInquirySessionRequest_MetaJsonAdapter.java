package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquirySessionRequest_MetaJsonAdapter extends h<CreateInquirySessionRequest.Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26447a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26448b;

    public CreateInquirySessionRequest_MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("inquiryId");
        j.f(a10, "of(\"inquiryId\")");
        this.f26447a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "inquiryId");
        j.f(f10, "moshi.adapter(String::cl…Set(),\n      \"inquiryId\")");
        this.f26448b = f10;
    }

    /* renamed from: a */
    public CreateInquirySessionRequest.Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26447a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26448b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("inquiryId", "inquiryId", jsonReader);
                j.f(x10, "unexpectedNull(\"inquiryI…     \"inquiryId\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new CreateInquirySessionRequest.Meta(str);
        }
        JsonDataException o10 = c.o("inquiryId", "inquiryId", jsonReader);
        j.f(o10, "missingProperty(\"inquiryId\", \"inquiryId\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquirySessionRequest.Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u("inquiryId");
            this.f26448b.toJson(qVar, meta.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquirySessionRequest.Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
