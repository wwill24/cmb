package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_RequestPageJsonAdapter extends h<NextStep.GovernmentId.RequestPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26853a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26854b;

    public NextStep_GovernmentId_RequestPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("titleFront", "titleBack", "titlePdf417", "titlePassportSignature", "descriptionFront", "descriptionBack", "descriptionPdf417", "descriptionPassportSignature", "choosePhotoButtonText", "liveUploadButtonText");
        j.f(a10, "of(\"titleFront\", \"titleB…  \"liveUploadButtonText\")");
        this.f26853a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "titleFront");
        j.f(f10, "moshi.adapter(String::cl…et(),\n      \"titleFront\")");
        this.f26854b = f10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015d, code lost:
        r13 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x015f, code lost:
        r12 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0161, code lost:
        r11 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0163, code lost:
        r10 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0165, code lost:
        r9 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0167, code lost:
        r8 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0169, code lost:
        r7 = r22;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.RequestPage fromJson(com.squareup.moshi.JsonReader r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.j.g(r1, r2)
            r24.b()
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
        L_0x0017:
            boolean r2 = r24.g()
            java.lang.String r3 = "liveUploadButtonText"
            java.lang.String r14 = "choosePhotoButtonText"
            java.lang.String r15 = "descriptionPassportSignature"
            r16 = r13
            java.lang.String r13 = "descriptionPdf417"
            r17 = r12
            java.lang.String r12 = "descriptionBack"
            r18 = r11
            java.lang.String r11 = "descriptionFront"
            r19 = r10
            java.lang.String r10 = "titlePassportSignature"
            r20 = r9
            java.lang.String r9 = "titlePdf417"
            r21 = r8
            java.lang.String r8 = "titleBack"
            r22 = r7
            java.lang.String r7 = "titleFront"
            if (r2 == 0) goto L_0x016d
            com.squareup.moshi.JsonReader$b r2 = r0.f26853a
            int r2 = r1.L(r2)
            switch(r2) {
                case -1: goto L_0x0157;
                case 0: goto L_0x0141;
                case 1: goto L_0x012b;
                case 2: goto L_0x0115;
                case 3: goto L_0x00f2;
                case 4: goto L_0x00d1;
                case 5: goto L_0x00b2;
                case 6: goto L_0x0095;
                case 7: goto L_0x007a;
                case 8: goto L_0x0061;
                case 9: goto L_0x004a;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x015d
        L_0x004a:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r13 = r2
            java.lang.String r13 = (java.lang.String) r13
            if (r13 == 0) goto L_0x0057
            goto L_0x015f
        L_0x0057:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r3, r3, r1)
            java.lang.String r2 = "unexpectedNull(\"liveUplo…ploadButtonText\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0061:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x0070
            r13 = r16
            goto L_0x0161
        L_0x0070:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"choosePh…PhotoButtonText\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x007a:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r11 = r2
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x008b
            r13 = r16
            r12 = r17
            goto L_0x0163
        L_0x008b:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"descript…ssportSignature\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0095:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x00a8
            r13 = r16
            r12 = r17
            r11 = r18
            goto L_0x0165
        L_0x00a8:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r13, r13, r1)
            java.lang.String r2 = "unexpectedNull(\"descript…scriptionPdf417\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00b2:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x00c7
            r13 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            goto L_0x0167
        L_0x00c7:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r12, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"descript…descriptionBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00d1:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x00e8
            r13 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            goto L_0x0169
        L_0x00e8:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r11, r11, r1)
            java.lang.String r2 = "unexpectedNull(\"descript…escriptionFront\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x00f2:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x010b
            r13 = r16
            r12 = r17
            r11 = r18
            r10 = r19
            r9 = r20
            r8 = r21
            goto L_0x0017
        L_0x010b:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r10, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"titlePas…ssportSignature\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0115:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0121
            goto L_0x015d
        L_0x0121:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"titlePdf…\", \"titlePdf417\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x012b:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0137
            goto L_0x015d
        L_0x0137:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r8, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"titleBac…     \"titleBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0141:
            com.squareup.moshi.h<java.lang.String> r2 = r0.f26854b
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x014d
            goto L_0x015d
        L_0x014d:
            com.squareup.moshi.JsonDataException r1 = bi.c.x(r7, r7, r1)
            java.lang.String r2 = "unexpectedNull(\"titleFro…    \"titleFront\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x0157:
            r24.S()
            r24.Y()
        L_0x015d:
            r13 = r16
        L_0x015f:
            r12 = r17
        L_0x0161:
            r11 = r18
        L_0x0163:
            r10 = r19
        L_0x0165:
            r9 = r20
        L_0x0167:
            r8 = r21
        L_0x0169:
            r7 = r22
            goto L_0x0017
        L_0x016d:
            r24.e()
            com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$RequestPage r2 = new com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$RequestPage
            if (r4 == 0) goto L_0x01f3
            if (r5 == 0) goto L_0x01e9
            if (r6 == 0) goto L_0x01df
            if (r22 == 0) goto L_0x01d5
            if (r21 == 0) goto L_0x01cb
            if (r20 == 0) goto L_0x01c1
            if (r19 == 0) goto L_0x01b7
            if (r18 == 0) goto L_0x01ad
            if (r17 == 0) goto L_0x01a3
            if (r16 == 0) goto L_0x0199
            r3 = r2
            r7 = r22
            r8 = r21
            r9 = r20
            r10 = r19
            r11 = r18
            r12 = r17
            r13 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r2
        L_0x0199:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r3, r3, r1)
            java.lang.String r2 = "missingProperty(\"liveUpl…ploadButtonText\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01a3:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"chooseP…PhotoButtonText\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01ad:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"descrip…ssportSignature\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01b7:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r13, r13, r1)
            java.lang.String r2 = "missingProperty(\"descrip…scriptionPdf417\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01c1:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r12, r12, r1)
            java.lang.String r2 = "missingProperty(\"descrip…descriptionBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01cb:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r11, r11, r1)
            java.lang.String r2 = "missingProperty(\"descrip…escriptionFront\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01d5:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r10, r10, r1)
            java.lang.String r2 = "missingProperty(\"titlePa…ssportSignature\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01df:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"titlePd…417\",\n            reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01e9:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r8, r8, r1)
            java.lang.String r2 = "missingProperty(\"titleBack\", \"titleBack\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        L_0x01f3:
            com.squareup.moshi.JsonDataException r1 = bi.c.o(r7, r7, r1)
            java.lang.String r2 = "missingProperty(\"titleFr…t\", \"titleFront\", reader)"
            kotlin.jvm.internal.j.f(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.network.NextStep_GovernmentId_RequestPageJsonAdapter.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$RequestPage");
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.RequestPage requestPage) {
        j.g(qVar, "writer");
        if (requestPage != null) {
            qVar.c();
            qVar.u("titleFront");
            this.f26854b.toJson(qVar, requestPage.k());
            qVar.u("titleBack");
            this.f26854b.toJson(qVar, requestPage.i());
            qVar.u("titlePdf417");
            this.f26854b.toJson(qVar, requestPage.m());
            qVar.u("titlePassportSignature");
            this.f26854b.toJson(qVar, requestPage.l());
            qVar.u("descriptionFront");
            this.f26854b.toJson(qVar, requestPage.e());
            qVar.u("descriptionBack");
            this.f26854b.toJson(qVar, requestPage.c());
            qVar.u("descriptionPdf417");
            this.f26854b.toJson(qVar, requestPage.g());
            qVar.u("descriptionPassportSignature");
            this.f26854b.toJson(qVar, requestPage.f());
            qVar.u("choosePhotoButtonText");
            this.f26854b.toJson(qVar, requestPage.a());
            qVar.u("liveUploadButtonText");
            this.f26854b.toJson(qVar, requestPage.h());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.RequestPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
