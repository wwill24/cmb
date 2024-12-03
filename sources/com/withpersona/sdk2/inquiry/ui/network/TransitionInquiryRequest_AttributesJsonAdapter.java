package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest;
import java.util.Map;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class TransitionInquiryRequest_AttributesJsonAdapter extends h<TransitionInquiryRequest.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29456a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Map<String, ComponentParam>> f29457b;

    public TransitionInquiryRequest_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("componentParams");
        j.f(a10, "of(\"componentParams\")");
        this.f29456a = a10;
        h<Map<String, ComponentParam>> f10 = sVar.f(w.j(Map.class, String.class, ComponentParam.class), n0.e(), "componentParams");
        j.f(f10, "moshi.adapter(Types.newP…Set(), \"componentParams\")");
        this.f29457b = f10;
    }

    /* renamed from: a */
    public TransitionInquiryRequest.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Map map = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29456a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                map = this.f29457b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new TransitionInquiryRequest.Attributes(map);
    }

    /* renamed from: b */
    public void toJson(q qVar, TransitionInquiryRequest.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("componentParams");
            this.f29457b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TransitionInquiryRequest.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
