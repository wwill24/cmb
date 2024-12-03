package com.google.android.gms.measurement.internal;

public final /* synthetic */ class v5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u6 f40358a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40359b;

    public /* synthetic */ v5(u6 u6Var, String str) {
        this.f40358a = u6Var;
        this.f40359b = str;
    }

    public final void run() {
        u6 u6Var = this.f40358a;
        if (u6Var.f40059a.B().w(this.f40359b)) {
            u6Var.f40059a.B().v();
        }
    }
}
