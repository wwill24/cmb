package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigStorageClient f21199a;

    public /* synthetic */ b(ConfigStorageClient configStorageClient) {
        this.f21199a = configStorageClient;
    }

    public final Object call() {
        return this.f21199a.read();
    }
}
