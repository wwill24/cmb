package com.facebook.internal;

import com.facebook.internal.FetchedAppGateKeepersManager;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FetchedAppGateKeepersManager.Callback f37851a;

    public /* synthetic */ f(FetchedAppGateKeepersManager.Callback callback) {
        this.f37851a = callback;
    }

    public final void run() {
        FetchedAppGateKeepersManager.m116pollCallbacks$lambda1(this.f37851a);
    }
}
