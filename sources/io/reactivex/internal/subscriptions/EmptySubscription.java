package io.reactivex.internal.subscriptions;

import rn.b;
import yj.f;

public enum EmptySubscription implements f<Object> {
    INSTANCE;

    public static void a(b<?> bVar) {
        bVar.e(INSTANCE);
        bVar.onComplete();
    }

    public static void c(Throwable th2, b<?> bVar) {
        bVar.e(INSTANCE);
        bVar.onError(th2);
    }

    public int b(int i10) {
        return i10 & 2;
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }

    public void r(long j10) {
        SubscriptionHelper.j(j10);
    }

    public String toString() {
        return "EmptySubscription";
    }
}
