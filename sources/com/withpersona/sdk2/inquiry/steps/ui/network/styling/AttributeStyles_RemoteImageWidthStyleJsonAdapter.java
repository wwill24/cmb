package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_RemoteImageWidthStyleJsonAdapter extends h<AttributeStyles$RemoteImageWidthStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28689a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Measurement> f28690b;

    public AttributeStyles_RemoteImageWidthStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28689a = a10;
        h<StyleElements.Measurement> f10 = sVar.f(StyleElements.Measurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28690b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$RemoteImageWidthStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Measurement measurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28689a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                measurement = this.f28690b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$RemoteImageWidthStyle(measurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$RemoteImageWidthStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28690b.toJson(qVar, attributeStyles$RemoteImageWidthStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.RemoteImageWidthStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
