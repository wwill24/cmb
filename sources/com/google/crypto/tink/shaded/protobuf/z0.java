package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.e;
import java.io.IOException;

interface z0<T> {
    void a(T t10, T t11);

    void b(T t10);

    boolean c(T t10);

    int d(T t10);

    void e(T t10, byte[] bArr, int i10, int i11, e.b bVar) throws IOException;

    boolean equals(T t10, T t11);

    void f(T t10, y0 y0Var, o oVar) throws IOException;

    void g(T t10, Writer writer) throws IOException;

    int hashCode(T t10);

    T newInstance();
}
