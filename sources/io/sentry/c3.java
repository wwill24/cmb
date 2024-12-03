package io.sentry;

import io.sentry.n3;
import java.util.concurrent.Callable;

public final /* synthetic */ class c3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n3.a f31158a;

    public /* synthetic */ c3(n3.a aVar) {
        this.f31158a = aVar;
    }

    public final Object call() {
        return Integer.valueOf(this.f31158a.a().length);
    }
}
