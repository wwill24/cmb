package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

abstract class t<T> {
    t() {
    }

    static <T> t<T> b(s sVar, Method method) {
        q b10 = q.b(sVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (w.j(genericReturnType)) {
            throw w.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        } else if (genericReturnType != Void.TYPE) {
            return j.f(sVar, method, b10);
        } else {
            throw w.m(method, "Service methods cannot return void.", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T a(Object[] objArr);
}
