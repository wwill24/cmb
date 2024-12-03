package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Ui_LocalizationsJsonAdapter extends h<NextStep.Ui.Localizations> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26889a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.CancelDialog> f26890b;

    public NextStep_Ui_LocalizationsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("cancelDialog");
        j.f(a10, "of(\"cancelDialog\")");
        this.f26889a = a10;
        h<NextStep.CancelDialog> f10 = sVar.f(NextStep.CancelDialog.class, n0.e(), "cancelDialog");
        j.f(f10, "moshi.adapter(NextStep.C…ptySet(), \"cancelDialog\")");
        this.f26890b = f10;
    }

    /* renamed from: a */
    public NextStep.Ui.Localizations fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.CancelDialog cancelDialog = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26889a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                cancelDialog = this.f26890b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.Ui.Localizations(cancelDialog);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Ui.Localizations localizations) {
        j.g(qVar, "writer");
        if (localizations != null) {
            qVar.c();
            qVar.u("cancelDialog");
            this.f26890b.toJson(qVar, localizations.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Ui.Localizations");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
