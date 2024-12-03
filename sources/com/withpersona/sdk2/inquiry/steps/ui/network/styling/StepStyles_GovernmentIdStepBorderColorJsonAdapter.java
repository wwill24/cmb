package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_GovernmentIdStepBorderColorJsonAdapter extends h<StepStyles$GovernmentIdStepBorderColor> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29052a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.SimpleElementColor> f29053b;

    public StepStyles_GovernmentIdStepBorderColorJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base", "governmentIdSelectOption", "governmentIdCaptureFeedBox", "governmentIdReviewImageBox");
        j.f(a10, "of(\"base\",\n      \"govern…ernmentIdReviewImageBox\")");
        this.f29052a = a10;
        h<StyleElements.SimpleElementColor> f10 = sVar.f(StyleElements.SimpleElementColor.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29053b = f10;
    }

    /* renamed from: a */
    public StepStyles$GovernmentIdStepBorderColor fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.SimpleElementColor simpleElementColor = null;
        StyleElements.SimpleElementColor simpleElementColor2 = null;
        StyleElements.SimpleElementColor simpleElementColor3 = null;
        StyleElements.SimpleElementColor simpleElementColor4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29052a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                simpleElementColor = this.f29053b.fromJson(jsonReader);
            } else if (L == 1) {
                simpleElementColor2 = this.f29053b.fromJson(jsonReader);
            } else if (L == 2) {
                simpleElementColor3 = this.f29053b.fromJson(jsonReader);
            } else if (L == 3) {
                simpleElementColor4 = this.f29053b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$GovernmentIdStepBorderColor(simpleElementColor, simpleElementColor2, simpleElementColor3, simpleElementColor4);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor) {
        j.g(qVar, "writer");
        if (stepStyles$GovernmentIdStepBorderColor != null) {
            qVar.c();
            qVar.u("base");
            this.f29053b.toJson(qVar, stepStyles$GovernmentIdStepBorderColor.a());
            qVar.u("governmentIdSelectOption");
            this.f29053b.toJson(qVar, stepStyles$GovernmentIdStepBorderColor.e());
            qVar.u("governmentIdCaptureFeedBox");
            this.f29053b.toJson(qVar, stepStyles$GovernmentIdStepBorderColor.c());
            qVar.u("governmentIdReviewImageBox");
            this.f29053b.toJson(qVar, stepStyles$GovernmentIdStepBorderColor.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.GovernmentIdStepBorderColor");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
