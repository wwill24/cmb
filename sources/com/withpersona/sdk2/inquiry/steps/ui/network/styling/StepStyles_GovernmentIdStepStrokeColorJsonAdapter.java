package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepStrokeColorJsonAdapter extends h<StepStyles$GovernmentIdStepStrokeColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29066a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29067b;

    public StepStyles_GovernmentIdStepStrokeColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "governmentIdSelectOptionIcon", "governmentIdSelectOptionChevron", "capturePageHintIcon");
        j.f(a10, "of(\"base\",\n      \"govern…\", \"capturePageHintIcon\")");
        this.f29066a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29067b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepStrokeColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        StyleElements.SimpleElementColor simpleElementColor4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29066a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29067b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29067b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f29067b.fromJson(jsonReader);
            } else if (L == 3) {
                simpleElementColor4 = this.f29067b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepStrokeColor(simpleElementColor, simpleElementColor2, simpleElementColor3, simpleElementColor4);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepStrokeColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29067b.toJson(qVar, stepStyles$GovernmentIdStepStrokeColor.a());
            qVar.u("governmentIdSelectOptionIcon");
            this.f29067b.toJson(qVar, stepStyles$GovernmentIdStepStrokeColor.e());
            qVar.u("governmentIdSelectOptionChevron");
            this.f29067b.toJson(qVar, stepStyles$GovernmentIdStepStrokeColor.d());
            qVar.u("capturePageHintIcon");
            this.f29067b.toJson(qVar, stepStyles$GovernmentIdStepStrokeColor.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepStrokeColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
