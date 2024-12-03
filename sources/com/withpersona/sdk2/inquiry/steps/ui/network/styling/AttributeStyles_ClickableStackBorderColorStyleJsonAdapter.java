package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ClickableStackBorderColorStyleJsonAdapter extends h<AttributeStyles$ClickableStackBorderColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28534a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f28535b;

    public AttributeStyles_ClickableStackBorderColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28534a = a10;
        h<StyleElements.ComplexElementColor> f10 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28535b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$ClickableStackBorderColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.ComplexElementColor complexElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28534a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                complexElementColor = this.f28535b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ClickableStackBorderColorStyle(complexElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ClickableStackBorderColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28535b.toJson(qVar, attributeStyles$ClickableStackBorderColorStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ClickableStackBorderColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
