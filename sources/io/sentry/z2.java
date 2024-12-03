package io.sentry;

import io.sentry.n3;
import java.util.concurrent.Callable;

public final /* synthetic */ class z2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n3.a f31840a;

    public /* synthetic */ z2(n3.a aVar) {
        this.f31840a = aVar;
    }

    public final Object call() {
        return Integer.valueOf(this.f31840a.a().length);
    }
}
