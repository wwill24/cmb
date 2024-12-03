package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_CapturePageJsonAdapter extends h<NextStep.GovernmentId.CapturePage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26761a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26762b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26763c;

    public NextStep_GovernmentId_CapturePageJsonAdapter(s sVar) {
        s sVar2 = sVar;
        Class<String> cls = String.class;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("scanFront", "scanBack", "scanPdf417", "scanFrontOrBack", "scanSignature", "capturing", "confirmCapture", "disclaimer", "hintHoldStill", "hintLowLight", "btnHelp", "barcodeHelpModalTitle", "barcodeHelpModalPrompt", "barcodeHelpModalHints", "barcodeHelpModalContinueBtn", "idFrontHelpModalTitle", "idFrontHelpModalPrompt", "idFrontHelpModalHintsMobile", "idFrontHelpModalContinueBtn", "idBackHelpModalTitle", "idBackHelpModalPrompt", "idBackHelpModalHintsMobile", "idBackHelpModalContinueBtn");
        j.f(a10, "of(\"scanFront\", \"scanBac…ackHelpModalContinueBtn\")");
        this.f26761a = a10;
        h<String> f10 = sVar2.f(cls, n0.e(), "scanFront");
        j.f(f10, "moshi.adapter(String::cl…Set(),\n      \"scanFront\")");
        this.f26762b = f10;
        h<String> f11 = sVar2.f(cls, n0.e(), "disclaimer");
        j.f(f11, "moshi.adapter(String::cl…emptySet(), \"disclaimer\")");
        this.f26763c = f11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01d5, code lost:
        r15 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01d7, code lost:
        r14 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01d9, code lost:
        r13 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01db, code lost:
        r12 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01dd, code lost:
        r11 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01df, code lost:
        r10 = r32;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.CapturePage fromJson(com.squareup.moshi.JsonReader r34) {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.j.g(r1, r2)
            r34.b()
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
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
            r25 = r24
            r26 = r25
        L_0x002f:
            boolean r2 = r34.g()
            java.lang.String r3 = "confirmCapture"
            r27 = r15
            java.lang.String r15 = "capturing"
            r28 = r14
            java.lang.String r14 = "scanSignature"
            r29 = r13
            java.lang.String r13 = "scanFrontOrBack"
            r30 = r12
            java.lang.String r12 = "scanPdf417"
            r31 = r11
            java.lang.String r11 = "scanBack"
            r32 = r10
            java.lang.String r10 = "scanFront"
            if (r2 == 0) goto L_0x01e3
            com.squareup.moshi.JsonReader$b r2 = r0.f26761a
            int r2 = r1.L(r2)
            switch(r2) {
                case -1: goto L_0x01cf;
                case 0: goto L_0x01b9;
                case 1: goto L_0x01a3;
                case 2: goto L_0x018d;
                case 3: goto L_0x0177;
                case 4: goto L_0x0161;
                case 5: goto L_0x014a;
                case 6: goto L_0x0129;
                case 7: goto L_0x0116;
                case 8: goto L_0x0105;
                case 9: goto L_0x00f6;
                case 10: goto L_0x00e9;
                case 11: goto L_0x00de;
                case 12: goto L_0x00d2;
                case 13: goto L_0x00c6;
                case 14: goto L_0x00ba;
                case 15: goto L_0x00ae;
                case 16: goto L_0x00a2;
                case 17: goto L_0x0096;
                case 18: goto L_0x008a;
                case 19: goto L_0x007e;
                case 20: goto L_0x0072;
                case 21: goto L_0x0066;
                case 22: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x01d5
        L_0x005a:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r26 = r2
            java.lang.String r26 = (java.lang.String) r26
            goto L_0x01d5
        L_0x0066:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r25 = r2
            java.lang.String r25 = (java.lang.String) r25
            goto L_0x01d5
        L_0x0072:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r24 = r2
            java.lang.String r24 = (java.lang.String) r24
            goto L_0x01d5
        L_0x007e:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r23 = r2
            java.lang.String r23 = (java.lang.String) r23
            goto L_0x01d5
        L_0x008a:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r22 = r2
            java.lang.String r22 = (java.lang.String) r22
            goto L_0x01d5
        L_0x0096:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r21 = r2
            java.lang.String r21 = (java.lang.String) r21
            goto L_0x01d5
        L_0x00a2:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r20 = r2
            java.lang.String r20 = (java.lang.String) r20
            goto L_0x01d5
        L_0x00ae:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r19 = r2
            java.lang.String r19 = (java.lang.String) r19
            goto L_0x01d5
        L_0x00ba:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r18 = r2
            java.lang.String r18 = (java.lang.String) r18
            goto L_0x01d5
        L_0x00c6:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            goto L_0x01d5
        L_0x00d2:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            goto L_0x01d5
        L_0x00de:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x01d7
        L_0x00e9:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            r15 = r27
            goto L_0x01d9
        L_0x00f6:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            r15 = r27
            r14 = r28
            goto L_0x01db
        L_0x0105:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            r15 = r27
            r14 = r28
            r13 = r29
            goto L_0x01dd
        L_0x0116:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26763c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            r15 = r27
            r14 = r28
            r13 = r29
            r12 = r30
            goto L_0x01df
        L_0x0129:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x0140
            r15 = r27
            r14 = r28
            r13 = r29
            r12 = r30
            r11 = r31
            goto L_0x002f
        L_0x0140:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r3, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"confirmC…\"confirmCapture\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x014a:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0157
            goto L_0x01d5
        L_0x0157:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"capturin…     \"capturing\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0161:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x016d
            goto L_0x01d5
        L_0x016d:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"scanSign… \"scanSignature\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0177:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0183
            goto L_0x01d5
        L_0x0183:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"scanFron…scanFrontOrBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x018d:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0199
            goto L_0x01d5
        L_0x0199:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"scanPdf4…    \"scanPdf417\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01a3:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x01af
            goto L_0x01d5
        L_0x01af:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"scanBack…      \"scanBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01b9:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26762b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x01c5
            goto L_0x01d5
        L_0x01c5:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"scanFron…     \"scanFront\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01cf:
            r34.S()
            r34.Y()
        L_0x01d5:
            r15 = r27
        L_0x01d7:
            r14 = r28
        L_0x01d9:
            r13 = r29
        L_0x01db:
            r12 = r30
        L_0x01dd:
            r11 = r31
        L_0x01df:
            r10 = r32
            goto L_0x002f
        L_0x01e3:
            r34.e()
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CapturePage r2 = new com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CapturePage
            if (r4 == 0) goto L_0x0243
            if (r5 == 0) goto L_0x0239
            if (r6 == 0) goto L_0x022f
            if (r7 == 0) goto L_0x0225
            if (r8 == 0) goto L_0x021b
            if (r9 == 0) goto L_0x0211
            if (r32 == 0) goto L_0x0207
            r3 = r2
            r10 = r32
            r11 = r31
            r12 = r30
            r13 = r29
            r14 = r28
            r15 = r27
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return r2
        L_0x0207:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r3, r3, r1)
            java.lang.String r2 = "missingProperty(\"confirm…\"confirmCapture\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0211:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"capturing\", \"capturing\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x021b:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"scanSig… \"scanSignature\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0225:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"scanFro…scanFrontOrBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x022f:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"scanPdf…7\", \"scanPdf417\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0239:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"scanBack\", \"scanBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0243:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"scanFront\", \"scanFront\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.network.NextStep_GovernmentId_CapturePageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$CapturePage");
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.CapturePage capturePage) {
        j.g(qVar, "writer");
        if (capturePage != null) {
            qVar.c();
            qVar.u("scanFront");
            this.f26762b.toJson(qVar, capturePage.u());
            qVar.u("scanBack");
            this.f26762b.toJson(qVar, capturePage.t());
            qVar.u("scanPdf417");
            this.f26762b.toJson(qVar, capturePage.x());
            qVar.u("scanFrontOrBack");
            this.f26762b.toJson(qVar, capturePage.w());
            qVar.u("scanSignature");
            this.f26762b.toJson(qVar, capturePage.z());
            qVar.u("capturing");
            this.f26762b.toJson(qVar, capturePage.g());
            qVar.u("confirmCapture");
            this.f26762b.toJson(qVar, capturePage.h());
            qVar.u("disclaimer");
            this.f26763c.toJson(qVar, capturePage.i());
            qVar.u("hintHoldStill");
            this.f26763c.toJson(qVar, capturePage.j());
            qVar.u("hintLowLight");
            this.f26763c.toJson(qVar, capturePage.k());
            qVar.u("btnHelp");
            this.f26763c.toJson(qVar, capturePage.f());
            qVar.u("barcodeHelpModalTitle");
            this.f26763c.toJson(qVar, capturePage.e());
            qVar.u("barcodeHelpModalPrompt");
            this.f26763c.toJson(qVar, capturePage.d());
            qVar.u("barcodeHelpModalHints");
            this.f26763c.toJson(qVar, capturePage.c());
            qVar.u("barcodeHelpModalContinueBtn");
            this.f26763c.toJson(qVar, capturePage.a());
            qVar.u("idFrontHelpModalTitle");
            this.f26763c.toJson(qVar, capturePage.s());
            qVar.u("idFrontHelpModalPrompt");
            this.f26763c.toJson(qVar, capturePage.r());
            qVar.u("idFrontHelpModalHintsMobile");
            this.f26763c.toJson(qVar, capturePage.q());
            qVar.u("idFrontHelpModalContinueBtn");
            this.f26763c.toJson(qVar, capturePage.p());
            qVar.u("idBackHelpModalTitle");
            this.f26763c.toJson(qVar, capturePage.o());
            qVar.u("idBackHelpModalPrompt");
            this.f26763c.toJson(qVar, capturePage.n());
            qVar.u("idBackHelpModalHintsMobile");
            this.f26763c.toJson(qVar, capturePage.m());
            qVar.u("idBackHelpModalContinueBtn");
            this.f26763c.toJson(qVar, capturePage.l());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.CapturePage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
