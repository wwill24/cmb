package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class l2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o2 f38672a;

    l2(o2 o2Var) {
        this.f38672a = o2Var;
    }

    public final void run() {
        this.f38672a.f38712g.c(new ConnectionResult(4));
    }
}
