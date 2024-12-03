package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputSelectTextColorStyleJsonAdapter extends h<AttributeStyles$InputSelectTextColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28639a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28640b;

    public AttributeStyles_InputSelectTextColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "label", "error");
        j.f(a10, "of(\"base\", \"label\", \"error\")");
        this.f28639a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28640b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputSelectTextColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28639a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f28640b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f28640b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f28640b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputSelectTextColorStyle(simpleElementColor, simpleElementColor2, simpleElementColor3);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputSelectTextColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28640b.toJson(qVar, attributeStyles$InputSelectTextColorStyle.a());
            qVar.u("label");
            this.f28640b.toJson(qVar, attributeStyles$InputSelectTextColorStyle.d());
            qVar.u("error");
            this.f28640b.toJson(qVar, attributeStyles$InputSelectTextColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(63);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputSelectTextColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
