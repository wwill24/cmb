package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputSelectTextFontWeightStyleJsonAdapter extends h<AttributeStyles$InputSelectTextFontWeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28645a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontWeightContainer> f28646b;

    public AttributeStyles_InputSelectTextFontWeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "label", "error");
        j.f(a10, "of(\"base\", \"label\", \"error\")");
        this.f28645a = a10;
        h<StyleElements.FontWeightContainer> f10 = sVar.f(StyleElements.FontWeightContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28646b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputSelectTextFontWeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontWeightContainer fontWeightContainer = null;
        StyleElements.FontWeightContainer fontWeightContainer2 = null;
        StyleElements.FontWeightContainer fontWeightContainer3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28645a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontWeightContainer = this.f28646b.fromJson(jsonReader);
            } else if (L == 1) {
                fontWeightContainer2 = this.f28646b.fromJson(jsonReader);
            } else if (L == 2) {
                fontWeightContainer3 = this.f28646b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputSelectTextFontWeightStyle(fontWeightContainer, fontWeightContainer2, fontWeightContainer3);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputSelectTextFontWeightStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28646b.toJson(qVar, attributeStyles$InputSelectTextFontWeightStyle.a());
            qVar.u("label");
            this.f28646b.toJson(qVar, attributeStyles$InputSelectTextFontWeightStyle.d());
            qVar.u("error");
            this.f28646b.toJson(qVar, attributeStyles$InputSelectTextFontWeightStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputSelectTextFontWeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
