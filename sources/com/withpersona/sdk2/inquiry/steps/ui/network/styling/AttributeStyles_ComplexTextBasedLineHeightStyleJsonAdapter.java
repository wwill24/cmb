package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ComplexTextBasedLineHeightStyleJsonAdapter extends h<AttributeStyles$ComplexTextBasedLineHeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28556a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f28557b;

    public AttributeStyles_ComplexTextBasedLineHeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "placeholder", "label", "error");
        j.f(a10, "of(\"value\", \"placeholder\", \"label\",\n      \"error\")");
        this.f28556a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"value\")");
        this.f28557b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ComplexTextBasedLineHeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        StyleElements.DPMeasurement dPMeasurement2 = null;
        StyleElements.DPMeasurement dPMeasurement3 = null;
        StyleElements.DPMeasurement dPMeasurement4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28556a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f28557b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurement2 = this.f28557b.fromJson(jsonReader);
            } else if (L == 2) {
                dPMeasurement3 = this.f28557b.fromJson(jsonReader);
            } else if (L == 3) {
                dPMeasurement4 = this.f28557b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ComplexTextBasedLineHeightStyle(dPMeasurement, dPMeasurement2, dPMeasurement3, dPMeasurement4);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ComplexTextBasedLineHeightStyle != null) {
            qVar.c();
            qVar.u("value");
            this.f28557b.toJson(qVar, attributeStyles$ComplexTextBasedLineHeightStyle.e());
            qVar.u("placeholder");
            this.f28557b.toJson(qVar, attributeStyles$ComplexTextBasedLineHeightStyle.d());
            qVar.u("label");
            this.f28557b.toJson(qVar, attributeStyles$ComplexTextBasedLineHeightStyle.c());
            qVar.u("error");
            this.f28557b.toJson(qVar, attributeStyles$ComplexTextBasedLineHeightStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ComplexTextBasedLineHeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
