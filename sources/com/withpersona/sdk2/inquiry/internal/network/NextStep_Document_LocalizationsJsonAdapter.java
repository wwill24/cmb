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

public final class NextStep_Document_LocalizationsJsonAdapter extends h<NextStep.Document.Localizations> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26734a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Document.PendingPage> f26735b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.Document.PromptPage> f26736c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.CancelDialog> f26737d;

    public NextStep_Document_LocalizationsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("pendingPage", "promptPage", "cancelDialog");
        j.f(a10, "of(\"pendingPage\", \"promp…e\",\n      \"cancelDialog\")");
        this.f26734a = a10;
        h<NextStep.Document.PendingPage> f10 = sVar.f(NextStep.Document.PendingPage.class, n0.e(), "pendingPage");
        j.f(f10, "moshi.adapter(NextStep.D…mptySet(), \"pendingPage\")");
        this.f26735b = f10;
        h<NextStep.Document.PromptPage> f11 = sVar.f(NextStep.Document.PromptPage.class, n0.e(), "promptPage");
        j.f(f11, "moshi.adapter(NextStep.D…emptySet(), \"promptPage\")");
        this.f26736c = f11;
        h<NextStep.CancelDialog> f12 = sVar.f(NextStep.CancelDialog.class, n0.e(), "cancelDialog");
        j.f(f12, "moshi.adapter(NextStep.C…ptySet(), \"cancelDialog\")");
        this.f26737d = f12;
    }

    /* renamed from: a */
    public NextStep.Document.Localizations fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Document.PendingPage pendingPage = null;
        NextStep.Document.PromptPage promptPage = null;
        NextStep.CancelDialog cancelDialog = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26734a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                pendingPage = this.f26735b.fromJson(jsonReader);
                if (pendingPage == null) {
                    JsonDataException x10 = c.x("pendingPage", "pendingPage", jsonReader);
                    j.f(x10, "unexpectedNull(\"pendingP…\", \"pendingPage\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                promptPage = this.f26736c.fromJson(jsonReader);
                if (promptPage == null) {
                    JsonDataException x11 = c.x("promptPage", "promptPage", jsonReader);
                    j.f(x11, "unexpectedNull(\"promptPage\", \"promptPage\", reader)");
                    throw x11;
                }
            } else if (L == 2) {
                cancelDialog = this.f26737d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (pendingPage == null) {
            JsonDataException o10 = c.o("pendingPage", "pendingPage", jsonReader);
            j.f(o10, "missingProperty(\"pending…age\",\n            reader)");
            throw o10;
        } else if (promptPage != null) {
            return new NextStep.Document.Localizations(pendingPage, promptPage, cancelDialog);
        } else {
            JsonDataException o11 = c.o("promptPage", "promptPage", jsonReader);
            j.f(o11, "missingProperty(\"promptP…e\", \"promptPage\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.Localizations localizations) {
        j.g(qVar, "writer");
        if (localizations != null) {
            qVar.c();
            qVar.u("pendingPage");
            this.f26735b.toJson(qVar, localizations.c());
            qVar.u("promptPage");
            this.f26736c.toJson(qVar, localizations.d());
            qVar.u("cancelDialog");
            this.f26737d.toJson(qVar, localizations.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.Localizations");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
