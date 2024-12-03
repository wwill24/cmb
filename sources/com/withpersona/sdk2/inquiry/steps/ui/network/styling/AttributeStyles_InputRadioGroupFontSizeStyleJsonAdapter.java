package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputRadioGroupFontSizeStyleJsonAdapter extends h<AttributeStyles$InputRadioGroupFontSizeStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28619a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f28620b;

    public AttributeStyles_InputRadioGroupFontSizeStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "error");
        j.f(a10, "of(\"base\", \"error\")");
        this.f28619a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28620b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputRadioGroupFontSizeStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        StyleElements.DPMeasurement dPMeasurement2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28619a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f28620b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurement2 = this.f28620b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputRadioGroupFontSizeStyle(dPMeasurement, dPMeasurement2);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputRadioGroupFontSizeStyle attributeStyles$InputRadioGroupFontSizeStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputRadioGroupFontSizeStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28620b.toJson(qVar, attributeStyles$InputRadioGroupFontSizeStyle.a());
            qVar.u("error");
            this.f28620b.toJson(qVar, attributeStyles$InputRadioGroupFontSizeStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(66);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputRadioGroupFontSizeStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
