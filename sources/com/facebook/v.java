package com.facebook;

import com.facebook.GraphRequest;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GraphRequest.Callback f37947a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f37948b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f37949c;

    public /* synthetic */ v(GraphRequest.Callback callback, long j10, long j11) {
        this.f37947a = callback;
        this.f37948b = j10;
        this.f37949c = j11;
    }

    public final void run() {
        RequestProgress.m32reportProgress$lambda0(this.f37947a, this.f37948b, this.f37949c);
    }
}
