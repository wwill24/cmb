package com.facebook.bolts;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f37778a;

    public /* synthetic */ a(CancellationTokenSource cancellationTokenSource) {
        this.f37778a = cancellationTokenSource;
    }

    public final void run() {
        CancellationTokenSource.m87cancelAfter$lambda6$lambda5(this.f37778a);
    }
}
