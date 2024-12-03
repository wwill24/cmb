package io.sentry.android.core;

import io.sentry.n0;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class y implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b0 f31111a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n0 f31112b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f31113c;

    public /* synthetic */ y(b0 b0Var, n0 n0Var, List list) {
        this.f31111a = b0Var;
        this.f31112b = n0Var;
        this.f31113c = list;
    }

    public final Object call() {
        return this.f31111a.n(this.f31112b, this.f31113c);
    }
}
