package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_UiStepTitleComponentStyleJsonAdapter extends h<StepStyles$UiStepTitleComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29168a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepTextBasedComponentStyleContainer> f29169b;

    public StepStyles_UiStepTitleComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "uiStepProcessingTitle");
        j.f(a10, "of(\"base\", \"uiStepProcessingTitle\")");
        this.f29168a = a10;
        h<StepStyles$StepTextBasedComponentStyleContainer> f10 = sVar.f(StepStyles$StepTextBasedComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…java, emptySet(), \"base\")");
        this.f29169b = f10;
    }

    /* renamed from: a */
    public StepStyles$UiStepTitleComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29168a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepTextBasedComponentStyleContainer = this.f29169b.fromJson(jsonReader);
            } else if (L == 1) {
                stepStyles$StepTextBasedComponentStyleContainer2 = this.f29169b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$UiStepTitleComponentStyle(stepStyles$StepTextBasedComponentStyleContainer, stepStyles$StepTextBasedComponentStyleContainer2);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$UiStepTitleComponentStyle stepStyles$UiStepTitleComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$UiStepTitleComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29169b.toJson(qVar, stepStyles$UiStepTitleComponentStyle.a());
            qVar.u("uiStepProcessingTitle");
            this.f29169b.toJson(qVar, stepStyles$UiStepTitleComponentStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.UiStepTitleComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
