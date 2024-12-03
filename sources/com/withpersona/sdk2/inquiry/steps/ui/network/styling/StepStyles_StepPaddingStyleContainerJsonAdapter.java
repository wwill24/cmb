package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepPaddingStyleContainerJsonAdapter extends h<StepStyles$StepPaddingStyleContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29133a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPSizeSet> f29134b;

    public StepStyles_StepPaddingStyleContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29133a = a10;
        h<StyleElements.DPSizeSet> f10 = sVar.f(StyleElements.DPSizeSet.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StyleEleme…java, emptySet(), \"base\")");
        this.f29134b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepPaddingStyleContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPSizeSet dPSizeSet = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29133a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPSizeSet = this.f29134b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepPaddingStyleContainer(dPSizeSet);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepPaddingStyleContainer stepStyles$StepPaddingStyleContainer) {
        j.g(qVar, "writer");
        if (stepStyles$StepPaddingStyleContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29134b.toJson(qVar, stepStyles$StepPaddingStyleContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepPaddingStyleContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
