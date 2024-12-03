package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class z5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f40454a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40455b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f40456c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f40457d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f40458e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ boolean f40459f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f40460g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ String f40461h;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ u6 f40462j;

    z5(u6 u6Var, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f40462j = u6Var;
        this.f40454a = str;
        this.f40455b = str2;
        this.f40456c = j10;
        this.f40457d = bundle;
        this.f40458e = z10;
        this.f40459f = z11;
        this.f40460g = z12;
        this.f40461h = str3;
    }

    public final void run() {
        this.f40462j.w(this.f40454a, this.f40455b, this.f40456c, this.f40457d, this.f40458e, this.f40459f, this.f40460g, this.f40461h);
    }
}
