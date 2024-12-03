package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.p;

final class h3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f3 f38633a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i3 f38634b;

    h3(i3 i3Var, f3 f3Var) {
        this.f38634b = i3Var;
        this.f38633a = f3Var;
    }

    public final void run() {
        if (this.f38634b.f38639a) {
            ConnectionResult b10 = this.f38633a.b();
            if (b10.f0()) {
                i3 i3Var = this.f38634b;
                i3Var.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(i3Var.getActivity(), (PendingIntent) p.k(b10.c0()), this.f38633a.a(), false), 1);
                return;
            }
            i3 i3Var2 = this.f38634b;
            if (i3Var2.f38642d.d(i3Var2.getActivity(), b10.S(), (String) null) != null) {
                i3 i3Var3 = this.f38634b;
                i3Var3.f38642d.y(i3Var3.getActivity(), this.f38634b.mLifecycleFragment, b10.S(), 2, this.f38634b);
            } else if (b10.S() == 18) {
                i3 i3Var4 = this.f38634b;
                Dialog t10 = i3Var4.f38642d.t(i3Var4.getActivity(), this.f38634b);
                i3 i3Var5 = this.f38634b;
                i3Var5.f38642d.u(i3Var5.getActivity().getApplicationContext(), new g3(this, t10));
            } else {
                this.f38634b.a(b10, this.f38633a.a());
            }
        }
    }
}
