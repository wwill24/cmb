package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_Branding_AttributesJsonAdapter extends h<UiComponent.Branding.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28012a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Boolean> f28013b;

    public UiComponent_Branding_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("hideLogo");
        j.f(a10, "of(\"hideLogo\")");
        this.f28012a = a10;
        h<Boolean> f10 = sVar.f(Boolean.class, n0.e(), "hideLogo");
        j.f(f10, "moshi.adapter(Boolean::c…, emptySet(), \"hideLogo\")");
        this.f28013b = f10;
    }

    /* renamed from: a */
    public UiComponent.Branding.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Boolean bool = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28012a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                bool = this.f28013b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.Branding.Attributes(bool);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Branding.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("hideLogo");
            this.f28013b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Branding.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
