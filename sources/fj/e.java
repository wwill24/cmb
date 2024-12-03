package fj;

public final class e<T> implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final e<Object> f29646b = new e<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final T f29647a;

    private e(T t10) {
        this.f29647a = t10;
    }

    public static <T> d<T> a(T t10) {
        return new e(g.c(t10, "instance cannot be null"));
    }

    public T get() {
        return this.f29647a;
    }
}
