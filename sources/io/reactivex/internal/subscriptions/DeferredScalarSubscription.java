package io.reactivex.internal.subscriptions;

import rn.b;

public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    private static final long serialVersionUID = -2151279923272604993L;
    protected final b<? super T> downstream;
    protected T value;

    public DeferredScalarSubscription(b<? super T> bVar) {
        this.downstream = bVar;
    }

    public final int b(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void c(T t10) {
        int i10 = get();
        while (i10 != 8) {
            if ((i10 & -3) == 0) {
                if (i10 == 2) {
                    lazySet(3);
                    b<? super T> bVar = this.downstream;
                    bVar.d(t10);
                    if (get() != 4) {
                        bVar.onComplete();
                        return;
                    }
                    return;
                }
                this.value = t10;
                if (!compareAndSet(0, 1)) {
                    i10 = get();
                    if (i10 == 4) {
                        this.value = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.value = t10;
        lazySet(16);
        b<? super T> bVar2 = this.downstream;
        bVar2.d(t10);
        if (get() != 4) {
            bVar2.onComplete();
        }
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t10 = this.value;
        this.value = null;
        return t10;
    }

    public final void r(long j10) {
        T t10;
        if (SubscriptionHelper.j(j10)) {
            do {
                int i10 = get();
                if ((i10 & -2) == 0) {
                    if (i10 == 1) {
                        if (compareAndSet(1, 3) && (t10 = this.value) != null) {
                            this.value = null;
                            b<? super T> bVar = this.downstream;
                            bVar.d(t10);
                            if (get() != 4) {
                                bVar.onComplete();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
