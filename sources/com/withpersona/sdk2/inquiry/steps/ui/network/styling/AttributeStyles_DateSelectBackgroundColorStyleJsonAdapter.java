package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_DateSelectBackgroundColorStyleJsonAdapter extends h<AttributeStyles$DateSelectBackgroundColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28560a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f28561b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28562c;

    public AttributeStyles_DateSelectBackgroundColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "inputSelect");
        j.f(a10, "of(\"base\", \"inputSelect\")");
        this.f28560a = a10;
        h<StyleElements.ComplexElementColor> f10 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28561b = f10;
        h<StyleElements.SimpleElementColor> f11 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "inputSelect");
        j.f(f11, "moshi.adapter(StyleEleme…mptySet(), \"inputSelect\")");
        this.f28562c = f11;
    }

    /* renamed from: a */
    public AttributeStyles$DateSelectBackgroundColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.ComplexElementColor complexElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28560a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                complexElementColor = this.f28561b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor = this.f28562c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$DateSelectBackgroundColorStyle(complexElementColor, simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$DateSelectBackgroundColorStyle attributeStyles$DateSelectBackgroundColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$DateSelectBackgroundColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28561b.toJson(qVar, attributeStyles$DateSelectBackgroundColorStyle.a());
            qVar.u("inputSelect");
            this.f28562c.toJson(qVar, attributeStyles$DateSelectBackgroundColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.DateSelectBackgroundColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
