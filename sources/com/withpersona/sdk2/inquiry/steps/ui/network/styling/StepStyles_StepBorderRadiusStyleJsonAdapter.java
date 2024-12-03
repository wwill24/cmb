package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepBorderRadiusStyleJsonAdapter extends h<StepStyles$StepBorderRadiusStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29129a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPMeasurement> f29130b;

    public StepStyles_StepBorderRadiusStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("modal");
        j.f(a10, "of(\"modal\")");
        this.f29129a = a10;
        h<StyleElements.DPMeasurement> f10 = sVar.f(StyleElements.DPMeasurement.class, n0.e(), "modal");
        j.f(f10, "moshi.adapter(StyleEleme…ava, emptySet(), \"modal\")");
        this.f29130b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepBorderRadiusStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPMeasurement dPMeasurement = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29129a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPMeasurement = this.f29130b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepBorderRadiusStyle(dPMeasurement);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle) {
        j.g(qVar, "writer");
        if (stepStyles$StepBorderRadiusStyle != null) {
            qVar.c();
            qVar.u("modal");
            this.f29130b.toJson(qVar, stepStyles$StepBorderRadiusStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepBorderRadiusStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
