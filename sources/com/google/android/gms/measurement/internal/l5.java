package com.google.android.gms.measurement.internal;

final class l5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f40007a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f40008b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f40009c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f40010d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ m5 f40011e;

    l5(m5 m5Var, String str, String str2, String str3, long j10) {
        this.f40011e = m5Var;
        this.f40007a = str;
        this.f40008b = str2;
        this.f40009c = str3;
        this.f40010d = j10;
    }

    public final void run() {
        String str = this.f40007a;
        if (str == null) {
            this.f40011e.f40032a.w(this.f40008b, (z6) null);
            return;
        }
        this.f40011e.f40032a.w(this.f40008b, new z6(this.f40009c, str, this.f40010d));
    }
}
