package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigCacheClient f21200a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConfigContainer f21201b;

    public /* synthetic */ c(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        this.f21200a = configCacheClient;
        this.f21201b = configContainer;
    }

    public final Object call() {
        return this.f21200a.lambda$put$0(this.f21201b);
    }
}
