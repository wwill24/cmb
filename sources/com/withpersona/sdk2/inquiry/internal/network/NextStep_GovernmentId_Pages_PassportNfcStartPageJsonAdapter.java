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

public final class NextStep_GovernmentId_Pages_PassportNfcStartPageJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcStartPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26839a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Ui> f26840b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcStartPage.ComponentNameMapping> f26841c;

    public NextStep_GovernmentId_Pages_PassportNfcStartPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("uiStep", "componentNameMapping");
        j.f(a10, "of(\"uiStep\", \"componentNameMapping\")");
        this.f26839a = a10;
        h<NextStep.Ui> f10 = sVar.f(NextStep.Ui.class, n0.e(), "uiStep");
        j.f(f10, "moshi.adapter(NextStep.U…    emptySet(), \"uiStep\")");
        this.f26840b = f10;
        h<NextStep.GovernmentId.Pages.PassportNfcStartPage.ComponentNameMapping> f11 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcStartPage.ComponentNameMapping.class, n0.e(), "componentNameMapping");
        j.f(f11, "moshi.adapter(NextStep.G…, \"componentNameMapping\")");
        this.f26841c = f11;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcStartPage fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Ui ui2 = null;
        NextStep.GovernmentId.Pages.PassportNfcStartPage.ComponentNameMapping componentNameMapping = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26839a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                ui2 = this.f26840b.fromJson(jsonReader);
                if (ui2 == null) {
                    JsonDataException x10 = c.x("uiStep", "uiStep", jsonReader);
                    j.f(x10, "unexpectedNull(\"uiStep\",…tep\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                componentNameMapping = this.f26841c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (ui2 != null) {
            return new NextStep.GovernmentId.Pages.PassportNfcStartPage(ui2, componentNameMapping);
        }
        JsonDataException o10 = c.o("uiStep", "uiStep", jsonReader);
        j.f(o10, "missingProperty(\"uiStep\", \"uiStep\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcStartPage passportNfcStartPage) {
        j.g(qVar, "writer");
        if (passportNfcStartPage != null) {
            qVar.c();
            qVar.u("uiStep");
            this.f26840b.toJson(qVar, passportNfcStartPage.b());
            qVar.u("componentNameMapping");
            this.f26841c.toJson(qVar, passportNfcStartPage.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(70);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcStartPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
