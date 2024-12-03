package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_TextBasedFontWeightStyleJsonAdapter extends h<AttributeStyles$TextBasedFontWeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28699a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontWeightContainer> f28700b;

    public AttributeStyles_TextBasedFontWeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28699a = a10;
        h<StyleElements.FontWeightContainer> f10 = sVar.f(StyleElements.FontWeightContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28700b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$TextBasedFontWeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontWeightContainer fontWeightContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28699a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontWeightContainer = this.f28700b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$TextBasedFontWeightStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28700b.toJson(qVar, attributeStyles$TextBasedFontWeightStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.TextBasedFontWeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
