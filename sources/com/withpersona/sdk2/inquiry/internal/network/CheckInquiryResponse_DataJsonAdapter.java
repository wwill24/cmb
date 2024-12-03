package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CheckInquiryResponse_DataJsonAdapter extends h<CheckInquiryResponse.Data> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26419a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26420b;

    /* renamed from: c  reason: collision with root package name */
    private final h<CheckInquiryResponse.Attributes> f26421c;

    public CheckInquiryResponse_DataJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("id", "type", "attributes");
        j.f(a10, "of(\"id\", \"type\", \"attributes\")");
        this.f26419a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "id");
        j.f(f10, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.f26420b = f10;
        h<CheckInquiryResponse.Attributes> f11 = sVar.f(CheckInquiryResponse.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(CheckInqui…emptySet(), \"attributes\")");
        this.f26421c = f11;
    }

    /* renamed from: a */
    public CheckInquiryResponse.Data fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        CheckInquiryResponse.Attributes attributes = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26419a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26420b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("id", "id", jsonReader);
                    j.f(x10, "unexpectedNull(\"id\", \"id\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str2 = this.f26420b.fromJson(jsonReader);
                if (str2 == null) {
                    JsonDataException x11 = c.x("type", "type", jsonReader);
                    j.f(x11, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw x11;
                }
            } else if (L == 2 && (attributes = this.f26421c.fromJson(jsonReader)) == null) {
                JsonDataException x12 = c.x("attributes", "attributes", jsonReader);
                j.f(x12, "unexpectedNull(\"attributes\", \"attributes\", reader)");
                throw x12;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("id", "id", jsonReader);
            j.f(o10, "missingProperty(\"id\", \"id\", reader)");
            throw o10;
        } else if (str2 == null) {
            JsonDataException o11 = c.o("type", "type", jsonReader);
            j.f(o11, "missingProperty(\"type\", \"type\", reader)");
            throw o11;
        } else if (attributes != null) {
            return new CheckInquiryResponse.Data(str, str2, attributes);
        } else {
            JsonDataException o12 = c.o("attributes", "attributes", jsonReader);
            j.f(o12, "missingProperty(\"attribu…s\", \"attributes\", reader)");
            throw o12;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, CheckInquiryResponse.Data data) {
        j.g(qVar, "writer");
        if (data != null) {
            qVar.c();
            qVar.u("id");
            this.f26420b.toJson(qVar, data.b());
            qVar.u("type");
            this.f26420b.toJson(qVar, data.c());
            qVar.u("attributes");
            this.f26421c.toJson(qVar, data.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CheckInquiryResponse.Data");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
