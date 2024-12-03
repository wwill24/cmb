package androidx.concurrent.futures;

import zf.a;

public final class b<V> extends AbstractResolvableFuture<V> {
    private b() {
    }

    public static <V> b<V> a() {
        return new b<>();
    }

    public boolean set(V v10) {
        return super.set(v10);
    }

    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }

    public boolean setFuture(a<? extends V> aVar) {
        return super.setFuture(aVar);
    }
}
