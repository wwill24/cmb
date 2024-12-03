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

public final class UiComponent_BrandingJsonAdapter extends h<UiComponent.Branding> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28009a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28010b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Branding.Attributes> f28011c;

    public UiComponent_BrandingJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes");
        j.f(a10, "of(\"name\", \"attributes\")");
        this.f28009a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28010b = f10;
        h<UiComponent.Branding.Attributes> f11 = sVar.f(UiComponent.Branding.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28011c = f11;
    }

    /* renamed from: a */
    public UiComponent.Branding fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.Branding.Attributes attributes = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28009a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28010b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28011c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.Branding(str, attributes);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Branding branding) {
        j.g(qVar, "writer");
        if (branding != null) {
            qVar.c();
            qVar.u("name");
            this.f28010b.toJson(qVar, branding.A());
            qVar.u("attributes");
            this.f28011c.toJson(qVar, branding.z());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Branding");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
