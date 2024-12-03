package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ComplexTextBasedFontFamilyStyleJsonAdapter extends h<AttributeStyles$ComplexTextBasedFontFamilyStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28548a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontName> f28549b;

    public AttributeStyles_ComplexTextBasedFontFamilyStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "value", "placeholder", "label", "error");
        j.f(a10, "of(\"base\", \"value\", \"pla…,\n      \"label\", \"error\")");
        this.f28548a = a10;
        h<StyleElements.FontName> f10 = sVar.f(StyleElements.FontName.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28549b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ComplexTextBasedFontFamilyStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontName fontName = null;
        StyleElements.FontName fontName2 = null;
        StyleElements.FontName fontName3 = null;
        StyleElements.FontName fontName4 = null;
        StyleElements.FontName fontName5 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28548a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontName = this.f28549b.fromJson(jsonReader);
            } else if (L == 1) {
                fontName2 = this.f28549b.fromJson(jsonReader);
            } else if (L == 2) {
                fontName3 = this.f28549b.fromJson(jsonReader);
            } else if (L == 3) {
                fontName4 = this.f28549b.fromJson(jsonReader);
            } else if (L == 4) {
                fontName5 = this.f28549b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ComplexTextBasedFontFamilyStyle(fontName, fontName2, fontName3, fontName4, fontName5);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ComplexTextBasedFontFamilyStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28549b.toJson(qVar, attributeStyles$ComplexTextBasedFontFamilyStyle.a());
            qVar.u("value");
            this.f28549b.toJson(qVar, attributeStyles$ComplexTextBasedFontFamilyStyle.f());
            qVar.u("placeholder");
            this.f28549b.toJson(qVar, attributeStyles$ComplexTextBasedFontFamilyStyle.e());
            qVar.u("label");
            this.f28549b.toJson(qVar, attributeStyles$ComplexTextBasedFontFamilyStyle.d());
            qVar.u("error");
            this.f28549b.toJson(qVar, attributeStyles$ComplexTextBasedFontFamilyStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ComplexTextBasedFontFamilyStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
