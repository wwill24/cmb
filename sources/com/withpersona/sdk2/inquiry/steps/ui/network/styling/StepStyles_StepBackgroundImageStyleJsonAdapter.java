package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepBackgroundImageStyleJsonAdapter extends h<StepStyles$StepBackgroundImageStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29127a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$StepBackgroundImageStyleContainer> f29128b;

    public StepStyles_StepBackgroundImageStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29127a = a10;
        h<StepStyles$StepBackgroundImageStyleContainer> f10 = sVar.f(StepStyles$StepBackgroundImageStyleContainer.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(StepStyles…java, emptySet(), \"base\")");
        this.f29128b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepBackgroundImageStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$StepBackgroundImageStyleContainer stepStyles$StepBackgroundImageStyleContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29127a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$StepBackgroundImageStyleContainer = this.f29128b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepBackgroundImageStyle(stepStyles$StepBackgroundImageStyleContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle) {
        j.g(qVar, "writer");
        if (stepStyles$StepBackgroundImageStyle != null) {
            qVar.c();
            qVar.u("base");
            this.f29128b.toJson(qVar, stepStyles$StepBackgroundImageStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepBackgroundImageStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
