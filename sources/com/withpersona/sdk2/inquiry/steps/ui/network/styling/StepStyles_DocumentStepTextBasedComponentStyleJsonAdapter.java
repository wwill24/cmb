package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepTextBasedComponentStyleJsonAdapter extends h<StepStyles$DocumentStepTextBasedComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29048a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepTextBasedComponentStyleContainer> f29049b;

    public StepStyles_DocumentStepTextBasedComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "documentProcessingText", "imageName");
        j.f(a10, "of(\"base\", \"documentProc…Text\",\n      \"imageName\")");
        this.f29048a = a10;
        h<StepStyles$StepTextBasedComponentStyleContainer> f10 = sVar.f(StepStyles$StepTextBasedComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…java, emptySet(), \"base\")");
        this.f29049b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepTextBasedComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer = null;
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer2 = null;
        StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29048a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepTextBasedComponentStyleContainer = this.f29049b.fromJson(jsonReader);
            } else if (L == 1) {
                stepStyles$StepTextBasedComponentStyleContainer2 = this.f29049b.fromJson(jsonReader);
            } else if (L == 2) {
                stepStyles$StepTextBasedComponentStyleContainer3 = this.f29049b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepTextBasedComponentStyle(stepStyles$StepTextBasedComponentStyleContainer, stepStyles$StepTextBasedComponentStyleContainer2, stepStyles$StepTextBasedComponentStyleContainer3);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepTextBasedComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29049b.toJson(qVar, stepStyles$DocumentStepTextBasedComponentStyle.a());
            qVar.u("documentProcessingText");
            this.f29049b.toJson(qVar, stepStyles$DocumentStepTextBasedComponentStyle.c());
            qVar.u("imageName");
            this.f29049b.toJson(qVar, stepStyles$DocumentStepTextBasedComponentStyle.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepTextBasedComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
