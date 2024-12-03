package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_Pages_PassportNfcJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfc> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26802a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcStartPage> f26803b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage> f26804c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcScanPage> f26805d;

    /* renamed from: e  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcPromptPage> f26806e;

    /* renamed from: f  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcScanReadyPage> f26807f;

    /* renamed from: g  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcScanCompletePage> f26808g;

    /* renamed from: h  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage> f26809h;

    /* renamed from: i  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage> f26810i;

    /* renamed from: j  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage> f26811j;

    public NextStep_GovernmentId_Pages_PassportNfcJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("start", "verifyDetails", "scan", "prompt", "scanReady", "scanComplete", "confirmDetails", "nfcNotSupported", "moduleMissing");
        j.f(a10, "of(\"start\", \"verifyDetai…ported\", \"moduleMissing\")");
        this.f26802a = a10;
        h<NextStep.GovernmentId.Pages.PassportNfcStartPage> f10 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcStartPage.class, n0.e(), "start");
        j.f(f10, "moshi.adapter(NextStep.G…mptySet(),\n      \"start\")");
        this.f26803b = f10;
        h<NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage> f11 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.class, n0.e(), "verifyDetails");
        j.f(f11, "moshi.adapter(NextStep.G…tySet(), \"verifyDetails\")");
        this.f26804c = f11;
        h<NextStep.GovernmentId.Pages.PassportNfcScanPage> f12 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcScanPage.class, n0.e(), "scan");
        j.f(f12, "moshi.adapter(NextStep.G…java, emptySet(), \"scan\")");
        this.f26805d = f12;
        h<NextStep.GovernmentId.Pages.PassportNfcPromptPage> f13 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcPromptPage.class, n0.e(), "prompt");
        j.f(f13, "moshi.adapter(NextStep.G…ptySet(),\n      \"prompt\")");
        this.f26806e = f13;
        h<NextStep.GovernmentId.Pages.PassportNfcScanReadyPage> f14 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcScanReadyPage.class, n0.e(), "scanReady");
        j.f(f14, "moshi.adapter(NextStep.G…Set(),\n      \"scanReady\")");
        this.f26807f = f14;
        h<NextStep.GovernmentId.Pages.PassportNfcScanCompletePage> f15 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcScanCompletePage.class, n0.e(), "scanComplete");
        j.f(f15, "moshi.adapter(NextStep.G…(),\n      \"scanComplete\")");
        this.f26808g = f15;
        h<NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage> f16 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.class, n0.e(), "confirmDetails");
        j.f(f16, "moshi.adapter(NextStep.G…ySet(), \"confirmDetails\")");
        this.f26809h = f16;
        h<NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage> f17 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage.class, n0.e(), "nfcNotSupported");
        j.f(f17, "moshi.adapter(NextStep.G…Set(), \"nfcNotSupported\")");
        this.f26810i = f17;
        h<NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage> f18 = sVar.f(NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.class, n0.e(), "moduleMissing");
        j.f(f18, "moshi.adapter(NextStep.G…tySet(), \"moduleMissing\")");
        this.f26811j = f18;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfc fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.GovernmentId.Pages.PassportNfcStartPage passportNfcStartPage = null;
        NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage = null;
        NextStep.GovernmentId.Pages.PassportNfcScanPage passportNfcScanPage = null;
        NextStep.GovernmentId.Pages.PassportNfcPromptPage passportNfcPromptPage = null;
        NextStep.GovernmentId.Pages.PassportNfcScanReadyPage passportNfcScanReadyPage = null;
        NextStep.GovernmentId.Pages.PassportNfcScanCompletePage passportNfcScanCompletePage = null;
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage = null;
        NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage = null;
        NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage passportNfcModuleMissingPage = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26802a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    passportNfcStartPage = this.f26803b.fromJson(jsonReader);
                    break;
                case 1:
                    passportNfcVerifyDetailsPage = this.f26804c.fromJson(jsonReader);
                    break;
                case 2:
                    passportNfcScanPage = this.f26805d.fromJson(jsonReader);
                    break;
                case 3:
                    passportNfcPromptPage = this.f26806e.fromJson(jsonReader);
                    break;
                case 4:
                    passportNfcScanReadyPage = this.f26807f.fromJson(jsonReader);
                    break;
                case 5:
                    passportNfcScanCompletePage = this.f26808g.fromJson(jsonReader);
                    break;
                case 6:
                    passportNfcConfirmDetailsPage = this.f26809h.fromJson(jsonReader);
                    break;
                case 7:
                    passportNfcNfcNotSupportedPage = this.f26810i.fromJson(jsonReader);
                    break;
                case 8:
                    passportNfcModuleMissingPage = this.f26811j.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.Pages.PassportNfc(passportNfcStartPage, passportNfcVerifyDetailsPage, passportNfcScanPage, passportNfcPromptPage, passportNfcScanReadyPage, passportNfcScanCompletePage, passportNfcConfirmDetailsPage, passportNfcNfcNotSupportedPage, passportNfcModuleMissingPage);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfc passportNfc) {
        j.g(qVar, "writer");
        if (passportNfc != null) {
            qVar.c();
            qVar.u("start");
            this.f26803b.toJson(qVar, passportNfc.h());
            qVar.u("verifyDetails");
            this.f26804c.toJson(qVar, passportNfc.i());
            qVar.u("scan");
            this.f26805d.toJson(qVar, passportNfc.e());
            qVar.u("prompt");
            this.f26806e.toJson(qVar, passportNfc.d());
            qVar.u("scanReady");
            this.f26807f.toJson(qVar, passportNfc.g());
            qVar.u("scanComplete");
            this.f26808g.toJson(qVar, passportNfc.f());
            qVar.u("confirmDetails");
            this.f26809h.toJson(qVar, passportNfc.a());
            qVar.u("nfcNotSupported");
            this.f26810i.toJson(qVar, passportNfc.c());
            qVar.u("moduleMissing");
            this.f26811j.toJson(qVar, passportNfc.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(61);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfc");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
