package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepTextBasedComponentStyleContainerJsonAdapter extends h<StepStyles$StepTextBasedComponentStyleContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29143a;

    /* renamed from: b  reason: collision with root package name */
    private final h<TextBasedComponentStyle> f29144b;

    public StepStyles_StepTextBasedComponentStyleContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29143a = a10;
        h<TextBasedComponentStyle> f10 = sVar.f(TextBasedComponentStyle.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(TextBasedC…java, emptySet(), \"base\")");
        this.f29144b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepTextBasedComponentStyleContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        TextBasedComponentStyle textBasedComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29143a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                textBasedComponentStyle = this.f29144b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepTextBasedComponentStyleContainer(textBasedComponentStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepTextBasedComponentStyleContainer stepStyles$StepTextBasedComponentStyleContainer) {
        j.g(qVar, "writer");
        if (stepStyles$StepTextBasedComponentStyleContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29144b.toJson(qVar, stepStyles$StepTextBasedComponentStyleContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepTextBasedComponentStyleContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
