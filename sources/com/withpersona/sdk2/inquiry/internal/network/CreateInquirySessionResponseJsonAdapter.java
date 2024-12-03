package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquirySessionResponseJsonAdapter extends h<CreateInquirySessionResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26453a;

    /* renamed from: b  reason: collision with root package name */
    private final h<CreateInquirySessionResponse.Data> f26454b;

    /* renamed from: c  reason: collision with root package name */
    private final h<CreateInquirySessionResponse.Meta> f26455c;

    public CreateInquirySessionResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("data", "meta");
        j.f(a10, "of(\"data\", \"meta\")");
        this.f26453a = a10;
        h<CreateInquirySessionResponse.Data> f10 = sVar.f(CreateInquirySessionResponse.Data.class, n0.e(), "data");
        j.f(f10, "moshi.adapter(CreateInqu…java, emptySet(), \"data\")");
        this.f26454b = f10;
        h<CreateInquirySessionResponse.Meta> f11 = sVar.f(CreateInquirySessionResponse.Meta.class, n0.e(), "meta");
        j.f(f11, "moshi.adapter(CreateInqu…java, emptySet(), \"meta\")");
        this.f26455c = f11;
    }

    /* renamed from: a */
    public CreateInquirySessionResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        CreateInquirySessionResponse.Data data = null;
        CreateInquirySessionResponse.Meta meta = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26453a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                data = this.f26454b.fromJson(jsonReader);
                if (data == null) {
                    JsonDataException x10 = c.x("data_", "data", jsonReader);
                    j.f(x10, "unexpectedNull(\"data_\", …ata\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (meta = this.f26455c.fromJson(jsonReader)) == null) {
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
            return new CreateInquirySessionResponse(data, meta);
        } else {
            JsonDataException o11 = c.o("meta", "meta", jsonReader);
            j.f(o11, "missingProperty(\"meta\", \"meta\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquirySessionResponse createInquirySessionResponse) {
        j.g(qVar, "writer");
        if (createInquirySessionResponse != null) {
            qVar.c();
            qVar.u("data");
            this.f26454b.toJson(qVar, createInquirySessionResponse.a());
            qVar.u("meta");
            this.f26455c.toJson(qVar, createInquirySessionResponse.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquirySessionResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
