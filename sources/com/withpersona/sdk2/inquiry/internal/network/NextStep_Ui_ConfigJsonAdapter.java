package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Ui_ConfigJsonAdapter extends h<NextStep.Ui.Config> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26885a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<UiComponent>> f26886b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f26887c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.Ui.Localizations> f26888d;

    public NextStep_Ui_ConfigJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("components", "backStepEnabled", "cancelButtonEnabled", "terminal", "localizations");
        j.f(a10, "of(\"components\", \"backSt…rminal\", \"localizations\")");
        this.f26885a = a10;
        h<List<UiComponent>> f10 = sVar.f(w.j(List.class, UiComponent.class), n0.e(), "components");
        j.f(f10, "moshi.adapter(Types.newP…emptySet(), \"components\")");
        this.f26886b = f10;
        h<Boolean> f11 = sVar.f(Boolean.class, n0.e(), "backStepEnabled");
        j.f(f11, "moshi.adapter(Boolean::c…Set(), \"backStepEnabled\")");
        this.f26887c = f11;
        h<NextStep.Ui.Localizations> f12 = sVar.f(NextStep.Ui.Localizations.class, n0.e(), "localizations");
        j.f(f12, "moshi.adapter(NextStep.U…tySet(), \"localizations\")");
        this.f26888d = f12;
    }

    /* renamed from: a */
    public NextStep.Ui.Config fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        NextStep.Ui.Localizations localizations = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26885a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f26886b.fromJson(jsonReader);
            } else if (L == 1) {
                bool = this.f26887c.fromJson(jsonReader);
            } else if (L == 2) {
                bool2 = this.f26887c.fromJson(jsonReader);
            } else if (L == 3) {
                bool3 = this.f26887c.fromJson(jsonReader);
            } else if (L == 4) {
                localizations = this.f26888d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.Ui.Config(list, bool, bool2, bool3, localizations);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Ui.Config config) {
        j.g(qVar, "writer");
        if (config != null) {
            qVar.c();
            qVar.u("components");
            this.f26886b.toJson(qVar, config.getComponents());
            qVar.u("backStepEnabled");
            this.f26887c.toJson(qVar, config.a());
            qVar.u("cancelButtonEnabled");
            this.f26887c.toJson(qVar, config.c());
            qVar.u("terminal");
            this.f26887c.toJson(qVar, config.e());
            qVar.u("localizations");
            this.f26888d.toJson(qVar, config.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Ui.Config");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
