package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ComplexTextBasedLetterSpacingStyleJsonAdapter extends h<AttributeStyles$ComplexTextBasedLetterSpacingStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28554a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f28555b;

    public AttributeStyles_ComplexTextBasedLetterSpacingStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "value", "placeholder", "label", "error");
        j.f(a10, "of(\"base\", \"value\", \"pla…,\n      \"label\", \"error\")");
        this.f28554a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28555b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ComplexTextBasedLetterSpacingStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        StyleElements.DPMeasurement dPMeasurement2 = null;
        StyleElements.DPMeasurement dPMeasurement3 = null;
        StyleElements.DPMeasurement dPMeasurement4 = null;
        StyleElements.DPMeasurement dPMeasurement5 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28554a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f28555b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurement2 = this.f28555b.fromJson(jsonReader);
            } else if (L == 2) {
                dPMeasurement3 = this.f28555b.fromJson(jsonReader);
            } else if (L == 3) {
                dPMeasurement4 = this.f28555b.fromJson(jsonReader);
            } else if (L == 4) {
                dPMeasurement5 = this.f28555b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ComplexTextBasedLetterSpacingStyle(dPMeasurement, dPMeasurement2, dPMeasurement3, dPMeasurement4, dPMeasurement5);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ComplexTextBasedLetterSpacingStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28555b.toJson(qVar, attributeStyles$ComplexTextBasedLetterSpacingStyle.a());
            qVar.u("value");
            this.f28555b.toJson(qVar, attributeStyles$ComplexTextBasedLetterSpacingStyle.f());
            qVar.u("placeholder");
            this.f28555b.toJson(qVar, attributeStyles$ComplexTextBasedLetterSpacingStyle.e());
            qVar.u("label");
            this.f28555b.toJson(qVar, attributeStyles$ComplexTextBasedLetterSpacingStyle.d());
            qVar.u("error");
            this.f28555b.toJson(qVar, attributeStyles$ComplexTextBasedLetterSpacingStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(72);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ComplexTextBasedLetterSpacingStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
