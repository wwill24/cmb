package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentIdJsonAdapter extends h<NextStep.GovernmentId> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26757a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26758b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Config> f26759c;

    /* renamed from: d  reason: collision with root package name */
    private final h<StepStyles$GovernmentIdStepStyle> f26760d;

    public NextStep_GovernmentIdJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "config", "styles");
        j.f(a10, "of(\"name\", \"config\", \"styles\")");
        this.f26757a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f26758b = f10;
        h<NextStep.GovernmentId.Config> f11 = sVar.f(NextStep.GovernmentId.Config.class, n0.e(), "config");
        j.f(f11, "moshi.adapter(NextStep.G…va, emptySet(), \"config\")");
        this.f26759c = f11;
        h<StepStyles$GovernmentIdStepStyle> f12 = sVar.f(StepStyles$GovernmentIdStepStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(StepStyles…va, emptySet(), \"styles\")");
        this.f26760d = f12;
    }

    /* renamed from: a */
    public NextStep.GovernmentId fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        NextStep.GovernmentId.Config config = null;
        StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26757a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26758b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                config = this.f26759c.fromJson(jsonReader);
                if (config == null) {
                    JsonDataException x11 = c.x("config", "config", jsonReader);
                    j.f(x11, "unexpectedNull(\"config\",…        \"config\", reader)");
                    throw x11;
                }
            } else if (L == 2) {
                stepStyles$GovernmentIdStepStyle = this.f26760d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("name", "name", jsonReader);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (config != null) {
            return new NextStep.GovernmentId(str, config, stepStyles$GovernmentIdStepStyle);
        } else {
            JsonDataException o11 = c.o("config", "config", jsonReader);
            j.f(o11, "missingProperty(\"config\", \"config\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId governmentId) {
        j.g(qVar, "writer");
        if (governmentId != null) {
            qVar.c();
            qVar.u("name");
            this.f26758b.toJson(qVar, governmentId.a());
            qVar.u("config");
            this.f26759c.toJson(qVar, governmentId.c());
            qVar.u("styles");
            this.f26760d.toJson(qVar, governmentId.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
