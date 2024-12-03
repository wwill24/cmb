package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

@TargetApi(14)
final class t6 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u6 f40281a;

    t6(u6 u6Var) {
        this.f40281a = u6Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[Catch:{ RuntimeException -> 0x00c4, all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0 A[Catch:{ RuntimeException -> 0x00c4, all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2 A[Catch:{ RuntimeException -> 0x00c4, all -> 0x00c2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.u6 r0 = r8.f40281a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()     // Catch:{ RuntimeException -> 0x00c4 }
            java.lang.String r1 = "onActivityCreated"
            r0.a(r1)     // Catch:{ RuntimeException -> 0x00c4 }
            android.content.Intent r0 = r9.getIntent()     // Catch:{ RuntimeException -> 0x00c4 }
            if (r0 != 0) goto L_0x0023
            com.google.android.gms.measurement.internal.u6 r0 = r8.f40281a
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
        L_0x001b:
            com.google.android.gms.measurement.internal.g7 r0 = r0.K()
            r0.y(r9, r10)
            return
        L_0x0023:
            com.google.android.gms.internal.measurement.zzpb.zzc()     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.u6 r1 = r8.f40281a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.g r1 = r1.z()     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.f3 r2 = com.google.android.gms.measurement.internal.g3.H0     // Catch:{ RuntimeException -> 0x00c4 }
            r3 = 0
            boolean r1 = r1.B(r3, r2)     // Catch:{ RuntimeException -> 0x00c4 }
            if (r1 != 0) goto L_0x003d
            android.net.Uri r3 = r0.getData()     // Catch:{ RuntimeException -> 0x00c4 }
        L_0x003b:
            r4 = r3
            goto L_0x0063
        L_0x003d:
            android.net.Uri r1 = r0.getData()     // Catch:{ RuntimeException -> 0x00c4 }
            if (r1 == 0) goto L_0x004c
            boolean r2 = r1.isHierarchical()     // Catch:{ RuntimeException -> 0x00c4 }
            if (r2 != 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r4 = r1
            goto L_0x0063
        L_0x004c:
            android.os.Bundle r1 = r0.getExtras()     // Catch:{ RuntimeException -> 0x00c4 }
            if (r1 == 0) goto L_0x003b
            java.lang.String r2 = "com.android.vending.referral_url"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ RuntimeException -> 0x00c4 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ RuntimeException -> 0x00c4 }
            if (r2 != 0) goto L_0x003b
            android.net.Uri r3 = android.net.Uri.parse(r1)     // Catch:{ RuntimeException -> 0x00c4 }
            goto L_0x003b
        L_0x0063:
            if (r4 == 0) goto L_0x00bc
            boolean r1 = r4.isHierarchical()     // Catch:{ RuntimeException -> 0x00c4 }
            if (r1 != 0) goto L_0x006c
            goto L_0x00bc
        L_0x006c:
            com.google.android.gms.measurement.internal.u6 r1 = r8.f40281a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a     // Catch:{ RuntimeException -> 0x00c4 }
            r1.N()     // Catch:{ RuntimeException -> 0x00c4 }
            java.lang.String r1 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r0.getStringExtra(r1)     // Catch:{ RuntimeException -> 0x00c4 }
            java.lang.String r1 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r1 = r1.equals(r0)     // Catch:{ RuntimeException -> 0x00c4 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "https://www.google.com"
            boolean r1 = r1.equals(r0)     // Catch:{ RuntimeException -> 0x00c4 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = "android-app://com.google.appcrawler"
            boolean r0 = r1.equals(r0)     // Catch:{ RuntimeException -> 0x00c4 }
            if (r0 == 0) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            java.lang.String r0 = "auto"
            goto L_0x0097
        L_0x0095:
            java.lang.String r0 = "gs"
        L_0x0097:
            r5 = r0
            java.lang.String r0 = "referrer"
            java.lang.String r6 = r4.getQueryParameter(r0)     // Catch:{ RuntimeException -> 0x00c4 }
            if (r10 != 0) goto L_0x00a2
            r0 = 1
            goto L_0x00a3
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            r3 = r0
            com.google.android.gms.measurement.internal.u6 r0 = r8.f40281a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.s4 r0 = r0.f()     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.s6 r7 = new com.google.android.gms.measurement.internal.s6     // Catch:{ RuntimeException -> 0x00c4 }
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ RuntimeException -> 0x00c4 }
            r0.z(r7)     // Catch:{ RuntimeException -> 0x00c4 }
            com.google.android.gms.measurement.internal.u6 r0 = r8.f40281a
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            goto L_0x001b
        L_0x00bc:
            com.google.android.gms.measurement.internal.u6 r0 = r8.f40281a
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            goto L_0x001b
        L_0x00c2:
            r0 = move-exception
            goto L_0x00dc
        L_0x00c4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u6 r1 = r8.f40281a     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.measurement.internal.q3 r1 = r1.d()     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.measurement.internal.o3 r1 = r1.r()     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.b(r2, r0)     // Catch:{ all -> 0x00c2 }
            com.google.android.gms.measurement.internal.u6 r0 = r8.f40281a
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            goto L_0x001b
        L_0x00dc:
            com.google.android.gms.measurement.internal.u6 r1 = r8.f40281a
            com.google.android.gms.measurement.internal.u4 r1 = r1.f40059a
            com.google.android.gms.measurement.internal.g7 r1 = r1.K()
            r1.y(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t6.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f40281a.f40059a.K().z(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.f40281a.f40059a.K().A(activity);
        w8 M = this.f40281a.f40059a.M();
        M.f40059a.f().z(new p8(M, M.f40059a.a().b()));
    }

    public final void onActivityResumed(Activity activity) {
        w8 M = this.f40281a.f40059a.M();
        M.f40059a.f().z(new o8(M, M.f40059a.a().b()));
        this.f40281a.f40059a.K().B(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f40281a.f40059a.K().C(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
