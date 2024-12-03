package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_Pages_PassportNfcModuleMissingPageJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26812a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Ui> f26813b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping> f26814c;

    public NextStep_GovernmentId_Pages_PassportNfcModuleMissingPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("uiStep", "componentNameMapping");
        j.f(a10, "of(\"uiStep\", \"componentNameMapping\")");
        this.f26812a = a10;
        h<NextStep.Ui> f10 = sVar.f(NextStep.Ui.class, n0.e(), "uiStep");
        j.f(f10, "moshi.adapter(NextStep.U…    emptySet(), \"uiStep\")");
        this.f26813b = f10;
        h<NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping> f11 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping.class, n0.e(), "componentNameMapping");
        j.f(f11, "moshi.adapter(NextStep.G…, \"componentNameMapping\")");
        this.f26814c = f11;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Ui ui2 = null;
        NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping componentNameMapping = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26812a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                ui2 = this.f26813b.fromJson(jsonReader);
                if (ui2 == null) {
                    JsonDataException x10 = c.x("uiStep", "uiStep", jsonReader);
                    j.f(x10, "unexpectedNull(\"uiStep\",…tep\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                componentNameMapping = this.f26814c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (ui2 != null) {
            return new NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage(ui2, componentNameMapping);
        }
        JsonDataException o10 = c.o("uiStep", "uiStep", jsonReader);
        j.f(o10, "missingProperty(\"uiStep\", \"uiStep\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage passportNfcModuleMissingPage) {
        j.g(qVar, "writer");
        if (passportNfcModuleMissingPage != null) {
            qVar.c();
            qVar.u("uiStep");
            this.f26813b.toJson(qVar, passportNfcModuleMissingPage.b());
            qVar.u("componentNameMapping");
            this.f26814c.toJson(qVar, passportNfcModuleMissingPage.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(78);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
