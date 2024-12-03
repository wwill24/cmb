package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AttributeStyles_QRCodeWidthStyleJsonAdapter extends h<AttributeStyles$QRCodeWidthStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28681a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Measurement> f28682b;

    public AttributeStyles_QRCodeWidthStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f28681a = a10;
        h<StyleElements.Measurement> f10 = sVar.f(StyleElements.Measurement.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f28682b = f10;
    }

    /* renamed from: a */
    public AttributeStyles$QRCodeWidthStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Measurement measurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28681a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                measurement = this.f28682b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new AttributeStyles$QRCodeWidthStyle(measurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, AttributeStyles$QRCodeWidthStyle attributeStyles$QRCodeWidthStyle) {
        j.g(qVar, "writer");
        if (attributeStyles$QRCodeWidthStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f28682b.toJson(qVar, attributeStyles$QRCodeWidthStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AttributeStyles.QRCodeWidthStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
