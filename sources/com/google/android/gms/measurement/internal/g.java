package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.p;
import java.lang.reflect.InvocationTargetException;
import me.q;
import oe.d;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class g extends n5 {

    /* renamed from: b  reason: collision with root package name */
    private Boolean f39799b;

    /* renamed from: c  reason: collision with root package name */
    private f f39800c = e.f39732a;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f39801d;

    g(u4 u4Var) {
        super(u4Var);
    }

    public static final long I() {
        return ((Long) g3.f39815f.a((Object) null)).longValue();
    }

    public static final long i() {
        return ((Long) g3.F.a((Object) null)).longValue();
    }

    private final String j(String str, String str2) {
        Class<String> cls = String.class;
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, ""});
            p.k(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            this.f40059a.d().r().b("Could not find SystemProperties class", e10);
            return "";
        } catch (NoSuchMethodException e11) {
            this.f40059a.d().r().b("Could not find SystemProperties.get() method", e11);
            return "";
        } catch (IllegalAccessException e12) {
            this.f40059a.d().r().b("Could not access SystemProperties.get()", e12);
            return "";
        } catch (InvocationTargetException e13) {
            this.f40059a.d().r().b("SystemProperties.get() threw an exception", e13);
            return "";
        }
    }

    public final boolean A() {
        Boolean t10 = t("google_analytics_adid_collection_enabled");
        if (t10 == null || t10.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean B(String str, f3 f3Var) {
        if (str == null) {
            return ((Boolean) f3Var.a((Object) null)).booleanValue();
        }
        String e10 = this.f39800c.e(str, f3Var.b());
        if (TextUtils.isEmpty(e10)) {
            return ((Boolean) f3Var.a((Object) null)).booleanValue();
        }
        return ((Boolean) f3Var.a(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(e10)))).booleanValue();
    }

    public final boolean C(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f39800c.e(str, "gaia_collection_enabled"));
    }

    public final boolean D() {
        Boolean t10 = t("google_analytics_automatic_screen_reporting_enabled");
        if (t10 == null || t10.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean E() {
        this.f40059a.b();
        Boolean t10 = t("firebase_analytics_collection_deactivated");
        if (t10 == null || !t10.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean F(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f39800c.e(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean G() {
        if (this.f39799b == null) {
            Boolean t10 = t("app_measurement_lite");
            this.f39799b = t10;
            if (t10 == null) {
                this.f39799b = Boolean.FALSE;
            }
        }
        if (this.f39799b.booleanValue() || !this.f40059a.s()) {
            return true;
        }
        return false;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean H() {
        if (this.f39801d == null) {
            synchronized (this) {
                if (this.f39801d == null) {
                    ApplicationInfo applicationInfo = this.f40059a.c().getApplicationInfo();
                    String a10 = q.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z10 = false;
                        if (str != null && str.equals(a10)) {
                            z10 = true;
                        }
                        this.f39801d = Boolean.valueOf(z10);
                    }
                    if (this.f39801d == null) {
                        this.f39801d = Boolean.TRUE;
                        this.f40059a.d().r().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f39801d.booleanValue();
    }

    public final double k(String str, f3 f3Var) {
        if (str == null) {
            return ((Double) f3Var.a((Object) null)).doubleValue();
        }
        String e10 = this.f39800c.e(str, f3Var.b());
        if (TextUtils.isEmpty(e10)) {
            return ((Double) f3Var.a((Object) null)).doubleValue();
        }
        try {
            return ((Double) f3Var.a(Double.valueOf(Double.parseDouble(e10)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) f3Var.a((Object) null)).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int l(String str) {
        return p(str, g3.J, 500, 2000);
    }

    public final int m() {
        if (this.f40059a.N().X(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int n(String str) {
        return p(str, g3.K, 25, 100);
    }

    public final int o(String str, f3 f3Var) {
        if (str == null) {
            return ((Integer) f3Var.a((Object) null)).intValue();
        }
        String e10 = this.f39800c.e(str, f3Var.b());
        if (TextUtils.isEmpty(e10)) {
            return ((Integer) f3Var.a((Object) null)).intValue();
        }
        try {
            return ((Integer) f3Var.a(Integer.valueOf(Integer.parseInt(e10)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) f3Var.a((Object) null)).intValue();
        }
    }

    public final int p(String str, f3 f3Var, int i10, int i11) {
        return Math.max(Math.min(o(str, f3Var), i11), i10);
    }

    public final long q() {
        this.f40059a.b();
        return 79000;
    }

    public final long r(String str, f3 f3Var) {
        if (str == null) {
            return ((Long) f3Var.a((Object) null)).longValue();
        }
        String e10 = this.f39800c.e(str, f3Var.b());
        if (TextUtils.isEmpty(e10)) {
            return ((Long) f3Var.a((Object) null)).longValue();
        }
        try {
            return ((Long) f3Var.a(Long.valueOf(Long.parseLong(e10)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) f3Var.a((Object) null)).longValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle s() {
        try {
            if (this.f40059a.c().getPackageManager() == null) {
                this.f40059a.d().r().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c10 = d.a(this.f40059a.c()).c(this.f40059a.c().getPackageName(), 128);
            if (c10 != null) {
                return c10.metaData;
            }
            this.f40059a.d().r().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            this.f40059a.d().r().b("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean t(String str) {
        p.g(str);
        Bundle s10 = s();
        if (s10 == null) {
            this.f40059a.d().r().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!s10.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(s10.getBoolean(str));
        }
    }

    public final String u() {
        return j("debug.firebase.analytics.app", "");
    }

    public final String v() {
        return j("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final String w() {
        this.f40059a.b();
        return "FA";
    }

    public final String x(String str, f3 f3Var) {
        if (str == null) {
            return (String) f3Var.a((Object) null);
        }
        return (String) f3Var.a(this.f39800c.e(str, f3Var.b()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A[SYNTHETIC, Splitter:B:8:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List y(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.p.g(r4)
            android.os.Bundle r0 = r3.s()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.u4 r4 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.u4 r0 = r3.f40059a     // Catch:{ NotFoundException -> 0x0048 }
            android.content.Context r0 = r0.c()     // Catch:{ NotFoundException -> 0x0048 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0048 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0048 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0048 }
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.u4 r0 = r3.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.g.y(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final void z(f fVar) {
        this.f39800c = fVar;
    }
}
