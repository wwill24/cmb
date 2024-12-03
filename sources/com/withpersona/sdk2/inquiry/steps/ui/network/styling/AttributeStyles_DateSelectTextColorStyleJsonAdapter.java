package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_DateSelectTextColorStyleJsonAdapter extends h<AttributeStyles$DateSelectTextColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28571a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f28572b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28573c;

    public AttributeStyles_DateSelectTextColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "placeholder", "label", "error", "inputSelect");
        j.f(a10, "of(\"value\", \"placeholder…  \"error\", \"inputSelect\")");
        this.f28571a = a10;
        h<StyleElements.ComplexElementColor> f10 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"value\")");
        this.f28572b = f10;
        h<StyleElements.SimpleElementColor> f11 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "inputSelect");
        j.f(f11, "moshi.adapter(StyleEleme…mptySet(), \"inputSelect\")");
        this.f28573c = f11;
    }

    /* renamed from: a */
    public AttributeStyles$DateSelectTextColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.ComplexElementColor complexElementColor = null;
        StyleElements.ComplexElementColor complexElementColor2 = null;
        StyleElements.ComplexElementColor complexElementColor3 = null;
        StyleElements.ComplexElementColor complexElementColor4 = null;
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28571a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                complexElementColor = this.f28572b.fromJson(jsonReader);
            } else if (L == 1) {
                complexElementColor2 = this.f28572b.fromJson(jsonReader);
            } else if (L == 2) {
                complexElementColor3 = this.f28572b.fromJson(jsonReader);
            } else if (L == 3) {
                complexElementColor4 = this.f28572b.fromJson(jsonReader);
            } else if (L == 4) {
                simpleElementColor = this.f28573c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$DateSelectTextColorStyle(complexElementColor, complexElementColor2, complexElementColor3, complexElementColor4, simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$DateSelectTextColorStyle != null) {
            qVar.c();
            qVar.u("value");
            this.f28572b.toJson(qVar, attributeStyles$DateSelectTextColorStyle.f());
            qVar.u("placeholder");
            this.f28572b.toJson(qVar, attributeStyles$DateSelectTextColorStyle.e());
            qVar.u("label");
            this.f28572b.toJson(qVar, attributeStyles$DateSelectTextColorStyle.d());
            qVar.u("error");
            this.f28572b.toJson(qVar, attributeStyles$DateSelectTextColorStyle.a());
            qVar.u("inputSelect");
            this.f28573c.toJson(qVar, attributeStyles$DateSelectTextColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.DateSelectTextColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
