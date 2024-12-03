package androidx.work.impl.utils.futures;

public final class a<V> extends AbstractFuture<V> {
    private a() {
    }

    public static <V> a<V> s() {
        return new a<>();
    }

    public boolean o(V v10) {
        return super.o(v10);
    }

    public boolean p(Throwable th2) {
        return super.p(th2);
    }

    public boolean q(zf.a<? extends V> aVar) {
        return super.q(aVar);
    }
}
