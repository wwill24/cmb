package com.leanplum;

import com.leanplum.callbacks.ForceContentUpdateCallback;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ForceContentUpdateCallback f22218a;

    public /* synthetic */ n(ForceContentUpdateCallback forceContentUpdateCallback) {
        this.f22218a = forceContentUpdateCallback;
    }

    public final void run() {
        this.f22218a.onContentUpdated(true);
    }
}
