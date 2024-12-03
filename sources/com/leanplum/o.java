package com.leanplum;

import com.leanplum.callbacks.ForceContentUpdateCallback;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ForceContentUpdateCallback f22219a;

    public /* synthetic */ o(ForceContentUpdateCallback forceContentUpdateCallback) {
        this.f22219a = forceContentUpdateCallback;
    }

    public final void run() {
        this.f22219a.onContentUpdated(false);
    }
}
