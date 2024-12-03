package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_LocalizationsJsonAdapter extends h<NextStep.GovernmentId.Localizations> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26781a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.GovernmentId.SelectPage> f26782b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.GovernmentId.PromptPage> f26783c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.GovernmentId.CapturePage> f26784d;

    /* renamed from: e  reason: collision with root package name */
    private final h<NextStep.GovernmentId.CheckPage> f26785e;

    /* renamed from: f  reason: collision with root package name */
    private final h<NextStep.GovernmentId.PendingPage> f26786f;

    /* renamed from: g  reason: collision with root package name */
    private final h<NextStep.GovernmentId.RequestPage> f26787g;

    /* renamed from: h  reason: collision with root package name */
    private final h<NextStep.GovernmentId.ReviewUploadPage> f26788h;

    /* renamed from: i  reason: collision with root package name */
    private final h<NextStep.CancelDialog> f26789i;

    /* renamed from: j  reason: collision with root package name */
    private final h<NextStep.PassportNfc> f26790j;

    public NextStep_GovernmentId_LocalizationsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selectPage", "promptPage", "capturePage", "checkPage", "pendingPage", "requestPage", "reviewUploadPage", "cancelDialog", "passportNfc");
        j.f(a10, "of(\"selectPage\", \"prompt…og\",\n      \"passportNfc\")");
        this.f26781a = a10;
        h<NextStep.GovernmentId.SelectPage> f10 = sVar.f(NextStep.GovernmentId.SelectPage.class, n0.e(), "selectPage");
        j.f(f10, "moshi.adapter(NextStep.G…emptySet(), \"selectPage\")");
        this.f26782b = f10;
        h<NextStep.GovernmentId.PromptPage> f11 = sVar.f(NextStep.GovernmentId.PromptPage.class, n0.e(), "promptPage");
        j.f(f11, "moshi.adapter(NextStep.G…emptySet(), \"promptPage\")");
        this.f26783c = f11;
        h<NextStep.GovernmentId.CapturePage> f12 = sVar.f(NextStep.GovernmentId.CapturePage.class, n0.e(), "capturePage");
        j.f(f12, "moshi.adapter(NextStep.G…mptySet(), \"capturePage\")");
        this.f26784d = f12;
        h<NextStep.GovernmentId.CheckPage> f13 = sVar.f(NextStep.GovernmentId.CheckPage.class, n0.e(), "checkPage");
        j.f(f13, "moshi.adapter(NextStep.G… emptySet(), \"checkPage\")");
        this.f26785e = f13;
        h<NextStep.GovernmentId.PendingPage> f14 = sVar.f(NextStep.GovernmentId.PendingPage.class, n0.e(), "pendingPage");
        j.f(f14, "moshi.adapter(NextStep.G…mptySet(), \"pendingPage\")");
        this.f26786f = f14;
        h<NextStep.GovernmentId.RequestPage> f15 = sVar.f(NextStep.GovernmentId.RequestPage.class, n0.e(), "requestPage");
        j.f(f15, "moshi.adapter(NextStep.G…mptySet(), \"requestPage\")");
        this.f26787g = f15;
        h<NextStep.GovernmentId.ReviewUploadPage> f16 = sVar.f(NextStep.GovernmentId.ReviewUploadPage.class, n0.e(), "reviewUploadPage");
        j.f(f16, "moshi.adapter(NextStep.G…      \"reviewUploadPage\")");
        this.f26788h = f16;
        h<NextStep.CancelDialog> f17 = sVar.f(NextStep.CancelDialog.class, n0.e(), "cancelDialog");
        j.f(f17, "moshi.adapter(NextStep.C…ptySet(), \"cancelDialog\")");
        this.f26789i = f17;
        h<NextStep.PassportNfc> f18 = sVar.f(NextStep.PassportNfc.class, n0.e(), "passportNfc");
        j.f(f18, "moshi.adapter(NextStep.P…mptySet(), \"passportNfc\")");
        this.f26790j = f18;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f8, code lost:
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fa, code lost:
        r11 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fc, code lost:
        r10 = r18;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.Localizations fromJson(com.squareup.moshi.JsonReader r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.j.g(r1, r2)
            r20.b()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
        L_0x0016:
            boolean r2 = r20.g()
            java.lang.String r3 = "reviewUploadPage"
            java.lang.String r13 = "requestPage"
            java.lang.String r14 = "pendingPage"
            java.lang.String r15 = "checkPage"
            r16 = r12
            java.lang.String r12 = "capturePage"
            r17 = r11
            java.lang.String r11 = "promptPage"
            r18 = r10
            java.lang.String r10 = "selectPage"
            if (r2 == 0) goto L_0x0100
            com.squareup.moshi.JsonReader$b r2 = r0.f26781a
            int r2 = r1.L(r2)
            switch(r2) {
                case -1: goto L_0x00f2;
                case 0: goto L_0x00dc;
                case 1: goto L_0x00c6;
                case 2: goto L_0x00b0;
                case 3: goto L_0x009a;
                case 4: goto L_0x0084;
                case 5: goto L_0x006d;
                case 6: goto L_0x0053;
                case 7: goto L_0x0046;
                case 8: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x00f8
        L_0x003b:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$PassportNfc> r2 = r0.f26790j
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$PassportNfc r12 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.PassportNfc) r12
            goto L_0x00fa
        L_0x0046:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$CancelDialog> r2 = r0.f26789i
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$CancelDialog r11 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.CancelDialog) r11
            r12 = r16
            goto L_0x00fc
        L_0x0053:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$ReviewUploadPage> r2 = r0.f26788h
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$ReviewUploadPage r10 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.ReviewUploadPage) r10
            if (r10 == 0) goto L_0x0063
            r12 = r16
            r11 = r17
            goto L_0x0016
        L_0x0063:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r3, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"reviewUp…eviewUploadPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x006d:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$RequestPage> r2 = r0.f26787g
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$RequestPage r9 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.RequestPage) r9
            if (r9 == 0) goto L_0x007a
            goto L_0x00f8
        L_0x007a:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"requestP…\", \"requestPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0084:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PendingPage> r2 = r0.f26786f
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PendingPage r8 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.PendingPage) r8
            if (r8 == 0) goto L_0x0090
            goto L_0x00f8
        L_0x0090:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"pendingP…\", \"pendingPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x009a:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CheckPage> r2 = r0.f26785e
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CheckPage r7 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.CheckPage) r7
            if (r7 == 0) goto L_0x00a6
            goto L_0x00f8
        L_0x00a6:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"checkPag…     \"checkPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00b0:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CapturePage> r2 = r0.f26784d
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CapturePage r6 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.CapturePage) r6
            if (r6 == 0) goto L_0x00bc
            goto L_0x00f8
        L_0x00bc:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"captureP…\", \"capturePage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00c6:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PromptPage> r2 = r0.f26783c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PromptPage r5 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.PromptPage) r5
            if (r5 == 0) goto L_0x00d2
            goto L_0x00f8
        L_0x00d2:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"promptPage\", \"promptPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00dc:
            com.squareup.moshi.h<com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$SelectPage> r2 = r0.f26782b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$SelectPage r4 = (com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.SelectPage) r4
            if (r4 == 0) goto L_0x00e8
            goto L_0x00f8
        L_0x00e8:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"selectPage\", \"selectPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00f2:
            r20.S()
            r20.Y()
        L_0x00f8:
            r12 = r16
        L_0x00fa:
            r11 = r17
        L_0x00fc:
            r10 = r18
            goto L_0x0016
        L_0x0100:
            r20.e()
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$Localizations r2 = new com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$Localizations
            if (r4 == 0) goto L_0x015a
            if (r5 == 0) goto L_0x0150
            if (r6 == 0) goto L_0x0146
            if (r7 == 0) goto L_0x013c
            if (r8 == 0) goto L_0x0132
            if (r9 == 0) goto L_0x0128
            if (r18 == 0) goto L_0x011e
            r3 = r2
            r10 = r18
            r11 = r17
            r12 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r2
        L_0x011e:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r3, r3, r1)
            java.lang.String r2 = "missingProperty(\"reviewU…eviewUploadPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0128:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"request…age\",\n            reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0132:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"pending…age\",\n            reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x013c:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"checkPage\", \"checkPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0146:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"capture…age\",\n            reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0150:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"promptP…e\", \"promptPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x015a:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"selectP…e\", \"selectPage\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.network.NextStep_GovernmentId_LocalizationsJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$Localizations");
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Localizations localizations) {
        j.g(qVar, "writer");
        if (localizations != null) {
            qVar.c();
            qVar.u("selectPage");
            this.f26782b.toJson(qVar, localizations.j());
            qVar.u("promptPage");
            this.f26783c.toJson(qVar, localizations.g());
            qVar.u("capturePage");
            this.f26784d.toJson(qVar, localizations.c());
            qVar.u("checkPage");
            this.f26785e.toJson(qVar, localizations.d());
            qVar.u("pendingPage");
            this.f26786f.toJson(qVar, localizations.f());
            qVar.u("requestPage");
            this.f26787g.toJson(qVar, localizations.h());
            qVar.u("reviewUploadPage");
            this.f26788h.toJson(qVar, localizations.i());
            qVar.u("cancelDialog");
            this.f26789i.toJson(qVar, localizations.a());
            qVar.u("passportNfc");
            this.f26790j.toJson(qVar, localizations.e());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Localizations");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
