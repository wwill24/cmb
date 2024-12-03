package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepSecondaryButtonComponentStyleJsonAdapter extends h<StepStyles$GovernmentIdStepSecondaryButtonComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29064a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepCancelButtonComponentStyleContainer> f29065b;

    public StepStyles_GovernmentIdStepSecondaryButtonComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "retakePhotoButton");
        j.f(a10, "of(\"base\", \"retakePhotoButton\")");
        this.f29064a = a10;
        h<StepStyles$StepCancelButtonComponentStyleContainer> f10 = sVar.f(StepStyles$StepCancelButtonComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…emptySet(),\n      \"base\")");
        this.f29065b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepSecondaryButtonComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer = null;
        StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29064a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepCancelButtonComponentStyleContainer = this.f29065b.fromJson(jsonReader);
            } else if (L == 1) {
                stepStyles$StepCancelButtonComponentStyleContainer2 = this.f29065b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepSecondaryButtonComponentStyle(stepStyles$StepCancelButtonComponentStyleContainer, stepStyles$StepCancelButtonComponentStyleContainer2);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepSecondaryButtonComponentStyle stepStyles$GovernmentIdStepSecondaryButtonComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepSecondaryButtonComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29065b.toJson(qVar, stepStyles$GovernmentIdStepSecondaryButtonComponentStyle.a());
            qVar.u("retakePhotoButton");
            this.f29065b.toJson(qVar, stepStyles$GovernmentIdStepSecondaryButtonComponentStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(78);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepSecondaryButtonComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
