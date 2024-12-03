package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputSelectTextFontFamilyStyleJsonAdapter extends h<AttributeStyles$InputSelectTextFontFamilyStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28641a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontName> f28642b;

    public AttributeStyles_InputSelectTextFontFamilyStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "label", "error");
        j.f(a10, "of(\"base\", \"label\", \"error\")");
        this.f28641a = a10;
        h<StyleElements.FontName> f10 = sVar.f(StyleElements.FontName.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28642b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputSelectTextFontFamilyStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontName fontName = null;
        StyleElements.FontName fontName2 = null;
        StyleElements.FontName fontName3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28641a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontName = this.f28642b.fromJson(jsonReader);
            } else if (L == 1) {
                fontName2 = this.f28642b.fromJson(jsonReader);
            } else if (L == 2) {
                fontName3 = this.f28642b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputSelectTextFontFamilyStyle(fontName, fontName2, fontName3);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputSelectTextFontFamilyStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28642b.toJson(qVar, attributeStyles$InputSelectTextFontFamilyStyle.a());
            qVar.u("label");
            this.f28642b.toJson(qVar, attributeStyles$InputSelectTextFontFamilyStyle.d());
            qVar.u("error");
            this.f28642b.toJson(qVar, attributeStyles$InputSelectTextFontFamilyStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputSelectTextFontFamilyStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
