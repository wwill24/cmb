package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquirySessionResponse_MetaJsonAdapter extends h<CreateInquirySessionResponse.Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26458a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26459b;

    public CreateInquirySessionResponse_MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(SDKConstants.PARAM_ACCESS_TOKEN);
        j.f(a10, "of(\"accessToken\")");
        this.f26458a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), SDKConstants.PARAM_ACCESS_TOKEN);
        j.f(f10, "moshi.adapter(String::cl…t(),\n      \"accessToken\")");
        this.f26459b = f10;
    }

    /* renamed from: a */
    public CreateInquirySessionResponse.Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26458a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f26459b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x(SDKConstants.PARAM_ACCESS_TOKEN, SDKConstants.PARAM_ACCESS_TOKEN, jsonReader);
                j.f(x10, "unexpectedNull(\"accessTo…\", \"accessToken\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new CreateInquirySessionResponse.Meta(str);
        }
        JsonDataException o10 = c.o(SDKConstants.PARAM_ACCESS_TOKEN, SDKConstants.PARAM_ACCESS_TOKEN, jsonReader);
        j.f(o10, "missingProperty(\"accessT…ken\",\n            reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquirySessionResponse.Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u(SDKConstants.PARAM_ACCESS_TOKEN);
            this.f26459b.toJson(qVar, meta.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquirySessionResponse.Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
