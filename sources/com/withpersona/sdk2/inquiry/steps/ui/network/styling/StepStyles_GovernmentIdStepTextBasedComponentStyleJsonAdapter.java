package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepTextBasedComponentStyleJsonAdapter extends h<StepStyles$GovernmentIdStepTextBasedComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29084a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepTextBasedComponentStyleContainer> f29085b;

    public StepStyles_GovernmentIdStepTextBasedComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "governmentIdVerticalOption", "governmentIdCaptureHintText", "governmentIdProcessingText");
        j.f(a10, "of(\"base\",\n      \"govern…ernmentIdProcessingText\")");
        this.f29084a = a10;
        h<StepStyles$StepTextBasedComponentStyleContainer> f10 = sVar.f(StepStyles$StepTextBasedComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…java, emptySet(), \"base\")");
        this.f29085b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepTextBasedComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = null;
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer3 = null;
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29084a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepTextBasedComponentStyleContainer = this.f29085b.fromJson(jsonReader);
            } else if (L == 1) {
                stepStyles$StepTextBasedComponentStyleContainer2 = this.f29085b.fromJson(jsonReader);
            } else if (L == 2) {
                stepStyles$StepTextBasedComponentStyleContainer3 = this.f29085b.fromJson(jsonReader);
            } else if (L == 3) {
                stepStyles$StepTextBasedComponentStyleContainer4 = this.f29085b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepTextBasedComponentStyle(stepStyles$StepTextBasedComponentStyleContainer, stepStyles$StepTextBasedComponentStyleContainer2, stepStyles$StepTextBasedComponentStyleContainer3, stepStyles$StepTextBasedComponentStyleContainer4);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepTextBasedComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29085b.toJson(qVar, stepStyles$GovernmentIdStepTextBasedComponentStyle.a());
            qVar.u("governmentIdVerticalOption");
            this.f29085b.toJson(qVar, stepStyles$GovernmentIdStepTextBasedComponentStyle.e());
            qVar.u("governmentIdCaptureHintText");
            this.f29085b.toJson(qVar, stepStyles$GovernmentIdStepTextBasedComponentStyle.c());
            qVar.u("governmentIdProcessingText");
            this.f29085b.toJson(qVar, stepStyles$GovernmentIdStepTextBasedComponentStyle.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(72);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepTextBasedComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
