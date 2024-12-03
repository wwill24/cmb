package io.reactivex.internal.subscribers;

import bk.a;

public final class d<T> extends c<T> {
    public void d(T t10) {
        if (this.f30702a == null) {
            this.f30702a = t10;
            this.f30704c.cancel();
            countDown();
        }
    }

    public void onError(Throwable th2) {
        if (this.f30702a == null) {
            this.f30703b = th2;
        } else {
            a.s(th2);
        }
        countDown();
    }
}
