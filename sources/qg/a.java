package qg;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? super T> f24437a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f24438b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24439c;

    protected a() {
        Type e10 = e();
        this.f24438b = e10;
        this.f24437a = C$Gson$Types.k(e10);
        this.f24439c = e10.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    private Type e() {
        Class<a> cls = a.class;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == cls) {
                return C$Gson$Types.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == cls) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class<? super T> c() {
        return this.f24437a;
    }

    public final Type d() {
        return this.f24438b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a) || !C$Gson$Types.f(this.f24438b, ((a) obj).f24438b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f24439c;
    }

    public final String toString() {
        return C$Gson$Types.t(this.f24438b);
    }

    private a(Type type) {
        Objects.requireNonNull(type);
        Type b10 = C$Gson$Types.b(type);
        this.f24438b = b10;
        this.f24437a = C$Gson$Types.k(b10);
        this.f24439c = b10.hashCode();
    }
}
