package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_DocumentJsonAdapter extends h<NextStep.Document> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26722a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26723b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StepStyles$DocumentStepStyle> f26724c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.Document.Config> f26725d;

    public NextStep_DocumentJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "styles", "config");
        j.f(a10, "of(\"name\", \"styles\", \"config\")");
        this.f26722a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f26723b = f10;
        h<StepStyles$DocumentStepStyle> f11 = sVar.f(StepStyles$DocumentStepStyle.class, n0.e(), "styles");
        j.f(f11, "moshi.adapter(StepStyles…va, emptySet(), \"styles\")");
        this.f26724c = f11;
        h<NextStep.Document.Config> f12 = sVar.f(NextStep.Document.Config.class, n0.e(), "config");
        j.f(f12, "moshi.adapter(NextStep.D…va, emptySet(), \"config\")");
        this.f26725d = f12;
    }

    /* renamed from: a */
    public NextStep.Document fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = null;
        NextStep.Document.Config config = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26722a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26723b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                stepStyles$DocumentStepStyle = this.f26724c.fromJson(jsonReader);
            } else if (L == 2 && (config = this.f26725d.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("config", "config", jsonReader);
                j.f(x11, "unexpectedNull(\"config\",…        \"config\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("name", "name", jsonReader);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (config != null) {
            return new NextStep.Document(str, stepStyles$DocumentStepStyle, config);
        } else {
            JsonDataException o11 = c.o("config", "config", jsonReader);
            j.f(o11, "missingProperty(\"config\", \"config\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document document) {
        j.g(qVar, "writer");
        if (document != null) {
            qVar.c();
            qVar.u("name");
            this.f26723b.toJson(qVar, document.a());
            qVar.u("styles");
            this.f26724c.toJson(qVar, document.d());
            qVar.u("config");
            this.f26725d.toJson(qVar, document.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(39);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
