package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepBorderRadiusJsonAdapter extends h<StepStyles$GovernmentIdStepBorderRadius> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29054a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f29055b;

    public StepStyles_GovernmentIdStepBorderRadiusJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("modal", "governmentIdCaptureFeedBox", "governmentIdReviewImageBox");
        j.f(a10, "of(\"modal\",\n      \"gover…ernmentIdReviewImageBox\")");
        this.f29054a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "modal");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"modal\")");
        this.f29055b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepBorderRadius fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        StyleElements.DPMeasurement dPMeasurement2 = null;
        StyleElements.DPMeasurement dPMeasurement3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29054a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f29055b.fromJson(jsonReader);
            } else if (L == 1) {
                dPMeasurement2 = this.f29055b.fromJson(jsonReader);
            } else if (L == 2) {
                dPMeasurement3 = this.f29055b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepBorderRadius(dPMeasurement, dPMeasurement2, dPMeasurement3);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepBorderRadius != null) {
            qVar.c();
            qVar.u("modal");
            this.f29055b.toJson(qVar, stepStyles$GovernmentIdStepBorderRadius.d());
            qVar.u("governmentIdCaptureFeedBox");
            this.f29055b.toJson(qVar, stepStyles$GovernmentIdStepBorderRadius.a());
            qVar.u("governmentIdReviewImageBox");
            this.f29055b.toJson(qVar, stepStyles$GovernmentIdStepBorderRadius.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(61);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepBorderRadius");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
