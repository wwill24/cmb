package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepBorderWidthJsonAdapter extends h<StepStyles$SelfieStepBorderWidth> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29090a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurementSet> f29091b;

    public StepStyles_SelfieStepBorderWidthJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selfieCaptureFeedBox");
        j.f(a10, "of(\"selfieCaptureFeedBox\")");
        this.f29090a = a10;
        h<StyleElements.DPMeasurementSet> f10 = sVar.f(StyleElements.DPMeasurementSet.class, n0.e(), "selfieCaptureFeedBox");
        j.f(f10, "moshi.adapter(StyleEleme…, \"selfieCaptureFeedBox\")");
        this.f29091b = f10;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepBorderWidth fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurementSet dPMeasurementSet = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29090a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurementSet = this.f29091b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepBorderWidth(dPMeasurementSet);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepBorderWidth stepStyles$SelfieStepBorderWidth) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepBorderWidth != null) {
            qVar.c();
            qVar.u("selfieCaptureFeedBox");
            this.f29091b.toJson(qVar, stepStyles$SelfieStepBorderWidth.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepBorderWidth");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
