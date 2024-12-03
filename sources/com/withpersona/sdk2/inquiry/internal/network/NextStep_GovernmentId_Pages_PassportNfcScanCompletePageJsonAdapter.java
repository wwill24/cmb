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

public final class NextStep_GovernmentId_Pages_PassportNfcScanCompletePageJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcScanCompletePage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26827a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Ui> f26828b;

    public NextStep_GovernmentId_Pages_PassportNfcScanCompletePageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("uiStep");
        j.f(a10, "of(\"uiStep\")");
        this.f26827a = a10;
        h<NextStep.Ui> f10 = sVar.f(NextStep.Ui.class, n0.e(), "uiStep");
        j.f(f10, "moshi.adapter(NextStep.U…    emptySet(), \"uiStep\")");
        this.f26828b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcScanCompletePage fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Ui ui2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26827a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (ui2 = this.f26828b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("uiStep", "uiStep", jsonReader);
                j.f(x10, "unexpectedNull(\"uiStep\",…tep\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (ui2 != null) {
            return new NextStep.GovernmentId.Pages.PassportNfcScanCompletePage(ui2);
        }
        JsonDataException o10 = c.o("uiStep", "uiStep", jsonReader);
        j.f(o10, "missingProperty(\"uiStep\", \"uiStep\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcScanCompletePage passportNfcScanCompletePage) {
        j.g(qVar, "writer");
        if (passportNfcScanCompletePage != null) {
            qVar.c();
            qVar.u("uiStep");
            this.f26828b.toJson(qVar, passportNfcScanCompletePage.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcScanCompletePage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
