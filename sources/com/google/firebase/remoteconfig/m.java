package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RemoteConfigComponent f21230a;

    public /* synthetic */ m(RemoteConfigComponent remoteConfigComponent) {
        this.f21230a = remoteConfigComponent;
    }

    public final Object call() {
        return this.f21230a.getDefault();
    }
}
