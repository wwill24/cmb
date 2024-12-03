package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StepStyles_StepBackgroundImageNameContainerJsonAdapter extends h<StepStyles$StepBackgroundImageNameContainer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29123a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29124b;

    public StepStyles_StepBackgroundImageNameContainerJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("localName");
        j.f(a10, "of(\"localName\")");
        this.f29123a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "localName");
        j.f(f10, "moshi.adapter(String::cl… emptySet(), \"localName\")");
        this.f29124b = f10;
    }

    /* renamed from: a */
    public StepStyles$StepBackgroundImageNameContainer fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29123a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f29124b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StepStyles$StepBackgroundImageNameContainer(str);
    }

    /* renamed from: b */
    public void toJson(q qVar, StepStyles$StepBackgroundImageNameContainer stepStyles$StepBackgroundImageNameContainer) {
        j.g(qVar, "writer");
        if (stepStyles$StepBackgroundImageNameContainer != null) {
            qVar.c();
            qVar.u("localName");
            this.f29124b.toJson(qVar, stepStyles$StepBackgroundImageNameContainer.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(65);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StepStyles.StepBackgroundImageNameContainer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
