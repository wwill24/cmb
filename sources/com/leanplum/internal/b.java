package com.leanplum.internal;

import com.leanplum.internal.Request;

public final /* synthetic */ class b implements Request.ResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f22206a;

    public /* synthetic */ b(Runnable runnable) {
        this.f22206a = runnable;
    }

    public final void response(org.json.b bVar) {
        FileTransferManager.lambda$downloadFile$0(this.f22206a, bVar);
    }
}
