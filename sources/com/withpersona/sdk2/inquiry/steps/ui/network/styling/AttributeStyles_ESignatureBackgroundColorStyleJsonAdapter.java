package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_ESignatureBackgroundColorStyleJsonAdapter extends h<AttributeStyles$ESignatureBackgroundColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28574a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f28575b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28576c;

    public AttributeStyles_ESignatureBackgroundColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "signaturePreview");
        j.f(a10, "of(\"base\", \"signaturePreview\")");
        this.f28574a = a10;
        h<StyleElements.ComplexElementColor> f10 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28575b = f10;
        h<StyleElements.SimpleElementColor> f11 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "signaturePreview");
        j.f(f11, "moshi.adapter(StyleEleme…et(), \"signaturePreview\")");
        this.f28576c = f11;
    }

    /* renamed from: a */
    public AttributeStyles$ESignatureBackgroundColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.ComplexElementColor complexElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28574a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                complexElementColor = this.f28575b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor = this.f28576c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$ESignatureBackgroundColorStyle(complexElementColor, simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$ESignatureBackgroundColorStyle attributeStyles$ESignatureBackgroundColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$ESignatureBackgroundColorStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28575b.toJson(qVar, attributeStyles$ESignatureBackgroundColorStyle.a());
            qVar.u("signaturePreview");
            this.f28576c.toJson(qVar, attributeStyles$ESignatureBackgroundColorStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.ESignatureBackgroundColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
