package com.google.protobuf;

import com.google.protobuf.s;
import com.google.protobuf.s.b;
import java.io.IOException;
import java.util.Map;

abstract class o<T extends s.b<T>> {
    o() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract Object b(n nVar, l0 l0Var, int i10);

    /* access modifiers changed from: package-private */
    public abstract s<T> c(Object obj);

    /* access modifiers changed from: package-private */
    public abstract s<T> d(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean e(l0 l0Var);

    /* access modifiers changed from: package-private */
    public abstract void f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB g(Object obj, y0 y0Var, Object obj2, n nVar, s<T> sVar, UB ub2, f1<UT, UB> f1Var) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void h(y0 y0Var, Object obj, n nVar, s<T> sVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void i(ByteString byteString, Object obj, n nVar, s<T> sVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
