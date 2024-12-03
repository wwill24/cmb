package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputRadioGroupFontWeightStyleJsonAdapter extends h<AttributeStyles$InputRadioGroupFontWeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28621a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontWeightContainer> f28622b;

    public AttributeStyles_InputRadioGroupFontWeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "error");
        j.f(a10, "of(\"base\", \"error\")");
        this.f28621a = a10;
        h<StyleElements.FontWeightContainer> f10 = sVar.f(StyleElements.FontWeightContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28622b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputRadioGroupFontWeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontWeightContainer fontWeightContainer = null;
        StyleElements.FontWeightContainer fontWeightContainer2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28621a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontWeightContainer = this.f28622b.fromJson(jsonReader);
            } else if (L == 1) {
                fontWeightContainer2 = this.f28622b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputRadioGroupFontWeightStyle(fontWeightContainer, fontWeightContainer2);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputRadioGroupFontWeightStyle attributeStyles$InputRadioGroupFontWeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputRadioGroupFontWeightStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28622b.toJson(qVar, attributeStyles$InputRadioGroupFontWeightStyle.a());
            qVar.u("error");
            this.f28622b.toJson(qVar, attributeStyles$InputRadioGroupFontWeightStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputRadioGroupFontWeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
