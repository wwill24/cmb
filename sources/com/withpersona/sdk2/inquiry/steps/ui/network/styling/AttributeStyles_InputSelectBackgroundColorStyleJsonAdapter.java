package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputSelectBackgroundColorStyleJsonAdapter extends h<AttributeStyles$InputSelectBackgroundColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28629a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28630b;

    public AttributeStyles_InputSelectBackgroundColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28629a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28630b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputSelectBackgroundColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28629a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f28630b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputSelectBackgroundColorStyle(simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputSelectBackgroundColorStyle attributeStyles$InputSelectBackgroundColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputSelectBackgroundColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28630b.toJson(qVar, attributeStyles$InputSelectBackgroundColorStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputSelectBackgroundColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
