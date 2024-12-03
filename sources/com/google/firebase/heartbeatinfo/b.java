package com.google.firebase.heartbeatinfo;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f21080a;

    public /* synthetic */ b(DefaultHeartBeatController defaultHeartBeatController) {
        this.f21080a = defaultHeartBeatController;
    }

    public final Object call() {
        return this.f21080a.lambda$registerHeartBeat$0();
    }
}
