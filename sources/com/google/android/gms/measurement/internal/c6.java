package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.p;
import com.google.firebase.analytics.FirebaseAnalytics;

final class c6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f39703a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f39704b;

    c6(u6 u6Var, Bundle bundle) {
        this.f39704b = u6Var;
        this.f39703a = bundle;
    }

    public final void run() {
        u6 u6Var = this.f39704b;
        Bundle bundle = this.f39703a;
        u6Var.h();
        u6Var.i();
        p.k(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString(FirebaseAnalytics.Param.ORIGIN);
        p.g(string);
        p.g(string2);
        p.k(bundle.get("value"));
        if (!u6Var.f40059a.o()) {
            u6Var.f40059a.d().v().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzlk zzlk = new zzlk(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzau y02 = u6Var.f40059a.N().y0(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0, true, true);
            zzau y03 = u6Var.f40059a.N().y0(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0, true, true);
            zzau y04 = u6Var.f40059a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0, true, true);
            u6Var.f40059a.L().s(new zzac(bundle.getString("app_id"), string2, zzlk, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), y03, bundle.getLong("trigger_timeout"), y02, bundle.getLong("time_to_live"), y04));
        } catch (IllegalArgumentException unused) {
        }
    }
}
