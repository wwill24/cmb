package fj;

import fk.a;

public final class c<T> implements a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f29643c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile a<T> f29644a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f29645b = f29643c;

    private c(a<T> aVar) {
        this.f29644a = aVar;
    }

    public static <P extends a<T>, T> a<T> a(P p10) {
        g.b(p10);
        if (p10 instanceof c) {
            return p10;
        }
        return new c(p10);
    }

    private static Object b(Object obj, Object obj2) {
        boolean z10;
        if (obj != f29643c) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t10 = this.f29645b;
        T t11 = f29643c;
        if (t10 == t11) {
            synchronized (this) {
                t10 = this.f29645b;
                if (t10 == t11) {
                    t10 = this.f29644a.get();
                    this.f29645b = b(this.f29645b, t10);
                    this.f29644a = null;
                }
            }
        }
        return t10;
    }
}
