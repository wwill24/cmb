package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ButtonBasedFontWeightStyleJsonAdapter extends h<AttributeStyles$ButtonBasedFontWeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28510a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.FontWeightContainer> f28511b;

    public AttributeStyles_ButtonBasedFontWeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28510a = a10;
        h<StyleElements.FontWeightContainer> f10 = sVar.f(StyleElements.FontWeightContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28511b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ButtonBasedFontWeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.FontWeightContainer fontWeightContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28510a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                fontWeightContainer = this.f28511b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ButtonBasedFontWeightStyle(fontWeightContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ButtonBasedFontWeightStyle attributeStyles$ButtonBasedFontWeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ButtonBasedFontWeightStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28511b.toJson(qVar, attributeStyles$ButtonBasedFontWeightStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ButtonBasedFontWeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
