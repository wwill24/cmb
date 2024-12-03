package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ComplexTextBasedFontSizeStyleJsonAdapter extends h<AttributeStyles$ComplexTextBasedFontSizeStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28550a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f28551b;

    public AttributeStyles_ComplexTextBasedFontSizeStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "placeholder", "label", "error");
        j.f(a10, "of(\"value\", \"placeholder\", \"label\",\n      \"error\")");
        this.f28550a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"value\")");
        this.f28551b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ComplexTextBasedFontSizeStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        StyleElements.DPMeasurement dPMeasurement2 = null;
        StyleElements.DPMeasurement dPMeasurement3 = null;
        StyleElements.DPMeasurement dPMeasurement4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28550a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f28551b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurement2 = this.f28551b.fromJson(jsonReader);
            } else if (L == 2) {
                dPMeasurement3 = this.f28551b.fromJson(jsonReader);
            } else if (L == 3) {
                dPMeasurement4 = this.f28551b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ComplexTextBasedFontSizeStyle(dPMeasurement, dPMeasurement2, dPMeasurement3, dPMeasurement4);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ComplexTextBasedFontSizeStyle != null) {
            qVar.c();
            qVar.u("value");
            this.f28551b.toJson(qVar, attributeStyles$ComplexTextBasedFontSizeStyle.e());
            qVar.u("placeholder");
            this.f28551b.toJson(qVar, attributeStyles$ComplexTextBasedFontSizeStyle.d());
            qVar.u("label");
            this.f28551b.toJson(qVar, attributeStyles$ComplexTextBasedFontSizeStyle.c());
            qVar.u("error");
            this.f28551b.toJson(qVar, attributeStyles$ComplexTextBasedFontSizeStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ComplexTextBasedFontSizeStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
