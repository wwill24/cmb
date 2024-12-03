package com.leanplum.internal;

import com.leanplum.internal.Request;

public final /* synthetic */ class c implements Request.ErrorCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f22207a;

    public /* synthetic */ c(Runnable runnable) {
        this.f22207a = runnable;
    }

    public final void error(Exception exc) {
        FileTransferManager.lambda$downloadFile$1(this.f22207a, exc);
    }
}
