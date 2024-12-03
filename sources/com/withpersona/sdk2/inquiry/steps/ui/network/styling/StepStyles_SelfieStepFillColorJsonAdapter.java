package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepFillColorJsonAdapter extends h<StepStyles$SelfieStepFillColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29092a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29093b;

    public StepStyles_SelfieStepFillColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "selfieCaptureIconFillColor", "selfieCaptureIconBackgroundFillColor");
        j.f(a10, "of(\"base\",\n      \"selfie…IconBackgroundFillColor\")");
        this.f29092a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29093b = f10;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepFillColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29092a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29093b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29093b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f29093b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepFillColor(simpleElementColor, simpleElementColor2, simpleElementColor3);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepFillColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29093b.toJson(qVar, stepStyles$SelfieStepFillColor.a());
            qVar.u("selfieCaptureIconFillColor");
            this.f29093b.toJson(qVar, stepStyles$SelfieStepFillColor.d());
            qVar.u("selfieCaptureIconBackgroundFillColor");
            this.f29093b.toJson(qVar, stepStyles$SelfieStepFillColor.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepFillColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
