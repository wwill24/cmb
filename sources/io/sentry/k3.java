package io.sentry;

import io.sentry.n3;
import java.util.concurrent.Callable;

public final /* synthetic */ class k3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n3.a f31317a;

    public /* synthetic */ k3(n3.a aVar) {
        this.f31317a = aVar;
    }

    public final Object call() {
        return Integer.valueOf(this.f31317a.a().length);
    }
}
