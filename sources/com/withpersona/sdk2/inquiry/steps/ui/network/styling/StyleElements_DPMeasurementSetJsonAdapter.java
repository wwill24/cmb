package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_DPMeasurementSetJsonAdapter extends h<StyleElements.DPMeasurementSet> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29202a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPSizeSet> f29203b;

    public StyleElements_DPMeasurementSetJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29202a = a10;
        h<StyleElements.DPSizeSet> f10 = sVar.f(StyleElements.DPSizeSet.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29203b = f10;
    }

    /* renamed from: a */
    public StyleElements.DPMeasurementSet fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPSizeSet dPSizeSet = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29202a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPSizeSet = this.f29203b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.DPMeasurementSet(dPSizeSet);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.DPMeasurementSet dPMeasurementSet) {
        j.g(qVar, "writer");
        if (dPMeasurementSet != null) {
            qVar.c();
            qVar.u("base");
            this.f29203b.toJson(qVar, dPMeasurementSet.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.DPMeasurementSet");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
