package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepBorderColorJsonAdapter extends h<StepStyles$DocumentStepBorderColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29018a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29019b;

    public StepStyles_DocumentStepBorderColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("imagePreview");
        j.f(a10, "of(\"imagePreview\")");
        this.f29018a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "imagePreview");
        j.f(f10, "moshi.adapter(StyleEleme…ptySet(), \"imagePreview\")");
        this.f29019b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepBorderColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29018a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29019b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepBorderColor(simpleElementColor);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepBorderColor stepStyles$DocumentStepBorderColor) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepBorderColor != null) {
            qVar.c();
            qVar.u("imagePreview");
            this.f29019b.toJson(qVar, stepStyles$DocumentStepBorderColor.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepBorderColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
