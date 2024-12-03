package m1;

import androidx.lifecycle.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class f<T extends f0> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f16282a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<a, T> f16283b;

    public f(Class<T> cls, Function1<? super a, ? extends T> function1) {
        j.g(cls, "clazz");
        j.g(function1, "initializer");
        this.f16282a = cls;
        this.f16283b = function1;
    }

    public final Class<T> a() {
        return this.f16282a;
    }

    public final Function1<a, T> b() {
        return this.f16283b;
    }
}
