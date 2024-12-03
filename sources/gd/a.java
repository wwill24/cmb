package gd;

public final class a<T> implements fk.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f40861c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile fk.a<T> f40862a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f40863b = f40861c;

    private a(fk.a<T> aVar) {
        this.f40862a = aVar;
    }

    public static <P extends fk.a<T>, T> fk.a<T> a(P p10) {
        d.b(p10);
        if (p10 instanceof a) {
            return p10;
        }
        return new a(p10);
    }

    public static Object b(Object obj, Object obj2) {
        boolean z10;
        if (obj != f40861c) {
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
        T t10 = this.f40863b;
        T t11 = f40861c;
        if (t10 == t11) {
            synchronized (this) {
                t10 = this.f40863b;
                if (t10 == t11) {
                    t10 = this.f40862a.get();
                    this.f40863b = b(this.f40863b, t10);
                    this.f40862a = null;
                }
            }
        }
        return t10;
    }
}
