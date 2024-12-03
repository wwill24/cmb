package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_PrivacyPolicyJsonAdapter extends h<UiComponent.PrivacyPolicy> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28279a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28280b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.PrivacyPolicy.Attributes> f28281c;

    /* renamed from: d  reason: collision with root package name */
    private final h<TextBasedComponentStyle> f28282d;

    public UiComponent_PrivacyPolicyJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28279a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28280b = f10;
        h<UiComponent.PrivacyPolicy.Attributes> f11 = sVar.f(UiComponent.PrivacyPolicy.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28281c = f11;
        h<TextBasedComponentStyle> f12 = sVar.f(TextBasedComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(TextBasedC…va, emptySet(), \"styles\")");
        this.f28282d = f12;
    }

    /* renamed from: a */
    public UiComponent.PrivacyPolicy fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        UiComponent.PrivacyPolicy.Attributes attributes = null;
        TextBasedComponentStyle textBasedComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28279a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28280b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28281c.fromJson(jsonReader);
            } else if (L == 2) {
                textBasedComponentStyle = this.f28282d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str != null) {
            return new UiComponent.PrivacyPolicy(str, attributes, textBasedComponentStyle);
        }
        JsonDataException o10 = c.o("name", "name", jsonReader);
        j.f(o10, "missingProperty(\"name\", \"name\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.PrivacyPolicy privacyPolicy) {
        j.g(qVar, "writer");
        if (privacyPolicy != null) {
            qVar.c();
            qVar.u("name");
            this.f28280b.toJson(qVar, privacyPolicy.A());
            qVar.u("attributes");
            this.f28281c.toJson(qVar, privacyPolicy.z());
            qVar.u("styles");
            this.f28282d.toJson(qVar, privacyPolicy.D());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.PrivacyPolicy");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
