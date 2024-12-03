package com.withpersona.sdk2.inquiry.steps.ui;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiScreenJsonAdapter extends h<UiScreen> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f27541a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<UiComponent>> f27542b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StepStyles$UiStepStyle> f27543c;

    public UiScreenJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("components", "styles");
        j.f(a10, "of(\"components\", \"styles\")");
        this.f27541a = a10;
        h<List<UiComponent>> f10 = sVar.f(w.j(List.class, UiComponent.class), n0.e(), "components");
        j.f(f10, "moshi.adapter(Types.newP…emptySet(), \"components\")");
        this.f27542b = f10;
        h<StepStyles$UiStepStyle> f11 = sVar.f(StepStyles$UiStepStyle.class, n0.e(), "styles");
        j.f(f11, "moshi.adapter(StepStyles…va, emptySet(), \"styles\")");
        this.f27543c = f11;
    }

    /* renamed from: a */
    public UiScreen fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        StepStyles$UiStepStyle stepStyles$UiStepStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f27541a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f27542b.fromJson(jsonReader);
            } else if (L == 1) {
                stepStyles$UiStepStyle = this.f27543c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiScreen(list, stepStyles$UiStepStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiScreen uiScreen) {
        j.g(qVar, "writer");
        if (uiScreen != null) {
            qVar.c();
            qVar.u("components");
            this.f27542b.toJson(qVar, uiScreen.getComponents());
            qVar.u("styles");
            this.f27543c.toJson(qVar, uiScreen.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiScreen");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
