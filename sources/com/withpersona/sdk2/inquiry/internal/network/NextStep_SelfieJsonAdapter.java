package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_SelfieJsonAdapter extends h<NextStep.Selfie> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26859a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26860b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.Selfie.Config> f26861c;

    /* renamed from: d  reason: collision with root package name */
    private final h<StepStyles$SelfieStepStyle> f26862d;

    public NextStep_SelfieJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "config", "styles");
        j.f(a10, "of(\"name\", \"config\", \"styles\")");
        this.f26859a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f26860b = f10;
        h<NextStep.Selfie.Config> f11 = sVar.f(NextStep.Selfie.Config.class, n0.e(), "config");
        j.f(f11, "moshi.adapter(NextStep.S…va, emptySet(), \"config\")");
        this.f26861c = f11;
        h<StepStyles$SelfieStepStyle> f12 = sVar.f(StepStyles$SelfieStepStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(StepStyles…va, emptySet(), \"styles\")");
        this.f26862d = f12;
    }

    /* renamed from: a */
    public NextStep.Selfie fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        NextStep.Selfie.Config config = null;
        StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26859a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26860b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                config = this.f26861c.fromJson(jsonReader);
                if (config == null) {
                    JsonDataException x11 = c.x("config", "config", jsonReader);
                    j.f(x11, "unexpectedNull(\"config\",…        \"config\", reader)");
                    throw x11;
                }
            } else if (L == 2) {
                stepStyles$SelfieStepStyle = this.f26862d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("name", "name", jsonReader);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (config != null) {
            return new NextStep.Selfie(str, config, stepStyles$SelfieStepStyle);
        } else {
            JsonDataException o11 = c.o("config", "config", jsonReader);
            j.f(o11, "missingProperty(\"config\", \"config\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Selfie selfie) {
        j.g(qVar, "writer");
        if (selfie != null) {
            qVar.c();
            qVar.u("name");
            this.f26860b.toJson(qVar, selfie.a());
            qVar.u("config");
            this.f26861c.toJson(qVar, selfie.c());
            qVar.u("styles");
            this.f26862d.toJson(qVar, selfie.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Selfie");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
