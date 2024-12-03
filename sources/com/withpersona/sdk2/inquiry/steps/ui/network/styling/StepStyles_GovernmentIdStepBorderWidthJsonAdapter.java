package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepBorderWidthJsonAdapter extends h<StepStyles$GovernmentIdStepBorderWidth> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29056a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurementSet> f29057b;

    public StepStyles_GovernmentIdStepBorderWidthJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("governmentIdSelectOption", "governmentIdCaptureFeedBox", "governmentIdReviewImageBox");
        j.f(a10, "of(\"governmentIdSelectOp…ernmentIdReviewImageBox\")");
        this.f29056a = a10;
        h<StyleElements.DPMeasurementSet> f10 = sVar.f(StyleElements.DPMeasurementSet.class, n0.e(), "governmentIdSelectOption");
        j.f(f10, "moshi.adapter(StyleEleme…overnmentIdSelectOption\")");
        this.f29057b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepBorderWidth fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurementSet dPMeasurementSet = null;
        StyleElements.DPMeasurementSet dPMeasurementSet2 = null;
        StyleElements.DPMeasurementSet dPMeasurementSet3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29056a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurementSet = this.f29057b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurementSet2 = this.f29057b.fromJson(jsonReader);
            } else if (L == 2) {
                dPMeasurementSet3 = this.f29057b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepBorderWidth(dPMeasurementSet, dPMeasurementSet2, dPMeasurementSet3);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepBorderWidth != null) {
            qVar.c();
            qVar.u("governmentIdSelectOption");
            this.f29057b.toJson(qVar, stepStyles$GovernmentIdStepBorderWidth.d());
            qVar.u("governmentIdCaptureFeedBox");
            this.f29057b.toJson(qVar, stepStyles$GovernmentIdStepBorderWidth.a());
            qVar.u("governmentIdReviewImageBox");
            this.f29057b.toJson(qVar, stepStyles$GovernmentIdStepBorderWidth.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepBorderWidth");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
