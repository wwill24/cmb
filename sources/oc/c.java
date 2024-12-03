package oc;

public class c<T1, T2> implements vj.c<T1, T2, c<T1, T2>> {

    /* renamed from: a  reason: collision with root package name */
    private T1 f41325a;

    /* renamed from: b  reason: collision with root package name */
    private T2 f41326b;

    public c() {
    }

    /* renamed from: a */
    public c<T1, T2> apply(T1 t12, T2 t22) {
        return new c<>(t12, t22);
    }

    public T1 b() {
        return this.f41325a;
    }

    public T2 c() {
        return this.f41326b;
    }

    private c(T1 t12, T2 t22) {
        this.f41325a = t12;
        this.f41326b = t22;
    }
}
