package androidx.datastore.preferences.protobuf;

import java.io.IOException;

interface y0<T> {
    void a(T t10, T t11);

    void b(T t10);

    boolean c(T t10);

    int d(T t10);

    void e(T t10, x0 x0Var, n nVar) throws IOException;

    boolean equals(T t10, T t11);

    void f(T t10, Writer writer) throws IOException;

    int hashCode(T t10);

    T newInstance();
}
