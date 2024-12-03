package com.leanplum;

import com.leanplum.callbacks.ForceContentUpdateCallback;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ForceContentUpdateCallback f22187a;

    public /* synthetic */ c(ForceContentUpdateCallback forceContentUpdateCallback) {
        this.f22187a = forceContentUpdateCallback;
    }

    public final void run() {
        this.f22187a.onContentUpdated(false);
    }
}
