package kotlin.jvm.internal;

public final class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f32136a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32137b;

    public k(Class<?> cls, String str) {
        j.g(cls, "jClass");
        j.g(str, "moduleName");
        this.f32136a = cls;
        this.f32137b = str;
    }

    public Class<?> c() {
        return this.f32136a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && j.b(c(), ((k) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
