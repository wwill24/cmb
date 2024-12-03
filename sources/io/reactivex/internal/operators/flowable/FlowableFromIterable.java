package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import qj.h;
import xj.b;
import yj.a;

public final class FlowableFromIterable<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends T> f30180b;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        BaseRangeSubscription(Iterator<? extends T> it2) {
            this.it = it2;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        public final int b(int i10) {
            return i10 & 1;
        }

        /* access modifiers changed from: package-private */
        public abstract void c(long j10);

        public final void cancel() {
            this.cancelled = true;
        }

        public final void clear() {
            this.it = null;
        }

        public final boolean isEmpty() {
            Iterator<? extends T> it2 = this.it;
            return it2 == null || !it2.hasNext();
        }

        public final T poll() {
            Iterator<? extends T> it2 = this.it;
            if (it2 == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it2.hasNext()) {
                return null;
            }
            return b.e(this.it.next(), "Iterator.next() returned a null value");
        }

        public final void r(long j10) {
            if (SubscriptionHelper.j(j10) && io.reactivex.internal.util.b.a(this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    a();
                } else {
                    c(j10);
                }
            }
        }
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final a<? super T> downstream;

        IteratorConditionalSubscription(a<? super T> aVar, Iterator<? extends T> it) {
            super(it);
            this.downstream = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Iterator<? extends T> it = this.it;
            a<? super T> aVar = this.downstream;
            while (!this.cancelled) {
                try {
                    Object next = it.next();
                    if (!this.cancelled) {
                        if (next == null) {
                            aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        aVar.f(next);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        aVar.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                uj.a.b(th2);
                                aVar.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    aVar.onError(th3);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j10) {
            Iterator<? extends T> it = this.it;
            a<? super T> aVar = this.downstream;
            do {
                long j11 = 0;
                while (true) {
                    if (j11 == j10) {
                        j10 = get();
                        if (j11 == j10) {
                            j10 = addAndGet(-j11);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object next = it.next();
                            if (!this.cancelled) {
                                if (next == null) {
                                    aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean f10 = aVar.f(next);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.cancelled) {
                                                aVar.onComplete();
                                                return;
                                            }
                                            return;
                                        } else if (f10) {
                                            j11++;
                                        }
                                    } catch (Throwable th2) {
                                        uj.a.b(th2);
                                        aVar.onError(th2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th3) {
                            uj.a.b(th3);
                            aVar.onError(th3);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final rn.b<? super T> downstream;

        IteratorSubscription(rn.b<? super T> bVar, Iterator<? extends T> it) {
            super(it);
            this.downstream = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Iterator<? extends T> it = this.it;
            rn.b<? super T> bVar = this.downstream;
            while (!this.cancelled) {
                try {
                    Object next = it.next();
                    if (!this.cancelled) {
                        if (next == null) {
                            bVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        bVar.d(next);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        bVar.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                uj.a.b(th2);
                                bVar.onError(th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    uj.a.b(th3);
                    bVar.onError(th3);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j10) {
            Iterator<? extends T> it = this.it;
            rn.b<? super T> bVar = this.downstream;
            do {
                long j11 = 0;
                while (true) {
                    if (j11 == j10) {
                        j10 = get();
                        if (j11 == j10) {
                            j10 = addAndGet(-j11);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object next = it.next();
                            if (!this.cancelled) {
                                if (next == null) {
                                    bVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                bVar.d(next);
                                if (!this.cancelled) {
                                    try {
                                        if (it.hasNext()) {
                                            j11++;
                                        } else if (!this.cancelled) {
                                            bVar.onComplete();
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        uj.a.b(th2);
                                        bVar.onError(th2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th3) {
                            uj.a.b(th3);
                            bVar.onError(th3);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f30180b = iterable;
    }

    public static <T> void A0(rn.b<? super T> bVar, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.a(bVar);
            } else if (bVar instanceof a) {
                bVar.e(new IteratorConditionalSubscription((a) bVar, it));
            } else {
                bVar.e(new IteratorSubscription(bVar, it));
            }
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptySubscription.c(th2, bVar);
        }
    }

    public void n0(rn.b<? super T> bVar) {
        try {
            A0(bVar, this.f30180b.iterator());
        } catch (Throwable th2) {
            uj.a.b(th2);
            EmptySubscription.c(th2, bVar);
        }
    }
}
