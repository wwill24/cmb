package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
import tj.b;

public final class a {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b() {
        return d(xj.a.f33965b);
    }

    public static b c(vj.a aVar) {
        xj.b.e(aVar, "run is null");
        return new ActionDisposable(aVar);
    }

    public static b d(Runnable runnable) {
        xj.b.e(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
