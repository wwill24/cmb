package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class TransitionInquiryRequest_DataJsonAdapter extends h<TransitionInquiryRequest.Data> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29458a;

    /* renamed from: b  reason: collision with root package name */
    private final h<TransitionInquiryRequest.Attributes> f29459b;

    public TransitionInquiryRequest_DataJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("attributes");
        j.f(a10, "of(\"attributes\")");
        this.f29458a = a10;
        h<TransitionInquiryRequest.Attributes> f10 = sVar.f(TransitionInquiryRequest.Attributes.class, n0.e(), "attributes");
        j.f(f10, "moshi.adapter(Transition…emptySet(), \"attributes\")");
        this.f29459b = f10;
    }

    /* renamed from: a */
    public TransitionInquiryRequest.Data fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        TransitionInquiryRequest.Attributes attributes = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29458a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (attributes = this.f29459b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("attributes", "attributes", jsonReader);
                j.f(x10, "unexpectedNull(\"attributes\", \"attributes\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (attributes != null) {
            return new TransitionInquiryRequest.Data(attributes);
        }
        JsonDataException o10 = c.o("attributes", "attributes", jsonReader);
        j.f(o10, "missingProperty(\"attribu…s\", \"attributes\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, TransitionInquiryRequest.Data data) {
        j.g(qVar, "writer");
        if (data != null) {
            qVar.c();
            qVar.u("attributes");
            this.f29459b.toJson(qVar, data.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TransitionInquiryRequest.Data");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
