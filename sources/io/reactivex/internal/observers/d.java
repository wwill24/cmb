package io.reactivex.internal.observers;

public final class d<T> extends c<T> {
    public void d(T t10) {
        if (this.f30087a == null) {
            this.f30087a = t10;
            this.f30089c.dispose();
            countDown();
        }
    }

    public void onError(Throwable th2) {
        if (this.f30087a == null) {
            this.f30088b = th2;
        }
        countDown();
    }
}
