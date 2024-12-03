package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepBorderWidthJsonAdapter extends h<StepStyles$DocumentStepBorderWidth> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29022a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurementSet> f29023b;

    public StepStyles_DocumentStepBorderWidthJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("imagePreview");
        j.f(a10, "of(\"imagePreview\")");
        this.f29022a = a10;
        h<StyleElements.DPMeasurementSet> f10 = sVar.f(StyleElements.DPMeasurementSet.class, n0.e(), "imagePreview");
        j.f(f10, "moshi.adapter(StyleEleme…ptySet(), \"imagePreview\")");
        this.f29023b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepBorderWidth fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurementSet dPMeasurementSet = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29022a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurementSet = this.f29023b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepBorderWidth(dPMeasurementSet);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepBorderWidth stepStyles$DocumentStepBorderWidth) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepBorderWidth != null) {
            qVar.c();
            qVar.u("imagePreview");
            this.f29023b.toJson(qVar, stepStyles$DocumentStepBorderWidth.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepBorderWidth");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
