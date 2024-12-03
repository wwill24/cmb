package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepBorderColorJsonAdapter extends h<StepStyles$SelfieStepBorderColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29088a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29089b;

    public StepStyles_SelfieStepBorderColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selfieCaptureFeedBox");
        j.f(a10, "of(\"selfieCaptureFeedBox\")");
        this.f29088a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "selfieCaptureFeedBox");
        j.f(f10, "moshi.adapter(StyleEleme…  \"selfieCaptureFeedBox\")");
        this.f29089b = f10;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepBorderColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29088a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29089b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepBorderColor(simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepBorderColor stepStyles$SelfieStepBorderColor) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepBorderColor != null) {
            qVar.c();
            qVar.u("selfieCaptureFeedBox");
            this.f29089b.toJson(qVar, stepStyles$SelfieStepBorderColor.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepBorderColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
