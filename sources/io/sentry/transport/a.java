package io.sentry.transport;

import io.sentry.cache.e;
import io.sentry.h0;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class a implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f31640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h0 f31641b;

    public /* synthetic */ a(e eVar, h0 h0Var) {
        this.f31640a = eVar;
        this.f31641b = h0Var;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        d.k(this.f31640a, this.f31641b, runnable, threadPoolExecutor);
    }
}
