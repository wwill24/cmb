package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepFillColorJsonAdapter extends h<StepStyles$GovernmentIdStepFillColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29058a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29059b;

    public StepStyles_GovernmentIdStepFillColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "governmentIdSelectOptionIcon", "capturePageHintIcon");
        j.f(a10, "of(\"base\",\n      \"govern…\", \"capturePageHintIcon\")");
        this.f29058a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29059b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepFillColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29058a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29059b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29059b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f29059b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepFillColor(simpleElementColor, simpleElementColor2, simpleElementColor3);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepFillColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29059b.toJson(qVar, stepStyles$GovernmentIdStepFillColor.a());
            qVar.u("governmentIdSelectOptionIcon");
            this.f29059b.toJson(qVar, stepStyles$GovernmentIdStepFillColor.d());
            qVar.u("capturePageHintIcon");
            this.f29059b.toJson(qVar, stepStyles$GovernmentIdStepFillColor.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepFillColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
