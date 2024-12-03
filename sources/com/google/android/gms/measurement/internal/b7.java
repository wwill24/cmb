package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class b7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z6 f39680a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z6 f39681b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f39682c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f39683d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ g7 f39684e;

    b7(g7 g7Var, z6 z6Var, z6 z6Var2, long j10, boolean z10) {
        this.f39684e = g7Var;
        this.f39680a = z6Var;
        this.f39681b = z6Var2;
        this.f39682c = j10;
        this.f39683d = z10;
    }

    public final void run() {
        this.f39684e.o(this.f39680a, this.f39681b, this.f39682c, this.f39683d, (Bundle) null);
    }
}
