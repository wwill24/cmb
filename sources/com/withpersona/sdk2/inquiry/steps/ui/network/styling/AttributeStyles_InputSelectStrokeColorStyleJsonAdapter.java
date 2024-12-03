package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputSelectStrokeColorStyleJsonAdapter extends h<AttributeStyles$InputSelectStrokeColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28637a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28638b;

    public AttributeStyles_InputSelectStrokeColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("chevron", "headerCancelButton");
        j.f(a10, "of(\"chevron\", \"headerCancelButton\")");
        this.f28637a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "chevron");
        j.f(f10, "moshi.adapter(StyleEleme…a, emptySet(), \"chevron\")");
        this.f28638b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputSelectStrokeColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28637a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f28638b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f28638b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputSelectStrokeColorStyle(simpleElementColor, simpleElementColor2);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputSelectStrokeColorStyle != null) {
            qVar.c();
            qVar.u("chevron");
            this.f28638b.toJson(qVar, attributeStyles$InputSelectStrokeColorStyle.a());
            qVar.u("headerCancelButton");
            this.f28638b.toJson(qVar, attributeStyles$InputSelectStrokeColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(65);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputSelectStrokeColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
