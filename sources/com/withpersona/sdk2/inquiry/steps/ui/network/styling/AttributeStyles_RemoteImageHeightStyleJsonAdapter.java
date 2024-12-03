package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_RemoteImageHeightStyleJsonAdapter extends h<AttributeStyles$RemoteImageHeightStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28683a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Measurement> f28684b;

    public AttributeStyles_RemoteImageHeightStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28683a = a10;
        h<StyleElements.Measurement> f10 = sVar.f(StyleElements.Measurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28684b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$RemoteImageHeightStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Measurement measurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28683a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                measurement = this.f28684b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$RemoteImageHeightStyle(measurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$RemoteImageHeightStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28684b.toJson(qVar, attributeStyles$RemoteImageHeightStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.RemoteImageHeightStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
