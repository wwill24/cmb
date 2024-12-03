package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_PrivacyPolicy_AttributesJsonAdapter extends h<UiComponent.PrivacyPolicy.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28283a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28284b;

    public UiComponent_PrivacyPolicy_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("text");
        j.f(a10, "of(\"text\")");
        this.f28283a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "text");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.f28284b = f10;
    }

    /* renamed from: a */
    public UiComponent.PrivacyPolicy.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28283a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.f28284b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("text", "text", jsonReader);
                j.f(x10, "unexpectedNull(\"text\", \"text\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.PrivacyPolicy.Attributes(str);
        }
        JsonDataException o10 = c.o("text", "text", jsonReader);
        j.f(o10, "missingProperty(\"text\", \"text\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.PrivacyPolicy.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("text");
            this.f28284b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.PrivacyPolicy.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
