package com.google.mlkit.common.sdkinternal;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class u implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ThreadFactory f21460a;

    public /* synthetic */ u(ThreadFactory threadFactory) {
        this.f21460a = threadFactory;
    }

    public final Thread newThread(Runnable runnable) {
        return this.f21460a.newThread(new t(runnable));
    }
}
