package com.clevertap.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.pushnotification.j;
import java.util.concurrent.Callable;

class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f10104a;

    /* renamed from: b  reason: collision with root package name */
    private final l4.a f10105b;

    /* renamed from: c  reason: collision with root package name */
    private final i4.b f10106c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CleverTapInstanceConfig f10107d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f10108e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final j f10109f;

    /* renamed from: g  reason: collision with root package name */
    private final InAppController f10110g;

    /* renamed from: h  reason: collision with root package name */
    private final j f10111h;

    /* renamed from: i  reason: collision with root package name */
    private final r f10112i;

    /* renamed from: com.clevertap.android.sdk.a$a  reason: collision with other inner class name */
    class C0115a implements Callable<Void> {
        C0115a() {
        }

        /* renamed from: a */
        public Void call() throws Exception {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (!a.this.f10109f.v()) {
                return null;
            }
            try {
                s.n(a.this.f10108e, s.s(a.this.f10107d, "sexe"), currentTimeMillis);
                p n10 = a.this.f10107d.n();
                String e10 = a.this.f10107d.e();
                n10.t(e10, "Updated session time: " + currentTimeMillis);
                return null;
            } catch (Throwable th2) {
                p n11 = a.this.f10107d.n();
                String e11 = a.this.f10107d.e();
                n11.t(e11, "Failed to update session time time: " + th2.getMessage());
                return null;
            }
        }
    }

    class b implements Callable<Void> {
        b() {
        }

        /* renamed from: a */
        public Void call() {
            if (a.this.f10109f.D() || !a.this.f10109f.C()) {
                return null;
            }
            a.this.h();
            return null;
        }
    }

    class c implements InstallReferrerStateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InstallReferrerClient f10115a;

        c(InstallReferrerClient installReferrerClient) {
            this.f10115a = installReferrerClient;
        }

        public void onInstallReferrerServiceDisconnected() {
            if (!a.this.f10109f.D()) {
                a.this.h();
            }
        }

        public void onInstallReferrerSetupFinished(int i10) {
            if (i10 == 0) {
                try {
                    ReferrerDetails installReferrer = this.f10115a.getInstallReferrer();
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    a.this.f10109f.a0(installReferrer.getReferrerClickTimestampSeconds());
                    a.this.f10109f.J(installReferrer.getInstallBeginTimestampSeconds());
                    a.this.f10104a.E(installReferrer2);
                    a.this.f10109f.U(true);
                    p n10 = a.this.f10107d.n();
                    String e10 = a.this.f10107d.e();
                    n10.f(e10, "Install Referrer data set [Referrer URL-" + installReferrer2 + "]");
                } catch (RemoteException e11) {
                    p n11 = a.this.f10107d.n();
                    String e12 = a.this.f10107d.e();
                    n11.f(e12, "Remote exception caused by Google Play Install Referrer library - " + e11.getMessage());
                    this.f10115a.endConnection();
                    a.this.f10109f.U(false);
                } catch (NullPointerException e13) {
                    p n12 = a.this.f10107d.n();
                    String e14 = a.this.f10107d.e();
                    n12.f(e14, "Install referrer client null pointer exception caused by Google Play Install Referrer library - " + e13.getMessage());
                    this.f10115a.endConnection();
                    a.this.f10109f.U(false);
                }
            } else if (i10 == 1) {
                a.this.f10107d.n().f(a.this.f10107d.e(), "Install Referrer data not set, connection to Play Store unavailable");
            } else if (i10 == 2) {
                a.this.f10107d.n().f(a.this.f10107d.e(), "Install Referrer data not set, API not supported by Play Store on device");
            }
        }
    }

    a(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, c cVar, j jVar, r rVar, j jVar2, i4.b bVar, InAppController inAppController, l4.a aVar) {
        this.f10108e = context;
        this.f10107d = cleverTapInstanceConfig;
        this.f10104a = cVar;
        this.f10109f = jVar;
        this.f10112i = rVar;
        this.f10111h = jVar2;
        this.f10106c = bVar;
        this.f10110g = inAppController;
        this.f10105b = aVar;
    }

    /* access modifiers changed from: private */
    public void h() {
        this.f10107d.n().t(this.f10107d.e(), "Starting to handle install referrer");
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(this.f10108e).build();
            build.startConnection(new c(build));
        } catch (Throwable th2) {
            p n10 = this.f10107d.n();
            String e10 = this.f10107d.e();
            n10.t(e10, "Google Play Install Referrer's InstallReferrerClient Class not found - " + th2.getLocalizedMessage() + " \n Please add implementation 'com.android.installreferrer:installreferrer:2.1' to your build.gradle");
        }
    }

    public void f() {
        j.I(false);
        this.f10112i.e(System.currentTimeMillis());
        this.f10107d.n().t(this.f10107d.e(), "App in background");
        com.clevertap.android.sdk.task.a.a(this.f10107d).c().f("activityPaused", new C0115a());
    }

    public void g(Activity activity) {
        this.f10107d.n().t(this.f10107d.e(), "App in foreground");
        this.f10112i.a();
        if (!this.f10109f.y()) {
            this.f10104a.y();
            this.f10104a.a();
            this.f10111h.K();
            com.clevertap.android.sdk.task.a.a(this.f10107d).c().f("HandlingInstallReferrer", new b());
            try {
                if (this.f10106c.e() != null) {
                    this.f10106c.e().a();
                }
            } catch (IllegalStateException e10) {
                this.f10107d.n().t(this.f10107d.e(), e10.getLocalizedMessage());
            } catch (Exception unused) {
                this.f10107d.n().t(this.f10107d.e(), "Failed to trigger location");
            }
        }
        this.f10105b.d();
        this.f10110g.k(activity);
        this.f10110g.l(activity);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        if (r2.f10107d.t() == false) goto L_0x000b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c A[ADDED_TO_REGION, Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(android.os.Bundle r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r2 = this;
            r0 = 0
            if (r5 != 0) goto L_0x000b
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.f10107d     // Catch:{ all -> 0x0039 }
            boolean r1 = r1.t()     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x0017
        L_0x000b:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r2.f10107d     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = r1.e()     // Catch:{ all -> 0x0039 }
            boolean r5 = r1.equals(r5)     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x0019
        L_0x0017:
            r5 = 1
            goto L_0x001a
        L_0x0019:
            r5 = r0
        L_0x001a:
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x0031
            boolean r5 = r3.isEmpty()     // Catch:{ all -> 0x0039 }
            if (r5 != 0) goto L_0x0031
            java.lang.String r5 = "wzrk_pn"
            boolean r5 = r3.containsKey(r5)     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x0031
            com.clevertap.android.sdk.c r5 = r2.f10104a     // Catch:{ all -> 0x0039 }
            r5.G(r3)     // Catch:{ all -> 0x0039 }
        L_0x0031:
            if (r4 == 0) goto L_0x0052
            com.clevertap.android.sdk.c r3 = r2.f10104a     // Catch:{ all -> 0x0052 }
            r3.A(r4, r0)     // Catch:{ all -> 0x0052 }
            goto L_0x0052
        L_0x0039:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Throwable - "
            r4.append(r5)
            java.lang.String r3 = r3.getLocalizedMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.clevertap.android.sdk.p.o(r3)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.a.i(android.os.Bundle, android.net.Uri, java.lang.String):void");
    }
}
