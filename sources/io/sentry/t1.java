package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class t1<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f31634a;

    private t1(Class<T> cls) {
        this.f31634a = cls;
    }

    public static <T> t1<T> a(Class<T> cls) {
        return new t1<>(cls);
    }

    public T b() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return this.f31634a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
}
