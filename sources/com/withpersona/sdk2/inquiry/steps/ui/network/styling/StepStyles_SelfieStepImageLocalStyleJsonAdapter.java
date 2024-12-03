package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepImageLocalStyleJsonAdapter extends h<StepStyles$SelfieStepImageLocalStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29096a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$SelfieStepImageLocalStyleContainer> f29097b;

    public StepStyles_SelfieStepImageLocalStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selfieStartIcon");
        j.f(a10, "of(\"selfieStartIcon\")");
        this.f29096a = a10;
        h<StepStyles$SelfieStepImageLocalStyleContainer> f10 = sVar.f(StepStyles$SelfieStepImageLocalStyleContainer.class, n0.e(), "selfieStartIcon");
        j.f(f10, "moshi.adapter(StepStyles…\n      \"selfieStartIcon\")");
        this.f29097b = f10;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepImageLocalStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$SelfieStepImageLocalStyleContainer stepStyles$SelfieStepImageLocalStyleContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29096a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$SelfieStepImageLocalStyleContainer = this.f29097b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepImageLocalStyle(stepStyles$SelfieStepImageLocalStyleContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepImageLocalStyle stepStyles$SelfieStepImageLocalStyle) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepImageLocalStyle != null) {
            qVar.c();
            qVar.u("selfieStartIcon");
            this.f29097b.toJson(qVar, stepStyles$SelfieStepImageLocalStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepImageLocalStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
