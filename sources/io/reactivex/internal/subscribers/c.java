package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import qj.l;

public abstract class c<T> extends CountDownLatch implements l<T> {

    /* renamed from: a  reason: collision with root package name */
    T f30702a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f30703b;

    /* renamed from: c  reason: collision with root package name */
    rn.c f30704c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f30705d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.a();
                await();
            } catch (InterruptedException e10) {
                rn.c cVar = this.f30704c;
                this.f30704c = SubscriptionHelper.CANCELLED;
                if (cVar != null) {
                    cVar.cancel();
                }
                throw ExceptionHelper.e(e10);
            }
        }
        Throwable th2 = this.f30703b;
        if (th2 == null) {
            return this.f30702a;
        }
        throw ExceptionHelper.e(th2);
    }

    public final void e(rn.c cVar) {
        if (SubscriptionHelper.k(this.f30704c, cVar)) {
            this.f30704c = cVar;
            if (!this.f30705d) {
                cVar.r(Long.MAX_VALUE);
                if (this.f30705d) {
                    this.f30704c = SubscriptionHelper.CANCELLED;
                    cVar.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }
}
