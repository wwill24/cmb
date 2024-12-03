package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import tj.b;

public final class SequentialDisposable extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public boolean a(b bVar) {
        return DisposableHelper.d(this, bVar);
    }

    public boolean b(b bVar) {
        return DisposableHelper.h(this, bVar);
    }

    public boolean c() {
        return DisposableHelper.b((b) get());
    }

    public void dispose() {
        DisposableHelper.a(this);
    }

    public SequentialDisposable(b bVar) {
        lazySet(bVar);
    }
}
