package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f21117a;

    public /* synthetic */ g0(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f21117a = bindRequest;
    }

    public final void run() {
        this.f21117a.lambda$arrangeTimeout$0();
    }
}
