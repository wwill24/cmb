package com.google.android.gms.common.api.internal;

import android.os.IBinder;

public final /* synthetic */ class b2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f38552a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IBinder f38553b;

    public /* synthetic */ b2(m mVar, IBinder iBinder) {
        this.f38552a = mVar;
        this.f38553b = iBinder;
    }

    public final void run() {
        this.f38552a.e(this.f38553b);
    }
}
