package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepBackgroundImageStyleContainerJsonAdapter extends h<StepStyles$StepBackgroundImageStyleContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29125a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundImageNameContainer> f29126b;

    public StepStyles_StepBackgroundImageStyleContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29125a = a10;
        h<StepStyles$StepBackgroundImageNameContainer> f10 = sVar.f(StepStyles$StepBackgroundImageNameContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…java, emptySet(), \"base\")");
        this.f29126b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepBackgroundImageStyleContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepBackgroundImageNameContainer stepStyles$StepBackgroundImageNameContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29125a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepBackgroundImageNameContainer = this.f29126b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepBackgroundImageStyleContainer(stepStyles$StepBackgroundImageNameContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepBackgroundImageStyleContainer stepStyles$StepBackgroundImageStyleContainer) {
        j.g(qVar, "writer");
        if (stepStyles$StepBackgroundImageStyleContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29126b.toJson(qVar, stepStyles$StepBackgroundImageStyleContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(66);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepBackgroundImageStyleContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
