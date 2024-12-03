package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ComplexTextBasedFontWeightStyleJsonAdapter extends h<AttributeStyles$ComplexTextBasedFontWeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28552a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontWeightContainer> f28553b;

    public AttributeStyles_ComplexTextBasedFontWeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "placeholder", "label", "error");
        j.f(a10, "of(\"value\", \"placeholder\", \"label\",\n      \"error\")");
        this.f28552a = a10;
        h<StyleElements.FontWeightContainer> f10 = sVar.f(StyleElements.FontWeightContainer.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"value\")");
        this.f28553b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ComplexTextBasedFontWeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontWeightContainer fontWeightContainer = null;
        StyleElements.FontWeightContainer fontWeightContainer2 = null;
        StyleElements.FontWeightContainer fontWeightContainer3 = null;
        StyleElements.FontWeightContainer fontWeightContainer4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28552a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontWeightContainer = this.f28553b.fromJson(jsonReader);
            } else if (L == 1) {
                fontWeightContainer2 = this.f28553b.fromJson(jsonReader);
            } else if (L == 2) {
                fontWeightContainer3 = this.f28553b.fromJson(jsonReader);
            } else if (L == 3) {
                fontWeightContainer4 = this.f28553b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ComplexTextBasedFontWeightStyle(fontWeightContainer, fontWeightContainer2, fontWeightContainer3, fontWeightContainer4);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ComplexTextBasedFontWeightStyle != null) {
            qVar.c();
            qVar.u("value");
            this.f28553b.toJson(qVar, attributeStyles$ComplexTextBasedFontWeightStyle.e());
            qVar.u("placeholder");
            this.f28553b.toJson(qVar, attributeStyles$ComplexTextBasedFontWeightStyle.d());
            qVar.u("label");
            this.f28553b.toJson(qVar, attributeStyles$ComplexTextBasedFontWeightStyle.c());
            qVar.u("error");
            this.f28553b.toJson(qVar, attributeStyles$ComplexTextBasedFontWeightStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ComplexTextBasedFontWeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
