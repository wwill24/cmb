package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_QRCode_AttributesJsonAdapter extends h<UiComponent.QRCode.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28295a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28296b;

    public UiComponent_QRCode_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value");
        j.f(a10, "of(\"value\")");
        this.f28295a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"value\")");
        this.f28296b = f10;
    }

    /* renamed from: a */
    public UiComponent.QRCode.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28295a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28296b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.QRCode.Attributes(str);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.QRCode.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("value");
            this.f28296b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.QRCode.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
