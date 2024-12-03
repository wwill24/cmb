package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepCancelButtonComponentStyleContainerJsonAdapter extends h<StepStyles$StepCancelButtonComponentStyleContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29131a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ButtonCancelComponentStyle> f29132b;

    public StepStyles_StepCancelButtonComponentStyleContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29131a = a10;
        h<ButtonCancelComponentStyle> f10 = sVar.f(ButtonCancelComponentStyle.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(ButtonCanc…java, emptySet(), \"base\")");
        this.f29132b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepCancelButtonComponentStyleContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        ButtonCancelComponentStyle buttonCancelComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29131a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                buttonCancelComponentStyle = this.f29132b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepCancelButtonComponentStyleContainer(buttonCancelComponentStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepCancelButtonComponentStyleContainer stepStyles$StepCancelButtonComponentStyleContainer) {
        j.g(qVar, "writer");
        if (stepStyles$StepCancelButtonComponentStyleContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29132b.toJson(qVar, stepStyles$StepCancelButtonComponentStyleContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(72);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepCancelButtonComponentStyleContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
