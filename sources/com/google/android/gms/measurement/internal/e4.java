package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzov;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import we.g;
import we.o;

final class e4 extends o5 {

    /* renamed from: y  reason: collision with root package name */
    static final Pair f39737y = new Pair("", 0L);

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f39738c;

    /* renamed from: d  reason: collision with root package name */
    public c4 f39739d;

    /* renamed from: e  reason: collision with root package name */
    public final b4 f39740e = new b4(this, "first_open_time", 0);

    /* renamed from: f  reason: collision with root package name */
    public final b4 f39741f = new b4(this, "app_install_time", 0);

    /* renamed from: g  reason: collision with root package name */
    public final d4 f39742g = new d4(this, "app_instance_id", (String) null);

    /* renamed from: h  reason: collision with root package name */
    private String f39743h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f39744i;

    /* renamed from: j  reason: collision with root package name */
    private long f39745j;

    /* renamed from: k  reason: collision with root package name */
    public final b4 f39746k = new b4(this, "session_timeout", 1800000);

    /* renamed from: l  reason: collision with root package name */
    public final z3 f39747l = new z3(this, "start_new_session", true);

    /* renamed from: m  reason: collision with root package name */
    public final d4 f39748m = new d4(this, "non_personalized_ads", (String) null);

    /* renamed from: n  reason: collision with root package name */
    public final z3 f39749n = new z3(this, "allow_remote_dynamite", false);

    /* renamed from: o  reason: collision with root package name */
    public final b4 f39750o = new b4(this, "last_pause_time", 0);

    /* renamed from: p  reason: collision with root package name */
    public final b4 f39751p = new b4(this, SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0);

    /* renamed from: q  reason: collision with root package name */
    public boolean f39752q;

    /* renamed from: r  reason: collision with root package name */
    public final z3 f39753r = new z3(this, "app_backgrounded", false);

    /* renamed from: s  reason: collision with root package name */
    public final z3 f39754s = new z3(this, "deep_link_retrieval_complete", false);

    /* renamed from: t  reason: collision with root package name */
    public final b4 f39755t = new b4(this, "deep_link_retrieval_attempts", 0);

    /* renamed from: u  reason: collision with root package name */
    public final d4 f39756u = new d4(this, "firebase_feature_rollouts", (String) null);

    /* renamed from: v  reason: collision with root package name */
    public final d4 f39757v = new d4(this, "deferred_attribution_cache", (String) null);

    /* renamed from: w  reason: collision with root package name */
    public final b4 f39758w = new b4(this, "deferred_attribution_cache_timestamp", 0);

    /* renamed from: x  reason: collision with root package name */
    public final a4 f39759x = new a4(this, "default_event_parameters", (Bundle) null);

    e4(u4 u4Var) {
        super(u4Var);
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void i() {
        SharedPreferences sharedPreferences = this.f40059a.c().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f39738c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f39752q = z10;
        if (!z10) {
            SharedPreferences.Editor edit = this.f39738c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f40059a.z();
        this.f39739d = new c4(this, "health_monitor", Math.max(0, ((Long) g3.f39813e.a((Object) null)).longValue()), (g) null);
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences o() {
        h();
        k();
        p.k(this.f39738c);
        return this.f39738c;
    }

    /* access modifiers changed from: package-private */
    public final Pair p(String str) {
        h();
        zzov.zzc();
        if (this.f40059a.z().B((String) null, g3.K0) && !q().j(zzha.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long b10 = this.f40059a.a().b();
        String str2 = this.f39743h;
        if (str2 != null && b10 < this.f39745j) {
            return new Pair(str2, Boolean.valueOf(this.f39744i));
        }
        this.f39745j = b10 + this.f40059a.z().r(str, g3.f39809c);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f40059a.c());
            this.f39743h = "";
            String id2 = advertisingIdInfo.getId();
            if (id2 != null) {
                this.f39743h = id2;
            }
            this.f39744i = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e10) {
            this.f40059a.d().q().b("Unable to get advertising id", e10);
            this.f39743h = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f39743h, Boolean.valueOf(this.f39744i));
    }

    /* access modifiers changed from: package-private */
    public final o q() {
        h();
        return o.c(o().getString("consent_settings", "G1"), o().getInt("consent_source", 100));
    }

    /* access modifiers changed from: package-private */
    public final Boolean r() {
        h();
        if (o().contains("measurement_enabled")) {
            return Boolean.valueOf(o().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void s(Boolean bool) {
        h();
        SharedPreferences.Editor edit = o().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void t(boolean z10) {
        h();
        this.f40059a.d().v().b("App measurement setting deferred collection", Boolean.valueOf(z10));
        SharedPreferences.Editor edit = o().edit();
        edit.putBoolean("deferred_analytics_collection", z10);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean u() {
        SharedPreferences sharedPreferences = this.f39738c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean v(long j10) {
        if (j10 - this.f39746k.a() > this.f39750o.a()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean w(int i10) {
        return o.k(i10, o().getInt("consent_source", 100));
    }
}
