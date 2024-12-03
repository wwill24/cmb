package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepSubmitButtonComponentStyleContainerJsonAdapter extends h<StepStyles$StepSubmitButtonComponentStyleContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29141a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ButtonSubmitComponentStyle> f29142b;

    public StepStyles_StepSubmitButtonComponentStyleContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("base");
        j.f(a10, "of(\"base\")");
        this.f29141a = a10;
        h<ButtonSubmitComponentStyle> f10 = sVar.f(ButtonSubmitComponentStyle.class, n0.e(), "base");
        j.f(f10, "moshi.adapter(ButtonSubm…java, emptySet(), \"base\")");
        this.f29142b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepSubmitButtonComponentStyleContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        ButtonSubmitComponentStyle buttonSubmitComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29141a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                buttonSubmitComponentStyle = this.f29142b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepSubmitButtonComponentStyleContainer(buttonSubmitComponentStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepSubmitButtonComponentStyleContainer stepStyles$StepSubmitButtonComponentStyleContainer) {
        j.g(qVar, "writer");
        if (stepStyles$StepSubmitButtonComponentStyleContainer != null) {
            qVar.c();
            qVar.u("base");
            this.f29142b.toJson(qVar, stepStyles$StepSubmitButtonComponentStyleContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(72);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepSubmitButtonComponentStyleContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
