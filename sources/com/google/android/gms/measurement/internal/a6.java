package com.google.android.gms.measurement.internal;

final class a6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f39639a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39640b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f39641c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f39642d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ u6 f39643e;

    a6(u6 u6Var, String str, String str2, Object obj, long j10) {
        this.f39643e = u6Var;
        this.f39639a = str;
        this.f39640b = str2;
        this.f39641c = obj;
        this.f39642d = j10;
    }

    public final void run() {
        this.f39643e.M(this.f39639a, this.f39640b, this.f39641c, this.f39642d);
    }
}
