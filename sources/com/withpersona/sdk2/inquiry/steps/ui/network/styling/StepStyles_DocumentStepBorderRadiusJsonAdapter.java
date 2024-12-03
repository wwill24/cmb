package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepBorderRadiusJsonAdapter extends h<StepStyles$DocumentStepBorderRadius> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29020a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f29021b;

    public StepStyles_DocumentStepBorderRadiusJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("modal", "imagePreview");
        j.f(a10, "of(\"modal\", \"imagePreview\")");
        this.f29020a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "modal");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"modal\")");
        this.f29021b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepBorderRadius fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        StyleElements.DPMeasurement dPMeasurement2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29020a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f29021b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurement2 = this.f29021b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepBorderRadius(dPMeasurement, dPMeasurement2);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepBorderRadius stepStyles$DocumentStepBorderRadius) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepBorderRadius != null) {
            qVar.c();
            qVar.u("modal");
            this.f29021b.toJson(qVar, stepStyles$DocumentStepBorderRadius.c());
            qVar.u("imagePreview");
            this.f29021b.toJson(qVar, stepStyles$DocumentStepBorderRadius.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepBorderRadius");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
