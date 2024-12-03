package d3;

import u2.a;

public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f14428a;

    /* renamed from: b  reason: collision with root package name */
    private a<?, ?> f14429b;

    /* renamed from: c  reason: collision with root package name */
    protected T f14430c;

    public c() {
        this.f14428a = new b<>();
        this.f14430c = null;
    }

    public T a(b<T> bVar) {
        return this.f14430c;
    }

    public final T b(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        return a(this.f14428a.h(f10, f11, t10, t11, f12, f13, f14));
    }

    public final void c(a<?, ?> aVar) {
        this.f14429b = aVar;
    }

    public c(T t10) {
        this.f14428a = new b<>();
        this.f14430c = t10;
    }
}
