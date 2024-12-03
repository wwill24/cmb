package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class s6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f40259a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Uri f40260b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f40261c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f40262d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ t6 f40263e;

    s6(t6 t6Var, boolean z10, Uri uri, String str, String str2) {
        this.f40263e = t6Var;
        this.f40259a = z10;
        this.f40260b = uri;
        this.f40261c = str;
        this.f40262d = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3 A[SYNTHETIC, Splitter:B:32:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fb A[Catch:{ RuntimeException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fd A[Catch:{ RuntimeException -> 0x0190 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            com.google.android.gms.measurement.internal.t6 r2 = r1.f40263e
            boolean r0 = r1.f40259a
            android.net.Uri r3 = r1.f40260b
            java.lang.String r4 = r1.f40261c
            java.lang.String r5 = r1.f40262d
            com.google.android.gms.measurement.internal.u6 r6 = r2.f40281a
            r6.h()
            com.google.android.gms.measurement.internal.u6 r6 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.t9 r6 = r6.N()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.internal.measurement.zzra.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u6 r7 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.g r7 = r7.z()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.f3 r8 = com.google.android.gms.measurement.internal.g3.f39852x0     // Catch:{ RuntimeException -> 0x0190 }
            r9 = 0
            boolean r7 = r7.B(r9, r8)     // Catch:{ RuntimeException -> 0x0190 }
            boolean r10 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r11 = "Activity created with data 'referrer' without required params"
            java.lang.String r12 = "utm_medium"
            java.lang.String r13 = "_cis"
            java.lang.String r14 = "utm_source"
            java.lang.String r15 = "utm_campaign"
            java.lang.String r9 = "gclid"
            if (r10 == 0) goto L_0x003f
        L_0x003d:
            r6 = 0
            goto L_0x009f
        L_0x003f:
            boolean r10 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            boolean r10 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            boolean r10 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            boolean r10 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "utm_id"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "dclid"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            java.lang.String r10 = "srsltid"
            boolean r10 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r10 != 0) goto L_0x008a
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "sfmc_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0190 }
            if (r7 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r7 = 1
            goto L_0x008a
        L_0x007c:
            com.google.android.gms.measurement.internal.u4 r6 = r6.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.o3 r6 = r6.q()     // Catch:{ RuntimeException -> 0x0190 }
            r6.a(r11)     // Catch:{ RuntimeException -> 0x0190 }
            goto L_0x003d
        L_0x008a:
            java.lang.String r10 = "https://google.com/search?"
            java.lang.String r10 = r10.concat(r5)     // Catch:{ RuntimeException -> 0x0190 }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ RuntimeException -> 0x0190 }
            android.os.Bundle r6 = r6.v0(r10, r7)     // Catch:{ RuntimeException -> 0x0190 }
            if (r6 == 0) goto L_0x009f
            java.lang.String r7 = "referrer"
            r6.putString(r13, r7)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x009f:
            java.lang.String r7 = "_cmp"
            if (r0 == 0) goto L_0x00f5
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.t9 r0 = r0.N()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.internal.measurement.zzra.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u6 r10 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r10 = r10.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.g r10 = r10.z()     // Catch:{ RuntimeException -> 0x0190 }
            r1 = 0
            boolean r8 = r10.B(r1, r8)     // Catch:{ RuntimeException -> 0x0190 }
            android.os.Bundle r0 = r0.v0(r3, r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x00f5
            java.lang.String r1 = "intent"
            r0.putString(r13, r1)     // Catch:{ RuntimeException -> 0x0190 }
            boolean r1 = r0.containsKey(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r1 != 0) goto L_0x00e9
            if (r6 == 0) goto L_0x00e9
            boolean r1 = r6.containsKey(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r1 == 0) goto L_0x00e9
            java.lang.String r1 = "_cer"
            java.lang.String r3 = "gclid=%s"
            r8 = 1
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ RuntimeException -> 0x0190 }
            r8 = 0
            java.lang.String r13 = r6.getString(r9)     // Catch:{ RuntimeException -> 0x0190 }
            r10[r8] = r13     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r3 = java.lang.String.format(r3, r10)     // Catch:{ RuntimeException -> 0x0190 }
            r0.putString(r1, r3)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00e9:
            com.google.android.gms.measurement.internal.u6 r1 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            r1.u(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u6 r1 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.z9 r1 = r1.f40338l     // Catch:{ RuntimeException -> 0x0190 }
            r1.a(r4, r0)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00f5:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x00fd
            goto L_0x017f
        L_0x00fd:
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r1 = "Activity created with referrer"
            r0.b(r1, r5)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.g r0 = r0.z()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.f3 r1 = com.google.android.gms.measurement.internal.g3.f39810c0     // Catch:{ RuntimeException -> 0x0190 }
            r3 = 0
            boolean r0 = r0.B(r3, r1)     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r1 = "_ldl"
            java.lang.String r3 = "auto"
            if (r0 == 0) goto L_0x014b
            if (r6 == 0) goto L_0x0132
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            r0.u(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.z9 r0 = r0.f40338l     // Catch:{ RuntimeException -> 0x0190 }
            r0.a(r4, r6)     // Catch:{ RuntimeException -> 0x0190 }
            goto L_0x0143
        L_0x0132:
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.b(r4, r5)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x0143:
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            r4 = 1
            r5 = 0
            r0.K(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0190 }
            return
        L_0x014b:
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x0180
            boolean r0 = r5.contains(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x0180
        L_0x0173:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x017f
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            r4 = 1
            r0.K(r3, r1, r5, r4)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x017f:
            return
        L_0x0180:
            com.google.android.gms.measurement.internal.u6 r0 = r2.f40281a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()     // Catch:{ RuntimeException -> 0x0190 }
            r0.a(r11)     // Catch:{ RuntimeException -> 0x0190 }
            return
        L_0x0190:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u6 r1 = r2.f40281a
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.r()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.s6.run():void");
    }
}
