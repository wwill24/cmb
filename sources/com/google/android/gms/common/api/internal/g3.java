package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class g3 extends r1 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f38628a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h3 f38629b;

    g3(h3 h3Var, Dialog dialog) {
        this.f38629b = h3Var;
        this.f38628a = dialog;
    }

    public final void a() {
        this.f38629b.f38634b.d();
        if (this.f38628a.isShowing()) {
            this.f38628a.dismiss();
        }
    }
}
