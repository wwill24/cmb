package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.l;
import rn.c;
import tj.b;
import vj.a;
import vj.f;

public final class LambdaSubscriber<T> extends AtomicReference<c> implements l<T>, c, b {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final f<? super Throwable> onError;
    final f<? super T> onNext;
    final f<? super c> onSubscribe;

    public LambdaSubscriber(f<? super T> fVar, f<? super Throwable> fVar2, a aVar, f<? super c> fVar3) {
        this.onNext = fVar;
        this.onError = fVar2;
        this.onComplete = aVar;
        this.onSubscribe = fVar3;
    }

    public boolean c() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void cancel() {
        SubscriptionHelper.a(this);
    }

    public void d(T t10) {
        if (!c()) {
            try {
                this.onNext.accept(t10);
            } catch (Throwable th2) {
                uj.a.b(th2);
                ((c) get()).cancel();
                onError(th2);
            }
        }
    }

    public void dispose() {
        cancel();
    }

    public void e(c cVar) {
        if (SubscriptionHelper.h(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                uj.a.b(th2);
                cVar.cancel();
                onError(th2);
            }
        }
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                uj.a.b(th2);
                bk.a.s(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th2);
            } catch (Throwable th3) {
                uj.a.b(th3);
                bk.a.s(new CompositeException(th2, th3));
            }
        } else {
            bk.a.s(th2);
        }
    }

    public void r(long j10) {
        ((c) get()).r(j10);
    }
}
