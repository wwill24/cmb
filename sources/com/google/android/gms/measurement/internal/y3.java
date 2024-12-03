package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.p;

final class y3 extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    static final String f40423d = y3.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final n9 f40424a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f40425b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40426c;

    y3(n9 n9Var) {
        p.k(n9Var);
        this.f40424a = n9Var;
    }

    public final void b() {
        this.f40424a.g();
        this.f40424a.f().h();
        if (!this.f40425b) {
            this.f40424a.c().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f40426c = this.f40424a.X().m();
            this.f40424a.d().v().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f40426c));
            this.f40425b = true;
        }
    }

    public final void c() {
        this.f40424a.g();
        this.f40424a.f().h();
        this.f40424a.f().h();
        if (this.f40425b) {
            this.f40424a.d().v().a("Unregistering connectivity change receiver");
            this.f40425b = false;
            this.f40426c = false;
            try {
                this.f40424a.c().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f40424a.d().r().b("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        this.f40424a.g();
        String action = intent.getAction();
        this.f40424a.d().v().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean m10 = this.f40424a.X().m();
            if (this.f40426c != m10) {
                this.f40426c = m10;
                this.f40424a.f().z(new x3(this, m10));
                return;
            }
            return;
        }
        this.f40424a.d().w().b("NetworkBroadcastReceiver received unknown action", action);
    }
}
