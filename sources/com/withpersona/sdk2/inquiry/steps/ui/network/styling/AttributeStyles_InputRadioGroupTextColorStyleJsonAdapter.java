package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputRadioGroupTextColorStyleJsonAdapter extends h<AttributeStyles$InputRadioGroupTextColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28627a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28628b;

    public AttributeStyles_InputRadioGroupTextColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "error");
        j.f(a10, "of(\"base\", \"error\")");
        this.f28627a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28628b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputRadioGroupTextColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28627a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f28628b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f28628b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputRadioGroupTextColorStyle(simpleElementColor, simpleElementColor2);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputRadioGroupTextColorStyle attributeStyles$InputRadioGroupTextColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputRadioGroupTextColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28628b.toJson(qVar, attributeStyles$InputRadioGroupTextColorStyle.a());
            qVar.u("error");
            this.f28628b.toJson(qVar, attributeStyles$InputRadioGroupTextColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputRadioGroupTextColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
