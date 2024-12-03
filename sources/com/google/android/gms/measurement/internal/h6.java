package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class h6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f39895a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f39896b;

    h6(u6 u6Var, zzcf zzcf) {
        this.f39896b = u6Var;
        this.f39895a = zzcf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009a A[SYNTHETIC, Splitter:B:15:0x009a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.u6 r0 = r6.f39896b
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            com.google.android.gms.measurement.internal.w8 r0 = r0.M()
            com.google.android.gms.internal.measurement.zzqr.zzc()
            com.google.android.gms.measurement.internal.u4 r1 = r0.f40059a
            com.google.android.gms.measurement.internal.g r1 = r1.z()
            com.google.android.gms.measurement.internal.f3 r2 = com.google.android.gms.measurement.internal.g3.f39850w0
            r3 = 0
            boolean r1 = r1.B(r3, r2)
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.measurement.internal.u4 r1 = r0.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            we.o r1 = r1.q()
            com.google.android.gms.measurement.internal.zzha r2 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE
            boolean r1 = r1.j(r2)
            if (r1 != 0) goto L_0x003c
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.x()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.a(r1)
            goto L_0x0085
        L_0x003c:
            com.google.android.gms.measurement.internal.u4 r1 = r0.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.u4 r2 = r0.f40059a
            me.f r2 = r2.a()
            long r4 = r2.currentTimeMillis()
            boolean r1 = r1.v(r4)
            if (r1 != 0) goto L_0x0085
            com.google.android.gms.measurement.internal.u4 r1 = r0.f40059a
            com.google.android.gms.measurement.internal.e4 r1 = r1.F()
            com.google.android.gms.measurement.internal.b4 r1 = r1.f39751p
            long r1 = r1.a()
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0065
            goto L_0x0085
        L_0x0065:
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            com.google.android.gms.measurement.internal.e4 r0 = r0.F()
            com.google.android.gms.measurement.internal.b4 r0 = r0.f39751p
            long r0 = r0.a()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x0086
        L_0x0076:
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.x()
            java.lang.String r1 = "getSessionId has been disabled."
            r0.a(r1)
        L_0x0085:
            r0 = r3
        L_0x0086:
            if (r0 == 0) goto L_0x009a
            com.google.android.gms.measurement.internal.u6 r1 = r6.f39896b
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a
            com.google.android.gms.measurement.internal.t9 r1 = r1.N()
            com.google.android.gms.internal.measurement.zzcf r2 = r6.f39895a
            long r3 = r0.longValue()
            r1.J(r2, r3)
            return
        L_0x009a:
            com.google.android.gms.internal.measurement.zzcf r0 = r6.f39895a     // Catch:{ RemoteException -> 0x00a0 }
            r0.zze(r3)     // Catch:{ RemoteException -> 0x00a0 }
            return
        L_0x00a0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u6 r1 = r6.f39896b
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.r()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.h6.run():void");
    }
}
