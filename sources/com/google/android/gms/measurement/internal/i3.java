package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

public final class i3 extends w3 {

    /* renamed from: c  reason: collision with root package name */
    private String f39916c;

    /* renamed from: d  reason: collision with root package name */
    private String f39917d;

    /* renamed from: e  reason: collision with root package name */
    private int f39918e;

    /* renamed from: f  reason: collision with root package name */
    private String f39919f;

    /* renamed from: g  reason: collision with root package name */
    private String f39920g;

    /* renamed from: h  reason: collision with root package name */
    private long f39921h;

    /* renamed from: i  reason: collision with root package name */
    private final long f39922i;

    /* renamed from: j  reason: collision with root package name */
    private List f39923j;

    /* renamed from: k  reason: collision with root package name */
    private String f39924k;

    /* renamed from: l  reason: collision with root package name */
    private int f39925l;

    /* renamed from: m  reason: collision with root package name */
    private String f39926m;

    /* renamed from: n  reason: collision with root package name */
    private String f39927n;

    /* renamed from: o  reason: collision with root package name */
    private String f39928o;

    /* renamed from: p  reason: collision with root package name */
    private long f39929p = 0;

    /* renamed from: q  reason: collision with root package name */
    private String f39930q = null;

    i3(u4 u4Var, long j10) {
        super(u4Var);
        this.f39922i = j10;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018a A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018b A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0194 A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01bc A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x024c  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.u4 r0 = r11.f40059a
            android.content.Context r0 = r0.c()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.u4 r1 = r11.f40059a
            android.content.Context r1 = r1.c()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r4 = ""
            r5 = 0
            java.lang.String r6 = "unknown"
            if (r1 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.u4 r7 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r7 = r7.d()
            com.google.android.gms.measurement.internal.o3 r7 = r7.r()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.b(r9, r8)
        L_0x0032:
            r8 = r2
            goto L_0x009b
        L_0x0035:
            java.lang.String r6 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003a }
            goto L_0x004d
        L_0x003a:
            com.google.android.gms.measurement.internal.u4 r7 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r7 = r7.d()
            com.google.android.gms.measurement.internal.o3 r7 = r7.r()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.b(r9, r8)
        L_0x004d:
            if (r6 != 0) goto L_0x0052
            java.lang.String r6 = "manual_install"
            goto L_0x005b
        L_0x0052:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x005b
            r6 = r4
        L_0x005b:
            com.google.android.gms.measurement.internal.u4 r7 = r11.f40059a     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.Context r7 = r7.c()     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r5)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r7 == 0) goto L_0x0032
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r9 != 0) goto L_0x007c
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0085 }
            goto L_0x007d
        L_0x007c:
            r8 = r2
        L_0x007d:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0082 }
            int r3 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0082 }
            goto L_0x009b
        L_0x0082:
            r7 = r2
            r2 = r8
            goto L_0x0086
        L_0x0085:
            r7 = r2
        L_0x0086:
            com.google.android.gms.measurement.internal.u4 r8 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r8 = r8.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.r()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.q3.z(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.c(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x009b:
            r11.f39916c = r0
            r11.f39919f = r6
            r11.f39917d = r2
            r11.f39918e = r3
            r11.f39920g = r8
            r2 = 0
            r11.f39921h = r2
            com.google.android.gms.measurement.internal.u4 r2 = r11.f40059a
            java.lang.String r2 = r2.O()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.u4 r2 = r11.f40059a
            java.lang.String r2 = r2.P()
            java.lang.String r3 = "am"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00c5
            r2 = 1
            goto L_0x00c6
        L_0x00c5:
            r2 = r5
        L_0x00c6:
            com.google.android.gms.measurement.internal.u4 r3 = r11.f40059a
            int r3 = r3.x()
            switch(r3) {
                case 0: goto L_0x0150;
                case 1: goto L_0x0140;
                case 2: goto L_0x0130;
                case 3: goto L_0x0120;
                case 4: goto L_0x0110;
                case 5: goto L_0x0100;
                case 6: goto L_0x00f0;
                case 7: goto L_0x00e0;
                default: goto L_0x00cf;
            }
        L_0x00cf:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled due to denied storage consent"
            r6.a(r7)
            goto L_0x015f
        L_0x00e0:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled via the global data collection setting"
            r6.a(r7)
            goto L_0x015f
        L_0x00f0:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.x()
            java.lang.String r7 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r6.a(r7)
            goto L_0x015f
        L_0x0100:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.v()
            java.lang.String r7 = "App measurement disabled via the init parameters"
            r6.a(r7)
            goto L_0x015f
        L_0x0110:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled via the manifest"
            r6.a(r7)
            goto L_0x015f
        L_0x0120:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.u()
            java.lang.String r7 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r6.a(r7)
            goto L_0x015f
        L_0x0130:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.v()
            java.lang.String r7 = "App measurement deactivated via the init parameters"
            r6.a(r7)
            goto L_0x015f
        L_0x0140:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.u()
            java.lang.String r7 = "App measurement deactivated via the manifest"
            r6.a(r7)
            goto L_0x015f
        L_0x0150:
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()
            com.google.android.gms.measurement.internal.o3 r6 = r6.v()
            java.lang.String r7 = "App measurement collection enabled"
            r6.a(r7)
        L_0x015f:
            r11.f39926m = r4
            r11.f39927n = r4
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a
            r6.b()
            if (r2 == 0) goto L_0x0172
            com.google.android.gms.measurement.internal.u4 r2 = r11.f40059a
            java.lang.String r2 = r2.O()
            r11.f39927n = r2
        L_0x0172:
            com.google.android.gms.measurement.internal.u4 r2 = r11.f40059a     // Catch:{ IllegalStateException -> 0x01db }
            android.content.Context r2 = r2.c()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.u4 r6 = r11.f40059a     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r6 = r6.R()     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r7 = "google_app_id"
            java.lang.String r2 = we.v.c(r2, r7, r6)     // Catch:{ IllegalStateException -> 0x01db }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01db }
            if (r6 == 0) goto L_0x018b
            goto L_0x018c
        L_0x018b:
            r4 = r2
        L_0x018c:
            r11.f39926m = r4     // Catch:{ IllegalStateException -> 0x01db }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01db }
            if (r2 != 0) goto L_0x01ba
            com.google.android.gms.measurement.internal.u4 r2 = r11.f40059a     // Catch:{ IllegalStateException -> 0x01db }
            android.content.Context r2 = r2.c()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.u4 r4 = r11.f40059a     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r4 = r4.R()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.common.internal.p.k(r2)     // Catch:{ IllegalStateException -> 0x01db }
            android.content.res.Resources r6 = r2.getResources()     // Catch:{ IllegalStateException -> 0x01db }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01db }
            if (r7 != 0) goto L_0x01ae
            goto L_0x01b2
        L_0x01ae:
            java.lang.String r4 = we.k.a(r2)     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01b2:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = we.k.b(r2, r6, r4)     // Catch:{ IllegalStateException -> 0x01db }
            r11.f39927n = r2     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01ba:
            if (r3 != 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.u4 r2 = r11.f40059a     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.o3 r2 = r2.v()     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r4 = r11.f39916c     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r6 = r11.f39926m     // Catch:{ IllegalStateException -> 0x01db }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01db }
            if (r6 == 0) goto L_0x01d5
            java.lang.String r6 = r11.f39927n     // Catch:{ IllegalStateException -> 0x01db }
            goto L_0x01d7
        L_0x01d5:
            java.lang.String r6 = r11.f39926m     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01d7:
            r2.c(r3, r4, r6)     // Catch:{ IllegalStateException -> 0x01db }
            goto L_0x01ef
        L_0x01db:
            r2 = move-exception
            com.google.android.gms.measurement.internal.u4 r3 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.q3.z(r0)
            java.lang.String r4 = "Fetching Google App Id failed with exception. appId"
            r3.c(r4, r0, r2)
        L_0x01ef:
            r0 = 0
            r11.f39923j = r0
            com.google.android.gms.measurement.internal.u4 r0 = r11.f40059a
            r0.b()
            com.google.android.gms.measurement.internal.u4 r0 = r11.f40059a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.y(r2)
            if (r0 != 0) goto L_0x0206
            goto L_0x023b
        L_0x0206:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x021c
            com.google.android.gms.measurement.internal.u4 r0 = r11.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.x()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.a(r2)
            goto L_0x023d
        L_0x021c:
            java.util.Iterator r2 = r0.iterator()
        L_0x0220:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x023b
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.u4 r4 = r11.f40059a
            com.google.android.gms.measurement.internal.t9 r4 = r4.N()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r4.R(r6, r3)
            if (r3 != 0) goto L_0x0220
            goto L_0x023d
        L_0x023b:
            r11.f39923j = r0
        L_0x023d:
            if (r1 == 0) goto L_0x024c
            com.google.android.gms.measurement.internal.u4 r0 = r11.f40059a
            android.content.Context r0 = r0.c()
            boolean r0 = oe.a.a(r0)
            r11.f39925l = r0
            return
        L_0x024c:
            r11.f39925l = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i3.l():void");
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int o() {
        i();
        return this.f39925l;
    }

    /* access modifiers changed from: package-private */
    public final int p() {
        i();
        return this.f39918e;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzq q(java.lang.String r41) {
        /*
            r40 = this;
            r1 = r40
            r40.h()
            com.google.android.gms.measurement.internal.zzq r36 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r3 = r40.s()
            java.lang.String r4 = r40.t()
            r40.i()
            java.lang.String r5 = r1.f39917d
            r40.i()
            int r0 = r1.f39918e
            long r6 = (long) r0
            r40.i()
            java.lang.String r0 = r1.f39919f
            com.google.android.gms.common.internal.p.k(r0)
            java.lang.String r8 = r1.f39919f
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a
            com.google.android.gms.measurement.internal.g r0 = r0.z()
            r0.q()
            r40.i()
            r40.h()
            long r9 = r1.f39921h
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r2 = 0
            if (r0 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a
            com.google.android.gms.measurement.internal.t9 r9 = r0.N()
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a
            android.content.Context r0 = r0.c()
            com.google.android.gms.measurement.internal.u4 r10 = r1.f40059a
            android.content.Context r10 = r10.c()
            java.lang.String r10 = r10.getPackageName()
            r9.h()
            com.google.android.gms.common.internal.p.k(r0)
            com.google.android.gms.common.internal.p.g(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.t9.t()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.u4 r0 = r9.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.a(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00ce
        L_0x0078:
            if (r13 == 0) goto L_0x00cd
            boolean r10 = r9.W(r0, r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 != 0) goto L_0x00bb
            oe.c r0 = oe.d.a(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.u4 r10 = r9.f40059a     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.Context r10 = r10.c()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00bd }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.e(r10, r13)     // Catch:{ NameNotFoundException -> 0x00bd }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r0 == 0) goto L_0x00ab
            int r10 = r0.length     // Catch:{ NameNotFoundException -> 0x00bd }
            if (r10 <= 0) goto L_0x00ab
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00bd }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            long r9 = com.google.android.gms.measurement.internal.t9.s0(r0)     // Catch:{ NameNotFoundException -> 0x00bd }
            r15 = r9
            goto L_0x0076
        L_0x00ab:
            com.google.android.gms.measurement.internal.u4 r0 = r9.f40059a     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ NameNotFoundException -> 0x00bd }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ NameNotFoundException -> 0x00bd }
            java.lang.String r10 = "Could not get signatures"
            r0.a(r10)     // Catch:{ NameNotFoundException -> 0x00bd }
            goto L_0x0076
        L_0x00bb:
            r15 = r11
            goto L_0x0076
        L_0x00bd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r9 = r9.f40059a
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()
            com.google.android.gms.measurement.internal.o3 r9 = r9.r()
            java.lang.String r10 = "Package name not found"
            r9.b(r10, r0)
        L_0x00cd:
            r9 = r11
        L_0x00ce:
            r1.f39921h = r9
        L_0x00d0:
            r13 = r9
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a
            boolean r0 = r0.o()
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r9 = r9.F()
            boolean r9 = r9.f39752q
            r10 = 1
            r15 = r9 ^ 1
            r40.h()
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            boolean r9 = r9.o()
            r11 = 0
            if (r9 != 0) goto L_0x00f2
        L_0x00ee:
            r20 = r11
            goto L_0x0178
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzrj.zzc()
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            com.google.android.gms.measurement.internal.g r9 = r9.z()
            com.google.android.gms.measurement.internal.f3 r12 = com.google.android.gms.measurement.internal.g3.f39814e0
            boolean r9 = r9.B(r11, r12)
            if (r9 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()
            com.google.android.gms.measurement.internal.o3 r9 = r9.v()
            java.lang.String r12 = "Disabled IID for tests."
            r9.a(r12)
            goto L_0x00ee
        L_0x0113:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a     // Catch:{ ClassNotFoundException -> 0x0176 }
            android.content.Context r9 = r9.c()     // Catch:{ ClassNotFoundException -> 0x0176 }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0176 }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x0176 }
            if (r9 != 0) goto L_0x0126
            goto L_0x00ee
        L_0x0126:
            java.lang.String r12 = "getInstance"
            java.lang.Class[] r11 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x0167 }
            java.lang.Class<android.content.Context> r19 = android.content.Context.class
            r11[r2] = r19     // Catch:{ Exception -> 0x0167 }
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r12, r11)     // Catch:{ Exception -> 0x0167 }
            java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.measurement.internal.u4 r10 = r1.f40059a     // Catch:{ Exception -> 0x0167 }
            android.content.Context r10 = r10.c()     // Catch:{ Exception -> 0x0167 }
            r12[r2] = r10     // Catch:{ Exception -> 0x0167 }
            r10 = 0
            java.lang.Object r11 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x0167 }
            if (r11 != 0) goto L_0x0144
            goto L_0x0176
        L_0x0144:
            java.lang.String r10 = "getFirebaseInstanceId"
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r12)     // Catch:{ Exception -> 0x0157 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r9 = r9.invoke(r11, r10)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0157 }
            r20 = r9
            goto L_0x0178
        L_0x0157:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()
            com.google.android.gms.measurement.internal.o3 r9 = r9.x()
            java.lang.String r10 = "Failed to retrieve Firebase Instance Id"
            r9.a(r10)
            goto L_0x0176
        L_0x0167:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()
            com.google.android.gms.measurement.internal.o3 r9 = r9.y()
            java.lang.String r10 = "Failed to obtain Firebase Analytics instance"
            r9.a(r10)
        L_0x0176:
            r20 = 0
        L_0x0178:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r10 = r9.F()
            com.google.android.gms.measurement.internal.b4 r10 = r10.f39740e
            long r10 = r10.a()
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 != 0) goto L_0x0190
            long r9 = r9.G
            r12 = r3
            r22 = r9
            goto L_0x0199
        L_0x0190:
            r12 = r3
            long r2 = r9.G
            long r2 = java.lang.Math.min(r2, r10)
            r22 = r2
        L_0x0199:
            r40.i()
            int r11 = r1.f39925l
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.g r2 = r2.z()
            boolean r24 = r2.A()
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r2 = r2.F()
            r2.h()
            android.content.SharedPreferences r2 = r2.o()
            java.lang.String r3 = "deferred_analytics_collection"
            r9 = 0
            boolean r25 = r2.getBoolean(r3, r9)
            r40.i()
            java.lang.String r3 = r1.f39927n
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.g r2 = r2.z()
            java.lang.String r9 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.t(r9)
            if (r2 != 0) goto L_0x01d2
            r26 = 0
            goto L_0x01de
        L_0x01d2:
            boolean r2 = r2.booleanValue()
            r9 = 1
            r2 = r2 ^ r9
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r26 = r2
        L_0x01de:
            long r9 = r1.f39922i
            java.util.List r2 = r1.f39923j
            r19 = r2
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.e4 r2 = r2.F()
            we.o r2 = r2.q()
            java.lang.String r30 = r2.i()
            java.lang.String r2 = r1.f39924k
            if (r2 != 0) goto L_0x0202
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.t9 r2 = r2.N()
            java.lang.String r2 = r2.q()
            r1.f39924k = r2
        L_0x0202:
            java.lang.String r2 = r1.f39924k
            com.google.android.gms.internal.measurement.zzqu.zzc()
            r27 = r2
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.g r2 = r2.z()
            r28 = r3
            com.google.android.gms.measurement.internal.f3 r3 = com.google.android.gms.measurement.internal.g3.f39836p0
            r31 = r9
            r9 = 0
            boolean r2 = r2.B(r9, r3)
            if (r2 == 0) goto L_0x0253
            r40.h()
            long r2 = r1.f39929p
            r9 = 0
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x0228
            goto L_0x0247
        L_0x0228:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            me.f r2 = r2.a()
            long r2 = r2.currentTimeMillis()
            long r9 = r1.f39929p
            long r2 = r2 - r9
            java.lang.String r9 = r1.f39928o
            if (r9 == 0) goto L_0x0247
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0247
            java.lang.String r2 = r1.f39930q
            if (r2 != 0) goto L_0x0247
            r40.v()
        L_0x0247:
            java.lang.String r2 = r1.f39928o
            if (r2 != 0) goto L_0x024e
            r40.v()
        L_0x024e:
            java.lang.String r2 = r1.f39928o
            r33 = r2
            goto L_0x0255
        L_0x0253:
            r33 = 0
        L_0x0255:
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.g r2 = r2.z()
            com.google.android.gms.measurement.internal.u4 r3 = r2.f40059a
            java.lang.String r3 = "google_analytics_sgtm_upload_enabled"
            java.lang.Boolean r2 = r2.t(r3)
            if (r2 != 0) goto L_0x0268
            r34 = 0
            goto L_0x026e
        L_0x0268:
            boolean r2 = r2.booleanValue()
            r34 = r2
        L_0x026e:
            com.google.android.gms.internal.measurement.zzpz.zzc()
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.g r2 = r2.z()
            com.google.android.gms.measurement.internal.f3 r3 = com.google.android.gms.measurement.internal.g3.F0
            r9 = 0
            boolean r2 = r2.B(r9, r3)
            if (r2 == 0) goto L_0x02c9
            com.google.android.gms.measurement.internal.u4 r2 = r1.f40059a
            com.google.android.gms.measurement.internal.t9 r2 = r2.N()
            java.lang.String r3 = r40.s()
            com.google.android.gms.measurement.internal.u4 r9 = r2.f40059a
            android.content.Context r9 = r9.c()
            android.content.pm.PackageManager r9 = r9.getPackageManager()
            if (r9 != 0) goto L_0x0299
            r16 = 0
            goto L_0x02c6
        L_0x0299:
            com.google.android.gms.measurement.internal.u4 r9 = r2.f40059a     // Catch:{ NameNotFoundException -> 0x02ad }
            android.content.Context r9 = r9.c()     // Catch:{ NameNotFoundException -> 0x02ad }
            oe.c r9 = oe.d.a(r9)     // Catch:{ NameNotFoundException -> 0x02ad }
            r10 = 0
            android.content.pm.ApplicationInfo r9 = r9.c(r3, r10)     // Catch:{ NameNotFoundException -> 0x02ae }
            if (r9 == 0) goto L_0x02c2
            int r2 = r9.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x02ae }
            goto L_0x02c3
        L_0x02ad:
            r10 = 0
        L_0x02ae:
            com.google.android.gms.measurement.internal.u4 r9 = r2.f40059a
            r9.b()
            com.google.android.gms.measurement.internal.u4 r2 = r2.f40059a
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()
            com.google.android.gms.measurement.internal.o3 r2 = r2.u()
            java.lang.String r9 = "PackageManager failed to find running app: app_id"
            r2.b(r9, r3)
        L_0x02c2:
            r2 = r10
        L_0x02c3:
            long r2 = (long) r2
            r16 = r2
        L_0x02c6:
            r37 = r16
            goto L_0x02cb
        L_0x02c9:
            r37 = 0
        L_0x02cb:
            r9 = 79000(0x13498, double:3.9031E-319)
            r17 = 0
            r29 = 0
            r35 = r19
            r39 = r27
            r2 = r36
            r27 = r28
            r3 = r12
            r21 = r11
            r11 = r13
            r13 = r41
            r14 = r0
            r16 = r20
            r19 = r22
            r22 = r24
            r23 = r25
            r24 = r27
            r25 = r26
            r26 = r31
            r28 = r35
            r31 = r39
            r32 = r33
            r33 = r34
            r34 = r37
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.String) r31, (java.lang.String) r32, (boolean) r33, (long) r34)
            return r36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i3.q(java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    /* access modifiers changed from: package-private */
    public final String r() {
        i();
        return this.f39927n;
    }

    /* access modifiers changed from: package-private */
    public final String s() {
        i();
        p.k(this.f39916c);
        return this.f39916c;
    }

    /* access modifiers changed from: package-private */
    public final String t() {
        h();
        i();
        p.k(this.f39926m);
        return this.f39926m;
    }

    /* access modifiers changed from: package-private */
    public final List u() {
        return this.f39923j;
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        String str;
        String str2;
        h();
        if (!this.f40059a.F().q().j(zzha.ANALYTICS_STORAGE)) {
            this.f40059a.d().q().a("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            this.f40059a.N().u().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        o3 q10 = this.f40059a.d().q();
        Object[] objArr = new Object[1];
        if (str == null) {
            str2 = "null";
        } else {
            str2 = "not null";
        }
        objArr[0] = str2;
        q10.a(String.format("Resetting session stitching token to %s", objArr));
        this.f39928o = str;
        this.f39929p = this.f40059a.a().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean w(String str) {
        String str2 = this.f39930q;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.f39930q = str;
        return z10;
    }
}
