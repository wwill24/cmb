package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ComplexTextBasedTextColorStyleJsonAdapter extends h<AttributeStyles$ComplexTextBasedTextColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28558a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f28559b;

    public AttributeStyles_ComplexTextBasedTextColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "placeholder", "label", "error");
        j.f(a10, "of(\"value\", \"placeholder\", \"label\",\n      \"error\")");
        this.f28558a = a10;
        h<StyleElements.ComplexElementColor> f10 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"value\")");
        this.f28559b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ComplexTextBasedTextColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.ComplexElementColor complexElementColor = null;
        StyleElements.ComplexElementColor complexElementColor2 = null;
        StyleElements.ComplexElementColor complexElementColor3 = null;
        StyleElements.ComplexElementColor complexElementColor4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28558a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                complexElementColor = this.f28559b.fromJson(jsonReader);
            } else if (L == 1) {
                complexElementColor2 = this.f28559b.fromJson(jsonReader);
            } else if (L == 2) {
                complexElementColor3 = this.f28559b.fromJson(jsonReader);
            } else if (L == 3) {
                complexElementColor4 = this.f28559b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ComplexTextBasedTextColorStyle(complexElementColor, complexElementColor2, complexElementColor3, complexElementColor4);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ComplexTextBasedTextColorStyle != null) {
            qVar.c();
            qVar.u("value");
            this.f28559b.toJson(qVar, attributeStyles$ComplexTextBasedTextColorStyle.e());
            qVar.u("placeholder");
            this.f28559b.toJson(qVar, attributeStyles$ComplexTextBasedTextColorStyle.d());
            qVar.u("label");
            this.f28559b.toJson(qVar, attributeStyles$ComplexTextBasedTextColorStyle.c());
            qVar.u("error");
            this.f28559b.toJson(qVar, attributeStyles$ComplexTextBasedTextColorStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ComplexTextBasedTextColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
