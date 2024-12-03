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

public final class CreateInquirySessionResponse_DataJsonAdapter extends h<CreateInquirySessionResponse.Data> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26456a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26457b;

    public CreateInquirySessionResponse_DataJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("id");
        j.f(a10, "of(\"id\")");
        this.f26456a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "id");
        j.f(f10, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.f26457b = f10;
    }

    /* renamed from: a */
    public CreateInquirySessionResponse.Data fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26456a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26457b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("id", "id", jsonReader);
                j.f(x10, "unexpectedNull(\"id\", \"id\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new CreateInquirySessionResponse.Data(str);
        }
        JsonDataException o10 = c.o("id", "id", jsonReader);
        j.f(o10, "missingProperty(\"id\", \"id\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquirySessionResponse.Data data) {
        j.g(qVar, "writer");
        if (data != null) {
            qVar.c();
            qVar.u("id");
            this.f26457b.toJson(qVar, data.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquirySessionResponse.Data");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
