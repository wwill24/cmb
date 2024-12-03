package com.google.android.gms.measurement.internal;

import android.content.Intent;

public final /* synthetic */ class l8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n8 f40017a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40018b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q3 f40019c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Intent f40020d;

    public /* synthetic */ l8(n8 n8Var, int i10, q3 q3Var, Intent intent) {
        this.f40017a = n8Var;
        this.f40018b = i10;
        this.f40019c = q3Var;
        this.f40020d = intent;
    }

    public final void run() {
        this.f40017a.c(this.f40018b, this.f40019c, this.f40020d);
    }
}
