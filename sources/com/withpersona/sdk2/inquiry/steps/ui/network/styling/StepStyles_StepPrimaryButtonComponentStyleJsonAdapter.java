package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepPrimaryButtonComponentStyleJsonAdapter extends h<StepStyles$StepPrimaryButtonComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29137a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepSubmitButtonComponentStyleContainer> f29138b;

    public StepStyles_StepPrimaryButtonComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29137a = a10;
        h<StepStyles$StepSubmitButtonComponentStyleContainer> f10 = sVar.f(StepStyles$StepSubmitButtonComponentStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…emptySet(),\n      \"base\")");
        this.f29138b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepPrimaryButtonComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29137a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepSubmitButtonComponentStyleContainer = this.f29138b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepPrimaryButtonComponentStyle(stepStyles$StepSubmitButtonComponentStyleContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle) {
        j.g(qVar, "writer");
        if (stepStyles$StepPrimaryButtonComponentStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29138b.toJson(qVar, stepStyles$StepPrimaryButtonComponentStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepPrimaryButtonComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
