package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepPrimaryButtonComponentStyleJsonAdapter extends h<StepStyles$GovernmentIdStepPrimaryButtonComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29060a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepSubmitButtonComponentStyleContainer> f29061b;

    public StepStyles_GovernmentIdStepPrimaryButtonComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "submitPhotoButton");
        j.f(a10, "of(\"base\", \"submitPhotoButton\")");
        this.f29060a = a10;
        h<StepStyles$StepSubmitButtonComponentStyleContainer> f10 = sVar.f(StepStyles$StepSubmitButtonComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…emptySet(),\n      \"base\")");
        this.f29061b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepPrimaryButtonComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer = null;
        StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29060a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepSubmitButtonComponentStyleContainer = this.f29061b.fromJson(jsonReader);
            } else if (L == 1) {
                stepStyles$StepSubmitButtonComponentStyleContainer2 = this.f29061b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepPrimaryButtonComponentStyle(stepStyles$StepSubmitButtonComponentStyleContainer, stepStyles$StepSubmitButtonComponentStyleContainer2);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepPrimaryButtonComponentStyle stepStyles$GovernmentIdStepPrimaryButtonComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepPrimaryButtonComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29061b.toJson(qVar, stepStyles$GovernmentIdStepPrimaryButtonComponentStyle.a());
            qVar.u("submitPhotoButton");
            this.f29061b.toJson(qVar, stepStyles$GovernmentIdStepPrimaryButtonComponentStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(76);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepPrimaryButtonComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
