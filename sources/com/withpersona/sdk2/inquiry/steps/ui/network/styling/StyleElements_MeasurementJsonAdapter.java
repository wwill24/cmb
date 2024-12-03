package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_MeasurementJsonAdapter extends h<StyleElements.Measurement> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29208a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.Size> f29209b;

    public StyleElements_MeasurementJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29208a = a10;
        h<StyleElements.Size> f10 = sVar.f(StyleElements.Size.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29209b = f10;
    }

    /* renamed from: a */
    public StyleElements.Measurement fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.Size size = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29208a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                size = this.f29209b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.Measurement(size);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.Measurement measurement) {
        j.g(qVar, "writer");
        if (measurement != null) {
            qVar.c();
            qVar.u("base");
            this.f29209b.toJson(qVar, measurement.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.Measurement");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
