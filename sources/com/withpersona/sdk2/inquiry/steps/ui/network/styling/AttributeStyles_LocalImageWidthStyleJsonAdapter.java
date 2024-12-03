package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_LocalImageWidthStyleJsonAdapter extends h<AttributeStyles$LocalImageWidthStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28671a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Measurement> f28672b;

    public AttributeStyles_LocalImageWidthStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28671a = a10;
        h<StyleElements.Measurement> f10 = sVar.f(StyleElements.Measurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28672b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$LocalImageWidthStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Measurement measurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28671a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                measurement = this.f28672b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$LocalImageWidthStyle(measurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$LocalImageWidthStyle attributeStyles$LocalImageWidthStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$LocalImageWidthStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28672b.toJson(qVar, attributeStyles$LocalImageWidthStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.LocalImageWidthStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
