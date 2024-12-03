package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_HeaderButtonColorStyleJsonAdapter extends h<AttributeStyles$HeaderButtonColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28593a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f28594b;

    public AttributeStyles_HeaderButtonColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("headerButton");
        j.f(a10, "of(\"headerButton\")");
        this.f28593a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "headerButton");
        j.f(f10, "moshi.adapter(StyleEleme…ptySet(), \"headerButton\")");
        this.f28594b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$HeaderButtonColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28593a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f28594b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$HeaderButtonColorStyle(simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$HeaderButtonColorStyle != null) {
            qVar.c();
            qVar.u("headerButton");
            this.f28594b.toJson(qVar, attributeStyles$HeaderButtonColorStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.HeaderButtonColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
