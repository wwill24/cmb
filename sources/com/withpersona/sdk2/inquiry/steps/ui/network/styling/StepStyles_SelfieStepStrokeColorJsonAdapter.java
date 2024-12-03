package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepStrokeColorJsonAdapter extends h<StepStyles$SelfieStepStrokeColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29098a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29099b;

    public StepStyles_SelfieStepStrokeColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "selfieCaptureIconStrokeColor");
        j.f(a10, "of(\"base\",\n      \"selfieCaptureIconStrokeColor\")");
        this.f29098a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29099b = f10;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepStrokeColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29098a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29099b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29099b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepStrokeColor(simpleElementColor, simpleElementColor2);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepStrokeColor stepStyles$SelfieStepStrokeColor) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepStrokeColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29099b.toJson(qVar, stepStyles$SelfieStepStrokeColor.a());
            qVar.u("selfieCaptureIconStrokeColor");
            this.f29099b.toJson(qVar, stepStyles$SelfieStepStrokeColor.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepStrokeColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
