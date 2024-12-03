package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_DateSelectStrokeColorStyleJsonAdapter extends h<AttributeStyles$DateSelectStrokeColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28569a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28570b;

    public AttributeStyles_DateSelectStrokeColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("chevron");
        j.f(a10, "of(\"chevron\")");
        this.f28569a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "chevron");
        j.f(f10, "moshi.adapter(StyleEleme…a, emptySet(), \"chevron\")");
        this.f28570b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$DateSelectStrokeColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28569a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f28570b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$DateSelectStrokeColorStyle(simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$DateSelectStrokeColorStyle != null) {
            qVar.c();
            qVar.u("chevron");
            this.f28570b.toJson(qVar, attributeStyles$DateSelectStrokeColorStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.DateSelectStrokeColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
