package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputRadioGroupFontFamilyStyleJsonAdapter extends h<AttributeStyles$InputRadioGroupFontFamilyStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28617a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontName> f28618b;

    public AttributeStyles_InputRadioGroupFontFamilyStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "error");
        j.f(a10, "of(\"base\", \"error\")");
        this.f28617a = a10;
        h<StyleElements.FontName> f10 = sVar.f(StyleElements.FontName.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28618b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputRadioGroupFontFamilyStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontName fontName = null;
        StyleElements.FontName fontName2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28617a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontName = this.f28618b.fromJson(jsonReader);
            } else if (L == 1) {
                fontName2 = this.f28618b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputRadioGroupFontFamilyStyle(fontName, fontName2);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputRadioGroupFontFamilyStyle attributeStyles$InputRadioGroupFontFamilyStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputRadioGroupFontFamilyStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28618b.toJson(qVar, attributeStyles$InputRadioGroupFontFamilyStyle.a());
            qVar.u("error");
            this.f28618b.toJson(qVar, attributeStyles$InputRadioGroupFontFamilyStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputRadioGroupFontFamilyStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
