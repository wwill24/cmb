package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_DPMeasurementJsonAdapter extends h<StyleElements.DPMeasurement> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29200a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPSize> f29201b;

    public StyleElements_DPMeasurementJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29200a = a10;
        h<StyleElements.DPSize> f10 = sVar.f(StyleElements.DPSize.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29201b = f10;
    }

    /* renamed from: a */
    public StyleElements.DPMeasurement fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPSize dPSize = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29200a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPSize = this.f29201b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.DPMeasurement(dPSize);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.DPMeasurement dPMeasurement) {
        j.g(qVar, "writer");
        if (dPMeasurement != null) {
            qVar.c();
            qVar.u("base");
            this.f29201b.toJson(qVar, dPMeasurement.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.DPMeasurement");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
