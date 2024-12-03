package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.p;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;

final class d6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f39721a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u6 f39722b;

    d6(u6 u6Var, Bundle bundle) {
        this.f39722b = u6Var;
        this.f39721a = bundle;
    }

    public final void run() {
        u6 u6Var = this.f39722b;
        Bundle bundle = this.f39721a;
        u6Var.h();
        u6Var.i();
        p.k(bundle);
        String g10 = p.g(bundle.getString("name"));
        if (!u6Var.f40059a.o()) {
            u6Var.f40059a.d().v().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzlk zzlk = new zzlk(g10, 0, (Object) null, "");
        try {
            zzac zzac = r4;
            zzac zzac2 = new zzac(bundle.getString("app_id"), "", zzlk, bundle.getLong("creation_timestamp"), bundle.getBoolean(ClientStateIndication.Active.ELEMENT), bundle.getString("trigger_event_name"), (zzau) null, bundle.getLong("trigger_timeout"), (zzau) null, bundle.getLong("time_to_live"), u6Var.f40059a.N().y0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true));
            u6Var.f40059a.L().s(zzac);
        } catch (IllegalArgumentException unused) {
        }
    }
}
