package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class s1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Context f38738a;

    /* renamed from: b  reason: collision with root package name */
    private final r1 f38739b;

    public s1(r1 r1Var) {
        this.f38739b = r1Var;
    }

    public final void a(Context context) {
        this.f38738a = context;
    }

    public final synchronized void b() {
        Context context = this.f38738a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f38738a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        } else {
            str = null;
        }
        if ("com.google.android.gms".equals(str)) {
            this.f38739b.a();
            b();
        }
    }
}
