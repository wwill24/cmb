package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_LocalImageHeightStyleJsonAdapter extends h<AttributeStyles$LocalImageHeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28663a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Measurement> f28664b;

    public AttributeStyles_LocalImageHeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28663a = a10;
        h<StyleElements.Measurement> f10 = sVar.f(StyleElements.Measurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28664b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$LocalImageHeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Measurement measurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28663a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                measurement = this.f28664b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$LocalImageHeightStyle(measurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$LocalImageHeightStyle attributeStyles$LocalImageHeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$LocalImageHeightStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28664b.toJson(qVar, attributeStyles$LocalImageHeightStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.LocalImageHeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
