package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_InputTextStrokeColorStyleJsonAdapter extends h<AttributeStyles$InputTextStrokeColorStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28659a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.ComplexElementColor> f28660b;

    public AttributeStyles_InputTextStrokeColorStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("maskToggle");
        j.f(a10, "of(\"maskToggle\")");
        this.f28659a = a10;
        h<StyleElements.ComplexElementColor> f10 = sVar.f(StyleElements.ComplexElementColor.class, n0.e(), "maskToggle");
        j.f(f10, "moshi.adapter(StyleEleme…emptySet(), \"maskToggle\")");
        this.f28660b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$InputTextStrokeColorStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.ComplexElementColor complexElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28659a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                complexElementColor = this.f28660b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$InputTextStrokeColorStyle(complexElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$InputTextStrokeColorStyle != null) {
            qVar.c();
            qVar.u("maskToggle");
            this.f28660b.toJson(qVar, attributeStyles$InputTextStrokeColorStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(63);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.InputTextStrokeColorStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
