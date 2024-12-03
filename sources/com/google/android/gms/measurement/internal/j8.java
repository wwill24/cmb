package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import we.o;

public final class j8 extends b9 {

    /* renamed from: d  reason: collision with root package name */
    private final Map f39963d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final b4 f39964e;

    /* renamed from: f  reason: collision with root package name */
    public final b4 f39965f;

    /* renamed from: g  reason: collision with root package name */
    public final b4 f39966g;

    /* renamed from: h  reason: collision with root package name */
    public final b4 f39967h;

    /* renamed from: i  reason: collision with root package name */
    public final b4 f39968i;

    j8(n9 n9Var) {
        super(n9Var);
        e4 F = this.f40059a.F();
        F.getClass();
        this.f39964e = new b4(F, "last_delete_stale", 0);
        e4 F2 = this.f40059a.F();
        F2.getClass();
        this.f39965f = new b4(F2, "backoff", 0);
        e4 F3 = this.f40059a.F();
        F3.getClass();
        this.f39966g = new b4(F3, "last_upload", 0);
        e4 F4 = this.f40059a.F();
        F4.getClass();
        this.f39967h = new b4(F4, "last_upload_attempt", 0);
        e4 F5 = this.f40059a.F();
        F5.getClass();
        this.f39968i = new b4(F5, "midnight_offset", 0);
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final Pair m(String str) {
        i8 i8Var;
        h();
        long b10 = this.f40059a.a().b();
        i8 i8Var2 = (i8) this.f39963d.get(str);
        if (i8Var2 != null && b10 < i8Var2.f39945c) {
            return new Pair(i8Var2.f39943a, Boolean.valueOf(i8Var2.f39944b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long r10 = this.f40059a.z().r(str, g3.f39809c) + b10;
        try {
            long r11 = this.f40059a.z().r(str, g3.f39811d);
            AdvertisingIdClient.Info info = null;
            if (r11 > 0) {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(this.f40059a.c());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (i8Var2 != null) {
                        if (b10 < i8Var2.f39945c + r11) {
                            return new Pair(i8Var2.f39943a, Boolean.valueOf(i8Var2.f39944b));
                        }
                    }
                }
            } else {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.f40059a.c());
            }
            if (info == null) {
                return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
            }
            String id2 = info.getId();
            if (id2 != null) {
                i8Var = new i8(id2, info.isLimitAdTrackingEnabled(), r10);
            } else {
                i8Var = new i8("", info.isLimitAdTrackingEnabled(), r10);
            }
            this.f39963d.put(str, i8Var);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(i8Var.f39943a, Boolean.valueOf(i8Var.f39944b));
        } catch (Exception e10) {
            this.f40059a.d().q().b("Unable to get advertising id", e10);
            i8Var = new i8("", false, r10);
        }
    }

    /* access modifiers changed from: package-private */
    public final Pair n(String str, o oVar) {
        if (oVar.j(zzha.AD_STORAGE)) {
            return m(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String o(String str, boolean z10) {
        String str2;
        h();
        if (z10) {
            str2 = (String) m(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest t10 = t9.t();
        if (t10 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, t10.digest(str2.getBytes()))});
    }
}
