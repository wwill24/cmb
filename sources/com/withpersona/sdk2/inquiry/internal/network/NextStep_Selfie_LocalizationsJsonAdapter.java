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

public final class NextStep_Selfie_LocalizationsJsonAdapter extends h<NextStep.Selfie.Localizations> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26871a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Selfie.PromptPage> f26872b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.Selfie.CapturePage> f26873c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.Selfie.PendingPage> f26874d;

    /* renamed from: e  reason: collision with root package name */
    private final h<NextStep.CancelDialog> f26875e;

    public NextStep_Selfie_LocalizationsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("promptPage", "capturePage", "pendingPage", "cancelDialog");
        j.f(a10, "of(\"promptPage\", \"captur…ingPage\", \"cancelDialog\")");
        this.f26871a = a10;
        h<NextStep.Selfie.PromptPage> f10 = sVar.f(NextStep.Selfie.PromptPage.class, n0.e(), "promptPage");
        j.f(f10, "moshi.adapter(NextStep.S…emptySet(), \"promptPage\")");
        this.f26872b = f10;
        h<NextStep.Selfie.CapturePage> f11 = sVar.f(NextStep.Selfie.CapturePage.class, n0.e(), "capturePage");
        j.f(f11, "moshi.adapter(NextStep.S…mptySet(), \"capturePage\")");
        this.f26873c = f11;
        h<NextStep.Selfie.PendingPage> f12 = sVar.f(NextStep.Selfie.PendingPage.class, n0.e(), "pendingPage");
        j.f(f12, "moshi.adapter(NextStep.S…mptySet(), \"pendingPage\")");
        this.f26874d = f12;
        h<NextStep.CancelDialog> f13 = sVar.f(NextStep.CancelDialog.class, n0.e(), "cancelDialog");
        j.f(f13, "moshi.adapter(NextStep.C…ptySet(), \"cancelDialog\")");
        this.f26875e = f13;
    }

    /* renamed from: a */
    public NextStep.Selfie.Localizations fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Selfie.PromptPage promptPage = null;
        NextStep.Selfie.CapturePage capturePage = null;
        NextStep.Selfie.PendingPage pendingPage = null;
        NextStep.CancelDialog cancelDialog = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26871a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                promptPage = this.f26872b.fromJson(jsonReader);
                if (promptPage == null) {
                    JsonDataException x10 = c.x("promptPage", "promptPage", jsonReader);
                    j.f(x10, "unexpectedNull(\"promptPage\", \"promptPage\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                capturePage = this.f26873c.fromJson(jsonReader);
                if (capturePage == null) {
                    JsonDataException x11 = c.x("capturePage", "capturePage", jsonReader);
                    j.f(x11, "unexpectedNull(\"captureP…\", \"capturePage\", reader)");
                    throw x11;
                }
            } else if (L == 2) {
                pendingPage = this.f26874d.fromJson(jsonReader);
                if (pendingPage == null) {
                    JsonDataException x12 = c.x("pendingPage", "pendingPage", jsonReader);
                    j.f(x12, "unexpectedNull(\"pendingP…\", \"pendingPage\", reader)");
                    throw x12;
                }
            } else if (L == 3) {
                cancelDialog = this.f26875e.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (promptPage == null) {
            JsonDataException o10 = c.o("promptPage", "promptPage", jsonReader);
            j.f(o10, "missingProperty(\"promptP…e\", \"promptPage\", reader)");
            throw o10;
        } else if (capturePage == null) {
            JsonDataException o11 = c.o("capturePage", "capturePage", jsonReader);
            j.f(o11, "missingProperty(\"capture…age\",\n            reader)");
            throw o11;
        } else if (pendingPage != null) {
            return new NextStep.Selfie.Localizations(promptPage, capturePage, pendingPage, cancelDialog);
        } else {
            JsonDataException o12 = c.o("pendingPage", "pendingPage", jsonReader);
            j.f(o12, "missingProperty(\"pending…age\",\n            reader)");
            throw o12;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Selfie.Localizations localizations) {
        j.g(qVar, "writer");
        if (localizations != null) {
            qVar.c();
            qVar.u("promptPage");
            this.f26872b.toJson(qVar, localizations.e());
            qVar.u("capturePage");
            this.f26873c.toJson(qVar, localizations.c());
            qVar.u("pendingPage");
            this.f26874d.toJson(qVar, localizations.d());
            qVar.u("cancelDialog");
            this.f26875e.toJson(qVar, localizations.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Selfie.Localizations");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
