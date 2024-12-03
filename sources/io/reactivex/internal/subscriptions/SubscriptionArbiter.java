package io.reactivex.internal.subscriptions;

import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rn.c;

public class SubscriptionArbiter extends AtomicInteger implements c {
    private static final long serialVersionUID = -2189523197179400958L;
    c actual;
    final boolean cancelOnReplace;
    volatile boolean cancelled;
    final AtomicLong missedProduced = new AtomicLong();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicReference<c> missedSubscription = new AtomicReference<>();
    long requested;
    protected boolean unbounded;

    public SubscriptionArbiter(boolean z10) {
        this.cancelOnReplace = z10;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (getAndIncrement() == 0) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i10 = 1;
        c cVar = null;
        long j10 = 0;
        do {
            c cVar2 = this.missedSubscription.get();
            if (cVar2 != null) {
                cVar2 = this.missedSubscription.getAndSet((Object) null);
            }
            long j11 = this.missedRequested.get();
            if (j11 != 0) {
                j11 = this.missedRequested.getAndSet(0);
            }
            long j12 = this.missedProduced.get();
            if (j12 != 0) {
                j12 = this.missedProduced.getAndSet(0);
            }
            c cVar3 = this.actual;
            if (this.cancelled) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.actual = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long j13 = this.requested;
                if (j13 != Long.MAX_VALUE) {
                    j13 = b.b(j13, j11);
                    if (j13 != Long.MAX_VALUE) {
                        j13 -= j12;
                        if (j13 < 0) {
                            SubscriptionHelper.d(j13);
                            j13 = 0;
                        }
                    }
                    this.requested = j13;
                }
                if (cVar2 != null) {
                    if (cVar3 != null && this.cancelOnReplace) {
                        cVar3.cancel();
                    }
                    this.actual = cVar2;
                    if (j13 != 0) {
                        j10 = b.b(j10, j13);
                        cVar = cVar2;
                    }
                } else if (!(cVar3 == null || j11 == 0)) {
                    j10 = b.b(j10, j11);
                    cVar = cVar3;
                }
            }
            i10 = addAndGet(-i10);
        } while (i10 != 0);
        if (j10 != 0) {
            cVar.r(j10);
        }
    }

    public final void c(long j10) {
        if (!this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                b.a(this.missedProduced, j10);
                a();
                return;
            }
            long j11 = this.requested;
            if (j11 != Long.MAX_VALUE) {
                long j12 = j11 - j10;
                if (j12 < 0) {
                    SubscriptionHelper.d(j12);
                    j12 = 0;
                }
                this.requested = j12;
            }
            if (decrementAndGet() != 0) {
                b();
            }
        }
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            a();
        }
    }

    public final void g(c cVar) {
        if (this.cancelled) {
            cVar.cancel();
            return;
        }
        xj.b.e(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            c andSet = this.missedSubscription.getAndSet(cVar);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            a();
            return;
        }
        c cVar2 = this.actual;
        if (cVar2 != null && this.cancelOnReplace) {
            cVar2.cancel();
        }
        this.actual = cVar;
        long j10 = this.requested;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j10 != 0) {
            cVar.r(j10);
        }
    }

    public final void r(long j10) {
        if (SubscriptionHelper.j(j10) && !this.unbounded) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                b.a(this.missedRequested, j10);
                a();
                return;
            }
            long j11 = this.requested;
            if (j11 != Long.MAX_VALUE) {
                long b10 = b.b(j11, j10);
                this.requested = b10;
                if (b10 == Long.MAX_VALUE) {
                    this.unbounded = true;
                }
            }
            c cVar = this.actual;
            if (decrementAndGet() != 0) {
                b();
            }
            if (cVar != null) {
                cVar.r(j10);
            }
        }
    }
}
