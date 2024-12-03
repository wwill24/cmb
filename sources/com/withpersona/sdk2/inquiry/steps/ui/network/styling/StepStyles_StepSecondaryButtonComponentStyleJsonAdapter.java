package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepSecondaryButtonComponentStyleJsonAdapter extends h<StepStyles$StepSecondaryButtonComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29139a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepCancelButtonComponentStyleContainer> f29140b;

    public StepStyles_StepSecondaryButtonComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29139a = a10;
        h<StepStyles$StepCancelButtonComponentStyleContainer> f10 = sVar.f(StepStyles$StepCancelButtonComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…emptySet(),\n      \"base\")");
        this.f29140b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepSecondaryButtonComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29139a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepCancelButtonComponentStyleContainer = this.f29140b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepSecondaryButtonComponentStyle(stepStyles$StepCancelButtonComponentStyleContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$StepSecondaryButtonComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29140b.toJson(qVar, stepStyles$StepSecondaryButtonComponentStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(66);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepSecondaryButtonComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
