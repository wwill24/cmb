package io.reactivex.processors;

import io.reactivex.internal.queue.a;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rn.b;
import rn.c;

public final class UnicastProcessor<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    final a<T> f30725b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Runnable> f30726c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f30727d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f30728e;

    /* renamed from: f  reason: collision with root package name */
    Throwable f30729f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<b<? super T>> f30730g;

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f30731h;

    /* renamed from: j  reason: collision with root package name */
    final AtomicBoolean f30732j;

    /* renamed from: k  reason: collision with root package name */
    final BasicIntQueueSubscription<T> f30733k;

    /* renamed from: l  reason: collision with root package name */
    final AtomicLong f30734l;

    /* renamed from: m  reason: collision with root package name */
    boolean f30735m;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        public int b(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f30735m = true;
            return 2;
        }

        public void cancel() {
            if (!UnicastProcessor.this.f30731h) {
                UnicastProcessor.this.f30731h = true;
                UnicastProcessor.this.D0();
                UnicastProcessor.this.f30730g.lazySet((Object) null);
                if (UnicastProcessor.this.f30733k.getAndIncrement() == 0) {
                    UnicastProcessor.this.f30730g.lazySet((Object) null);
                    UnicastProcessor unicastProcessor = UnicastProcessor.this;
                    if (!unicastProcessor.f30735m) {
                        unicastProcessor.f30725b.clear();
                    }
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.f30725b.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f30725b.isEmpty();
        }

        public T poll() {
            return UnicastProcessor.this.f30725b.poll();
        }

        public void r(long j10) {
            if (SubscriptionHelper.j(j10)) {
                io.reactivex.internal.util.b.a(UnicastProcessor.this.f30734l, j10);
                UnicastProcessor.this.E0();
            }
        }
    }

    UnicastProcessor(int i10) {
        this(i10, (Runnable) null, true);
    }

    public static <T> UnicastProcessor<T> C0(int i10) {
        return new UnicastProcessor<>(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean B0(boolean z10, boolean z11, boolean z12, b<? super T> bVar, a<T> aVar) {
        if (this.f30731h) {
            aVar.clear();
            this.f30730g.lazySet((Object) null);
            return true;
        } else if (!z11) {
            return false;
        } else {
            if (z10 && this.f30729f != null) {
                aVar.clear();
                this.f30730g.lazySet((Object) null);
                bVar.onError(this.f30729f);
                return true;
            } else if (!z12) {
                return false;
            } else {
                Throwable th2 = this.f30729f;
                this.f30730g.lazySet((Object) null);
                if (th2 != null) {
                    bVar.onError(th2);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void D0() {
        Runnable andSet = this.f30726c.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void E0() {
        if (this.f30733k.getAndIncrement() == 0) {
            int i10 = 1;
            b bVar = this.f30730g.get();
            while (bVar == null) {
                i10 = this.f30733k.addAndGet(-i10);
                if (i10 != 0) {
                    bVar = this.f30730g.get();
                } else {
                    return;
                }
            }
            if (this.f30735m) {
                F0(bVar);
            } else {
                G0(bVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F0(b<? super T> bVar) {
        a<T> aVar = this.f30725b;
        int i10 = 1;
        boolean z10 = !this.f30727d;
        while (!this.f30731h) {
            boolean z11 = this.f30728e;
            if (!z10 || !z11 || this.f30729f == null) {
                bVar.d(null);
                if (z11) {
                    this.f30730g.lazySet((Object) null);
                    Throwable th2 = this.f30729f;
                    if (th2 != null) {
                        bVar.onError(th2);
                        return;
                    } else {
                        bVar.onComplete();
                        return;
                    }
                } else {
                    i10 = this.f30733k.addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            } else {
                aVar.clear();
                this.f30730g.lazySet((Object) null);
                bVar.onError(this.f30729f);
                return;
            }
        }
        this.f30730g.lazySet((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void G0(b<? super T> bVar) {
        int i10;
        long j10;
        boolean z10;
        a<T> aVar = this.f30725b;
        boolean z11 = true;
        boolean z12 = !this.f30727d;
        int i11 = 1;
        while (true) {
            long j11 = this.f30734l.get();
            long j12 = 0;
            while (true) {
                i10 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                if (i10 == 0) {
                    j10 = j12;
                    break;
                }
                boolean z13 = this.f30728e;
                T poll = aVar.poll();
                if (poll == null) {
                    z10 = z11;
                } else {
                    z10 = false;
                }
                T t10 = poll;
                j10 = j12;
                if (!B0(z12, z13, z10, bVar, aVar)) {
                    if (z10) {
                        break;
                    }
                    bVar.d(t10);
                    j12 = 1 + j10;
                    z11 = true;
                } else {
                    return;
                }
            }
            b<? super T> bVar2 = bVar;
            if (i10 == 0) {
                if (B0(z12, this.f30728e, aVar.isEmpty(), bVar, aVar)) {
                    return;
                }
            }
            if (!(j10 == 0 || j11 == Long.MAX_VALUE)) {
                this.f30734l.addAndGet(-j10);
            }
            i11 = this.f30733k.addAndGet(-i11);
            if (i11 != 0) {
                z11 = true;
            } else {
                return;
            }
        }
    }

    public void d(T t10) {
        xj.b.e(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f30728e && !this.f30731h) {
            this.f30725b.offer(t10);
            E0();
        }
    }

    public void e(c cVar) {
        if (this.f30728e || this.f30731h) {
            cVar.cancel();
        } else {
            cVar.r(Long.MAX_VALUE);
        }
    }

    /* access modifiers changed from: protected */
    public void n0(b<? super T> bVar) {
        if (this.f30732j.get() || !this.f30732j.compareAndSet(false, true)) {
            EmptySubscription.c(new IllegalStateException("This processor allows only a single Subscriber"), bVar);
            return;
        }
        bVar.e(this.f30733k);
        this.f30730g.set(bVar);
        if (this.f30731h) {
            this.f30730g.lazySet((Object) null);
        } else {
            E0();
        }
    }

    public void onComplete() {
        if (!this.f30728e && !this.f30731h) {
            this.f30728e = true;
            D0();
            E0();
        }
    }

    public void onError(Throwable th2) {
        xj.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f30728e || this.f30731h) {
            bk.a.s(th2);
            return;
        }
        this.f30729f = th2;
        this.f30728e = true;
        D0();
        E0();
    }

    UnicastProcessor(int i10, Runnable runnable, boolean z10) {
        this.f30725b = new a<>(xj.b.f(i10, "capacityHint"));
        this.f30726c = new AtomicReference<>(runnable);
        this.f30727d = z10;
        this.f30730g = new AtomicReference<>();
        this.f30732j = new AtomicBoolean();
        this.f30733k = new UnicastQueueSubscription();
        this.f30734l = new AtomicLong();
    }
}
