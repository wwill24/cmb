package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.CreateInquiryRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquiryRequestJsonAdapter extends h<CreateInquiryRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26434a;

    /* renamed from: b  reason: collision with root package name */
    private final h<CreateInquiryRequest.Data> f26435b;

    public CreateInquiryRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("data");
        j.f(a10, "of(\"data\")");
        this.f26434a = a10;
        h<CreateInquiryRequest.Data> f10 = sVar.f(CreateInquiryRequest.Data.class, n0.e(), "data");
        j.f(f10, "moshi.adapter(CreateInqu…java, emptySet(), \"data\")");
        this.f26435b = f10;
    }

    /* renamed from: a */
    public CreateInquiryRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        CreateInquiryRequest.Data data = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26434a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (data = this.f26435b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("data_", "data", jsonReader);
                j.f(x10, "unexpectedNull(\"data_\", …ata\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (data != null) {
            return new CreateInquiryRequest(data);
        }
        JsonDataException o10 = c.o("data_", "data", jsonReader);
        j.f(o10, "missingProperty(\"data_\", \"data\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquiryRequest createInquiryRequest) {
        j.g(qVar, "writer");
        if (createInquiryRequest != null) {
            qVar.c();
            qVar.u("data");
            this.f26435b.toJson(qVar, createInquiryRequest.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquiryRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
