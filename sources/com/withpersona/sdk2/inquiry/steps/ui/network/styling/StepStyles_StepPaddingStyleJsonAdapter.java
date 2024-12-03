package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepPaddingStyleJsonAdapter extends h<StepStyles$StepPaddingStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29135a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepPaddingStyleContainer> f29136b;

    public StepStyles_StepPaddingStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("modal");
        j.f(a10, "of(\"modal\")");
        this.f29135a = a10;
        h<StepStyles$StepPaddingStyleContainer> f10 = sVar.f(StepStyles$StepPaddingStyleContainer.class, n0.e(), "modal");
        j.f(f10, "moshi.adapter(StepStyles…ava, emptySet(), \"modal\")");
        this.f29136b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepPaddingStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepPaddingStyleContainer stepStyles$StepPaddingStyleContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29135a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepPaddingStyleContainer = this.f29136b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepPaddingStyle(stepStyles$StepPaddingStyleContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle) {
        j.g(qVar, "writer");
        if (stepStyles$StepPaddingStyle != null) {
            qVar.c();
            qVar.u("modal");
            this.f29136b.toJson(qVar, stepStyles$StepPaddingStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepPaddingStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
