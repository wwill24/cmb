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

public final class CreateInquirySessionRequestJsonAdapter extends h<CreateInquirySessionRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26441a;

    /* renamed from: b  reason: collision with root package name */
    private final h<CreateInquirySessionRequest.Data> f26442b;

    /* renamed from: c  reason: collision with root package name */
    private final h<CreateInquirySessionRequest.Meta> f26443c;

    public CreateInquirySessionRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("data", "meta");
        j.f(a10, "of(\"data\", \"meta\")");
        this.f26441a = a10;
        h<CreateInquirySessionRequest.Data> f10 = sVar.f(CreateInquirySessionRequest.Data.class, n0.e(), "data");
        j.f(f10, "moshi.adapter(CreateInqu…java, emptySet(), \"data\")");
        this.f26442b = f10;
        h<CreateInquirySessionRequest.Meta> f11 = sVar.f(CreateInquirySessionRequest.Meta.class, n0.e(), "meta");
        j.f(f11, "moshi.adapter(CreateInqu…java, emptySet(), \"meta\")");
        this.f26443c = f11;
    }

    /* renamed from: a */
    public CreateInquirySessionRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        CreateInquirySessionRequest.Data data = null;
        CreateInquirySessionRequest.Meta meta = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26441a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                data = this.f26442b.fromJson(jsonReader);
                if (data == null) {
                    JsonDataException x10 = c.x("data_", "data", jsonReader);
                    j.f(x10, "unexpectedNull(\"data_\", …ata\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (meta = this.f26443c.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("meta", "meta", jsonReader);
                j.f(x11, "unexpectedNull(\"meta\", \"meta\",\n            reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (data == null) {
            JsonDataException o10 = c.o("data_", "data", jsonReader);
            j.f(o10, "missingProperty(\"data_\", \"data\", reader)");
            throw o10;
        } else if (meta != null) {
            return new CreateInquirySessionRequest(data, meta);
        } else {
            JsonDataException o11 = c.o("meta", "meta", jsonReader);
            j.f(o11, "missingProperty(\"meta\", \"meta\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquirySessionRequest createInquirySessionRequest) {
        j.g(qVar, "writer");
        if (createInquirySessionRequest != null) {
            qVar.c();
            qVar.u("data");
            this.f26442b.toJson(qVar, createInquirySessionRequest.a());
            qVar.u("meta");
            this.f26443c.toJson(qVar, createInquirySessionRequest.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquirySessionRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
