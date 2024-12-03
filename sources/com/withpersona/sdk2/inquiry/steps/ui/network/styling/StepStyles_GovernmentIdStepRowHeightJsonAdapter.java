package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepRowHeightJsonAdapter extends h<StepStyles$GovernmentIdStepRowHeight> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29062a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f29063b;

    public StepStyles_GovernmentIdStepRowHeightJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("governmentIdSelectOptionMinRowHeight");
        j.f(a10, "of(\"governmentIdSelectOptionMinRowHeight\")");
        this.f29062a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "governmentIdSelectOptionMinRowHeight");
        j.f(f10, "moshi.adapter(StyleEleme…electOptionMinRowHeight\")");
        this.f29063b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepRowHeight fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29062a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f29063b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepRowHeight(dPMeasurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepRowHeight stepStyles$GovernmentIdStepRowHeight) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepRowHeight != null) {
            qVar.c();
            qVar.u("governmentIdSelectOptionMinRowHeight");
            this.f29063b.toJson(qVar, stepStyles$GovernmentIdStepRowHeight.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepRowHeight");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
