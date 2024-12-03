package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

public final /* synthetic */ class t5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u6 f40278a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f40279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f40280c;

    public /* synthetic */ t5(u6 u6Var, Bundle bundle, long j10) {
        this.f40278a = u6Var;
        this.f40279b = bundle;
        this.f40280c = j10;
    }

    public final void run() {
        u6 u6Var = this.f40278a;
        Bundle bundle = this.f40279b;
        long j10 = this.f40280c;
        if (TextUtils.isEmpty(u6Var.f40059a.B().t())) {
            u6Var.G(bundle, 0, j10);
        } else {
            u6Var.f40059a.d().x().a("Using developer consent only; google app id found");
        }
    }
}
