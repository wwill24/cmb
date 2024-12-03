package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.t;
import com.google.crypto.tink.shaded.protobuf.t.b;
import java.io.IOException;
import java.util.Map;

abstract class p<T extends t.b<T>> {
    p() {
    }

    /* access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract Object b(o oVar, l0 l0Var, int i10);

    /* access modifiers changed from: package-private */
    public abstract t<T> c(Object obj);

    /* access modifiers changed from: package-private */
    public abstract t<T> d(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean e(l0 l0Var);

    /* access modifiers changed from: package-private */
    public abstract void f(Object obj);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB g(y0 y0Var, Object obj, o oVar, t<T> tVar, UB ub2, f1<UT, UB> f1Var) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void h(y0 y0Var, Object obj, o oVar, t<T> tVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void i(ByteString byteString, Object obj, o oVar, t<T> tVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
