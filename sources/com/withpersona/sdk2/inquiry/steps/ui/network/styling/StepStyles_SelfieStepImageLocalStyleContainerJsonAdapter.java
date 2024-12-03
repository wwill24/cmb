package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_SelfieStepImageLocalStyleContainerJsonAdapter extends h<StepStyles$SelfieStepImageLocalStyleContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29094a;

    /* renamed from: b  reason: collision with root package name */
    private final h<LocalImageComponentStyle> f29095b;

    public StepStyles_SelfieStepImageLocalStyleContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29094a = a10;
        h<LocalImageComponentStyle> f10 = sVar.f(LocalImageComponentStyle.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(LocalImage…java, emptySet(), \"base\")");
        this.f29095b = f10;
    }

    /* renamed from: a */
    public StepStyles$SelfieStepImageLocalStyleContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        LocalImageComponentStyle localImageComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29094a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                localImageComponentStyle = this.f29095b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$SelfieStepImageLocalStyleContainer(localImageComponentStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$SelfieStepImageLocalStyleContainer stepStyles$SelfieStepImageLocalStyleContainer) {
        j.g(qVar, "writer");
        if (stepStyles$SelfieStepImageLocalStyleContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29095b.toJson(qVar, stepStyles$SelfieStepImageLocalStyleContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(67);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.SelfieStepImageLocalStyleContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
