package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputTextBorderRadiusStyleJsonAdapter extends h<AttributeStyles$InputTextBorderRadiusStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28655a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f28656b;

    public AttributeStyles_InputTextBorderRadiusStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28655a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28656b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputTextBorderRadiusStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28655a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f28656b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputTextBorderRadiusStyle(dPMeasurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputTextBorderRadiusStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28656b.toJson(qVar, attributeStyles$InputTextBorderRadiusStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputTextBorderRadiusStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
