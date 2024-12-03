package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Method f42294a;

    /* renamed from: b  reason: collision with root package name */
    private final List<?> f42295b;

    k(Method method, List<?> list) {
        this.f42294a = method;
        this.f42295b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f42294a;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.f42294a.getDeclaringClass().getName(), this.f42294a.getName(), this.f42295b});
    }
}
