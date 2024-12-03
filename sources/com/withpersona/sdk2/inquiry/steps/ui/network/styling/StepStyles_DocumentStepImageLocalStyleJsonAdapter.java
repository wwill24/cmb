package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_DocumentStepImageLocalStyleJsonAdapter extends h<StepStyles$DocumentStepImageLocalStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29028a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StepStyles$DocumentStepImageLocalStyleContainer> f29029b;

    public StepStyles_DocumentStepImageLocalStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("documentStartIcon");
        j.f(a10, "of(\"documentStartIcon\")");
        this.f29028a = a10;
        h<StepStyles$DocumentStepImageLocalStyleContainer> f10 = sVar.f(StepStyles$DocumentStepImageLocalStyleContainer.class, n0.e(), "documentStartIcon");
        j.f(f10, "moshi.adapter(StepStyles…     \"documentStartIcon\")");
        this.f29029b = f10;
    }

    /* renamed from: a */
    public StepStyles$DocumentStepImageLocalStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StepStyles$DocumentStepImageLocalStyleContainer stepStyles$DocumentStepImageLocalStyleContainer = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29028a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                stepStyles$DocumentStepImageLocalStyleContainer = this.f29029b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$DocumentStepImageLocalStyle(stepStyles$DocumentStepImageLocalStyleContainer);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$DocumentStepImageLocalStyle stepStyles$DocumentStepImageLocalStyle) {
        j.g(qVar, "writer");
        if (stepStyles$DocumentStepImageLocalStyle != null) {
            qVar.c();
            qVar.u("documentStartIcon");
            this.f29029b.toJson(qVar, stepStyles$DocumentStepImageLocalStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.DocumentStepImageLocalStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
