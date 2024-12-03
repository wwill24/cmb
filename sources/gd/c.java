package gd;

public final class c<T> implements b<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final c<Object> f40864b = new c<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    private final T f40865a;

    private c(T t10) {
        this.f40865a = t10;
    }

    public static <T> b<T> a(T t10) {
        return new c(d.c(t10, "instance cannot be null"));
    }

    public T get() {
        return this.f40865a;
    }
}
