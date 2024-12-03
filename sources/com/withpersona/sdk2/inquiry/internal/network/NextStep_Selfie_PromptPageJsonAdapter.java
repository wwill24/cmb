package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Selfie_PromptPageJsonAdapter extends h<NextStep.Selfie.PromptPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26878a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26879b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26880c;

    public NextStep_Selfie_PromptPageJsonAdapter(s sVar) {
        s sVar2 = sVar;
        Class<String> cls = String.class;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selfieTitle", "selfiePrompt", "selfiePromptCenter", "agreeToPolicy", "btnSubmit", "cameraPermissionsTitle", "cameraPermissionsPrompt", "cameraPermissionsBtnContinueMobile", "cameraPermissionsBtnCancel", "microphonePermissionsBtnCancel", "microphonePermissionsBtnContinueMobile", "microphonePermissionsPrompt", "microphonePermissionsTitle");
        j.f(a10, "of(\"selfieTitle\", \"selfi…rophonePermissionsTitle\")");
        this.f26878a = a10;
        h<String> f10 = sVar2.f(cls, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.f26879b = f10;
        h<String> f11 = sVar2.f(cls, n0.e(), "cameraPermissionsTitle");
        j.f(f11, "moshi.adapter(String::cl…\"cameraPermissionsTitle\")");
        this.f26880c = f11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0169, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x016b, code lost:
        r14 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x016d, code lost:
        r13 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x016f, code lost:
        r12 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0171, code lost:
        r11 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0173, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0175, code lost:
        r9 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0177, code lost:
        r8 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0179, code lost:
        r7 = r25;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.withpersona.sdk2.inquiry.internal.network.NextStep.Selfie.PromptPage fromJson(com.squareup.moshi.JsonReader r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.j.g(r1, r2)
            r27.b()
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
        L_0x001b:
            boolean r2 = r27.g()
            java.lang.String r3 = "btnSubmit"
            r17 = r15
            java.lang.String r15 = "buttonSubmit"
            r18 = r14
            java.lang.String r14 = "agreeToPolicy"
            r19 = r13
            java.lang.String r13 = "disclosure"
            r20 = r12
            java.lang.String r12 = "selfiePromptCenter"
            r21 = r11
            java.lang.String r11 = "promptCenter"
            r22 = r10
            java.lang.String r10 = "selfiePrompt"
            r23 = r9
            java.lang.String r9 = "prompt"
            r24 = r8
            java.lang.String r8 = "selfieTitle"
            r25 = r7
            java.lang.String r7 = "title"
            if (r2 == 0) goto L_0x017d
            com.squareup.moshi.JsonReader$b r2 = r0.f26878a
            int r2 = r1.L(r2)
            switch(r2) {
                case -1: goto L_0x0163;
                case 0: goto L_0x014d;
                case 1: goto L_0x0137;
                case 2: goto L_0x0121;
                case 3: goto L_0x00fa;
                case 4: goto L_0x00d5;
                case 5: goto L_0x00be;
                case 6: goto L_0x00a9;
                case 7: goto L_0x0096;
                case 8: goto L_0x0085;
                case 9: goto L_0x0076;
                case 10: goto L_0x0069;
                case 11: goto L_0x005e;
                case 12: goto L_0x0052;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x0169
        L_0x0052:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r16 = r2
            java.lang.String r16 = (java.lang.String) r16
            goto L_0x0169
        L_0x005e:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x016b
        L_0x0069:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14
            r15 = r17
            goto L_0x016d
        L_0x0076:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            r15 = r17
            r14 = r18
            goto L_0x016f
        L_0x0085:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            r15 = r17
            r14 = r18
            r13 = r19
            goto L_0x0171
        L_0x0096:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            r15 = r17
            r14 = r18
            r13 = r19
            r12 = r20
            goto L_0x0173
        L_0x00a9:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            r15 = r17
            r14 = r18
            r13 = r19
            r12 = r20
            r11 = r21
            goto L_0x0175
        L_0x00be:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26880c
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            r15 = r17
            r14 = r18
            r13 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            goto L_0x0177
        L_0x00d5:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26879b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x00f0
            r15 = r17
            r14 = r18
            r13 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            goto L_0x0179
        L_0x00f0:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r15, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"buttonSu…it\", \"btnSubmit\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00fa:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26879b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0117
            r15 = r17
            r14 = r18
            r13 = r19
            r12 = r20
            r11 = r21
            r10 = r22
            r9 = r23
            r8 = r24
            goto L_0x001b
        L_0x0117:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r13, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"disclosu… \"agreeToPolicy\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0121:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26879b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x012d
            goto L_0x0169
        L_0x012d:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r11, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"promptCe…fiePromptCenter\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0137:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26879b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0143
            goto L_0x0169
        L_0x0143:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r9, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"prompt\",…  \"selfiePrompt\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x014d:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26879b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x0159
            goto L_0x0169
        L_0x0159:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r7, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"title\",\n…   \"selfieTitle\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0163:
            r27.S()
            r27.Y()
        L_0x0169:
            r15 = r17
        L_0x016b:
            r14 = r18
        L_0x016d:
            r13 = r19
        L_0x016f:
            r12 = r20
        L_0x0171:
            r11 = r21
        L_0x0173:
            r10 = r22
        L_0x0175:
            r9 = r23
        L_0x0177:
            r8 = r24
        L_0x0179:
            r7 = r25
            goto L_0x001b
        L_0x017d:
            r27.e()
            com.withpersona.sdk2.inquiry.internal.network.NextStep$Selfie$PromptPage r2 = new com.withpersona.sdk2.inquiry.internal.network.NextStep$Selfie$PromptPage
            if (r4 == 0) goto L_0x01cb
            if (r5 == 0) goto L_0x01c1
            if (r6 == 0) goto L_0x01b7
            if (r25 == 0) goto L_0x01ad
            if (r24 == 0) goto L_0x01a3
            r3 = r2
            r7 = r25
            r8 = r24
            r9 = r23
            r10 = r22
            r11 = r21
            r12 = r20
            r13 = r19
            r14 = r18
            r15 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r2
        L_0x01a3:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r15, r3, r1)
            java.lang.String r2 = "missingProperty(\"buttonS…mit\",\n            reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01ad:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r13, r14, r1)
            java.lang.String r2 = "missingProperty(\"disclos…icy\",\n            reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01b7:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r11, r12, r1)
            java.lang.String r2 = "missingProperty(\"promptC…fiePromptCenter\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01c1:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r9, r10, r1)
            java.lang.String r2 = "missingProperty(\"prompt\", \"selfiePrompt\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01cb:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r7, r8, r1)
            java.lang.String r2 = "missingProperty(\"title\", \"selfieTitle\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.network.NextStep_Selfie_PromptPageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.internal.network.NextStep$Selfie$PromptPage");
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Selfie.PromptPage promptPage) {
        j.g(qVar, "writer");
        if (promptPage != null) {
            qVar.c();
            qVar.u("selfieTitle");
            this.f26879b.toJson(qVar, promptPage.n());
            qVar.u("selfiePrompt");
            this.f26879b.toJson(qVar, promptPage.l());
            qVar.u("selfiePromptCenter");
            this.f26879b.toJson(qVar, promptPage.m());
            qVar.u("agreeToPolicy");
            this.f26879b.toJson(qVar, promptPage.g());
            qVar.u("btnSubmit");
            this.f26879b.toJson(qVar, promptPage.a());
            qVar.u("cameraPermissionsTitle");
            this.f26880c.toJson(qVar, promptPage.f());
            qVar.u("cameraPermissionsPrompt");
            this.f26880c.toJson(qVar, promptPage.e());
            qVar.u("cameraPermissionsBtnContinueMobile");
            this.f26880c.toJson(qVar, promptPage.c());
            qVar.u("cameraPermissionsBtnCancel");
            this.f26880c.toJson(qVar, promptPage.d());
            qVar.u("microphonePermissionsBtnCancel");
            this.f26880c.toJson(qVar, promptPage.h());
            qVar.u("microphonePermissionsBtnContinueMobile");
            this.f26880c.toJson(qVar, promptPage.i());
            qVar.u("microphonePermissionsPrompt");
            this.f26880c.toJson(qVar, promptPage.j());
            qVar.u("microphonePermissionsTitle");
            this.f26880c.toJson(qVar, promptPage.k());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Selfie.PromptPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
