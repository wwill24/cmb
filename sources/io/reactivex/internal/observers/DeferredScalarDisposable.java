package io.reactivex.internal.observers;

import bk.a;
import qj.u;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;
    protected final u<? super T> downstream;
    protected T value;

    public DeferredScalarDisposable(u<? super T> uVar) {
        this.downstream = uVar;
    }

    public final int b(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean c() {
        return get() == 4;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void e(T t10) {
        int i10 = get();
        if ((i10 & 54) == 0) {
            u<? super T> uVar = this.downstream;
            if (i10 == 8) {
                this.value = t10;
                lazySet(16);
                uVar.d(null);
            } else {
                lazySet(2);
                uVar.d(t10);
            }
            if (get() != 4) {
                uVar.onComplete();
            }
        }
    }

    public final void f(Throwable th2) {
        if ((get() & 54) != 0) {
            a.s(th2);
            return;
        }
        lazySet(2);
        this.downstream.onError(th2);
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t10 = this.value;
        this.value = null;
        lazySet(32);
        return t10;
    }
}
